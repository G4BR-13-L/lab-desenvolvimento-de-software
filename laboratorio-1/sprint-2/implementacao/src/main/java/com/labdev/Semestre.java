package com.labdev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Semestre {
    private String id;
    private String nome;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private List<Disciplina> disciplinas;
    public Semestre(){
        this.disciplinas = new ArrayList<>();
    }
}
