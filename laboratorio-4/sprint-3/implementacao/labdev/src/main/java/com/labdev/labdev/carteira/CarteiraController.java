
package com.labdev.labdev.carteira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labdev.labdev.carteira.cupom.Cupom;
import com.labdev.labdev.carteira.exception.SaldoInsuficienteException;
import com.labdev.labdev.carteira.extrato.Extrato;
import com.labdev.labdev.carteira.extrato.ExtratoRequest;
import com.labdev.labdev.carteira.saldo.SaldoRequest;
import com.labdev.labdev.carteira.transacao.TransacaoRequest;
import com.labdev.labdev.usuario.Usuario;
import com.labdev.labdev.usuario.UsuarioRepository;
import com.labdev.labdev.usuario.UsuarioService;
import com.labdev.labdev.vantagem.VantagemRequest;

@CrossOrigin
@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    private final CarteiraService carteiraService;

    @Autowired
    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @GetMapping(value = "/transferir", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comprovante> transferir(@RequestBody TransacaoRequest transacaoRequest)
            throws SaldoInsuficienteException {
        System.out.println("Chamando Service");

        Comprovante comprovante = carteiraService.transferir(transacaoRequest);
        if (comprovante == null) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        return ResponseEntity.ok(comprovante);
    }

    @RequestMapping(path = "/print")
    public void print() {
        carteiraService.printCarteiras();
    }

    @GetMapping(value = "/extrato", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Extrato> extrato(@RequestBody ExtratoRequest ExtratoRequest) {
        Extrato extrato = carteiraService.gerarExtrato(ExtratoRequest);
        return ResponseEntity.ok(extrato);

    }

    @GetMapping(value = "/trocar-vantagem", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cupom> trocarVantagem(@RequestBody VantagemRequest vantagemRequest)
            throws SaldoInsuficienteException {
        System.out.println("Chamando Service");

        Cupom cupom = carteiraService.trocarVantagem(vantagemRequest);
        if (cupom == null) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        return ResponseEntity.ok(cupom);
    }

    @GetMapping(value = "/saldo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saldo(@RequestBody SaldoRequest saldoRequest) {
        int saldo = this.carteiraService.saldo(saldoRequest.getUsuario_id());
        if (saldo < 0) {
            throw new RuntimeException("Saldo invalido!");
        }
        return ResponseEntity.ok("{\"saldo\":\"" + saldo + "\"}");
    }
}
