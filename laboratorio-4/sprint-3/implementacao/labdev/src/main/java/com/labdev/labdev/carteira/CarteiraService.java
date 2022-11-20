package com.labdev.labdev.carteira;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdev.labdev.carteira.extrato.Extrato;
import com.labdev.labdev.carteira.extrato.ExtratoRequest;
import com.labdev.labdev.carteira.transacao.Transacao;
import com.labdev.labdev.carteira.transacao.TransacaoRepository;
import com.labdev.labdev.carteira.transacao.TransacaoRequest;
import com.labdev.labdev.usuario.Usuario;
import com.labdev.labdev.usuario.UsuarioRepository;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final UsuarioRepository usuarioRepository;
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public CarteiraService(
            CarteiraRepository carteiraRepository,
            UsuarioRepository usuarioRepository,
            TransacaoRepository transacaoRepository) {
        this.carteiraRepository = carteiraRepository;
        this.usuarioRepository = usuarioRepository;
        this.transacaoRepository = transacaoRepository;
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

        Transacao transacao = new Transacao(remetente.getCarteira(), destinatario.getCarteira(),
                transacaoRequest.getValor());
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

    @Transactional
    public Extrato gerarExtrato(ExtratoRequest extratoRequest) {
        Usuario usuario = usuarioRepository.getReferenceById(extratoRequest.getUsuario_id());
        Carteira carteira = usuario.getCarteira();
        Extrato extrato = new Extrato(carteira.getTransacoes(), carteira.getSaldo());
        return extrato;
    }
}
