
package com.labdev.labdev.carteira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labdev.labdev.carteira.exception.SaldoInsuficienteException;
import com.labdev.labdev.carteira.transacao.TransacaoRequest;

@CrossOrigin
@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    private final CarteiraService carteiraService;

    @Autowired
    public CarteiraController(
            CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping(path = "/transferir")
    public ResponseEntity<Comprovante> transferir(@RequestBody TransacaoRequest transacaoRequest)
            throws SaldoInsuficienteException {
                System.out.println("Chamando Service");
                
        Comprovante comprovante = carteiraService.transferir(transacaoRequest);
        if (comprovante == null) {
            throw new SaldoInsuficienteException("Id not found in the request");
        }
        return new ResponseEntity<>(comprovante, HttpStatus.OK);
    }

    @RequestMapping(path = "/print")
    public void print(){
        carteiraService.printCarteiras();
        
    }

}
