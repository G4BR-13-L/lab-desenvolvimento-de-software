package com.labdev.labdev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labdev.labdev.carteira.Carteira;
import com.labdev.labdev.carteira.CarteiraAluno;
import com.labdev.labdev.carteira.CarteiraAlunoRepository;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;
import com.labdev.labdev.usuario.Usuario;

@SpringBootTest
class LabdevApplicationTests {

	@Test
	void contextLoads() {
	}

}

@WebMvcTest(CarteiraAluno.class)
class CarteiraAlunoTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    CarteiraAlunoRepository carteiraAlunoRepository;
    
    
    
    // ... Test methods TBA
}
