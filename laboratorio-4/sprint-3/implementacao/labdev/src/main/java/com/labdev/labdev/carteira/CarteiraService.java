package com.labdev.labdev.carteira;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdev.labdev.carteira.cupom.Cupom;
import com.labdev.labdev.carteira.cupom.CupomRepository;
import com.labdev.labdev.carteira.extrato.Extrato;
import com.labdev.labdev.carteira.extrato.ExtratoRequest;
import com.labdev.labdev.carteira.resgate.ResgateVantagem;
import com.labdev.labdev.carteira.resgate.ResgateVantagemRepository;
import com.labdev.labdev.carteira.transacao.Transacao;
import com.labdev.labdev.carteira.transacao.TransacaoRepository;
import com.labdev.labdev.carteira.transacao.TransacaoRequest;
import com.labdev.labdev.usuario.Usuario;
import com.labdev.labdev.usuario.UsuarioRepository;
import com.labdev.labdev.vantagem.Vantagem;
import com.labdev.labdev.vantagem.VantagemRepository;
import com.labdev.labdev.vantagem.VantagemRequest;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final UsuarioRepository usuarioRepository;
    private final TransacaoRepository transacaoRepository;
    private final VantagemRepository vantagemRepository;
    private final ResgateVantagemRepository resgateVantagemRepository;
    private final CupomRepository cupomRepository;


    @Autowired
    public CarteiraService(
            CarteiraRepository carteiraRepository,
            UsuarioRepository usuarioRepository,
            TransacaoRepository transacaoRepository,
            VantagemRepository vantagemRepository,
            ResgateVantagemRepository resgateVantagemRepository,
            CupomRepository cupomRepository
            ) {
        this.carteiraRepository = carteiraRepository;
        this.usuarioRepository = usuarioRepository;
        this.transacaoRepository = transacaoRepository;
        this.vantagemRepository = vantagemRepository;
        this.resgateVantagemRepository = resgateVantagemRepository;
        this.cupomRepository = cupomRepository;
    }

    public void printCarteiras() {
        List<Usuario> cart = usuarioRepository.findAll();
        cart.stream()
                .forEach((e) -> System.out.println(e.getCarteira().getId() + " S: " + e.getCarteira().getSaldo()));
    }

    // @Transactional
    public Comprovante transferir(TransacaoRequest transacaoRequest) {
        Usuario remetente = usuarioRepository.getReferenceById(transacaoRequest.getRemetente_id());
        Usuario destinatario = usuarioRepository.getReferenceById(transacaoRequest.getDestinatario_id());

        Transacao transacao = new Transacao(remetente.getId(), destinatario.getId(),transacaoRequest.getValor());
        if (consultarSaldo(remetente.getCarteira().getSaldo(), transacaoRequest.getValor())) {
            System.out.println("Saldo Consultado");

            remetente.getCarteira().descontarSaldo(transacao.getValor());
            destinatario.getCarteira().incrementarSaldo(transacao.getValor());

            remetente.getCarteira().addTransacao(transacao);
            destinatario.getCarteira().addTransacao(transacao);

            System.out.println("Destinatario Notificado por email");

            usuarioRepository.save(remetente);
            usuarioRepository.save(destinatario);
            transacaoRepository.save(transacao);
            return new Comprovante(
                    transacao.getData(),
                    destinatario.getNome(),
                    remetente.getNome(),
                    transacao.getValor());
        } else {
            return null;
        }

    }

    private boolean consultarSaldo(int saldo, int valor) {
        if (saldo >= valor) {
            return true;
        }
        return false;
    }

    public Extrato gerarExtrato(ExtratoRequest extratoRequest) {
        Usuario usuario = usuarioRepository.getReferenceById(extratoRequest.getUsuario_id());
        Carteira carteira = usuario.getCarteira();
        return new Extrato(carteira.getTransacoes(), carteira.getSaldo());
      
    }

    public Cupom trocarVantagem(VantagemRequest vantagemRequest) {
        Usuario usuario = usuarioRepository.getReferenceById(vantagemRequest.getUsuario_id());
        Vantagem vantagem = vantagemRepository.getReferenceById(vantagemRequest.getVantagem_id());
        System.out.println(vantagem.toString());
        System.out.println(usuario.toString());
        
        if (usuario.getCarteira().getSaldo() >= vantagem.getCusto()) {
            System.out.println("Saldo Consultado");
            
            Cupom cupom = new Cupom();
            System.out.println(cupom.toString());
            ResgateVantagem rv = new ResgateVantagem(vantagem, cupom);
            
            usuario.getCarteira().descontarSaldo(rv.getVantagem().getCusto());
            usuario.getCarteira().addResgateVantagem(rv);

            System.out.println(rv.getCupom().getCodigo());
            System.out.println(usuario.getCarteira().toString());
            System.out.println("Destinatario Notificado por email");
            cupomRepository.save(cupom);
            resgateVantagemRepository.save(rv);
            usuarioRepository.save(usuario);
            
            //return rv.getCupom();
            return cupom;
        } else {
            return null;
        }
    }
}
