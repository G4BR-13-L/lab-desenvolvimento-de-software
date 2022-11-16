package com.labdev.labdev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labdev.labdev.carteira.Carteira;
import com.labdev.labdev.carteira.CarteiraRepository;

@SpringBootTest
class LabdevApplicationTests {

	@Test
	void contextLoads() {
	}

}

@WebMvcTest(Carteira.class)
class CarteiraTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    CarteiraRepository carteiraRepository;
    
    
    
    // ... Test methods TBA
}
