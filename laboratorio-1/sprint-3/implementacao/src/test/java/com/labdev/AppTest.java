package com.labdev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

class AppTest {
    @Test
    void testApp() {
        assertEquals(1, 1);
    }
}

@Nested
class SistemaSecretariaTest {
    MenuGlobal menuGlobal;

    @BeforeEach
    void setup(){
        menuGlobal = MenuGlobal.getInstance();
        menuGlobal.iniciar();
    }

    @Test
    void addCurso() {
        
        SistemaSecretaria.getInstance().adicionarCurso("EngSoft", 2);
        assertEquals(SistemaSecretaria.getInstance().procurarCurso("EngSoft"), "EngSoft");
    }
}
