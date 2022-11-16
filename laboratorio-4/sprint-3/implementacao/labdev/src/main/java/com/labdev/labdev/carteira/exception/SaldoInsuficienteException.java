package com.labdev.labdev.carteira.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED, reason="Saldo insuficiente")
public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(String msg){
        super(msg);
    }
}
