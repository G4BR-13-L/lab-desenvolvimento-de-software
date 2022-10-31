package com.labdev.labdev.model;

import java.util.UUID;

public class Cupom {
    
    private String codigo;
    public Cupom(){
        this.codigo = UUID.randomUUID().toString();
    }
}
