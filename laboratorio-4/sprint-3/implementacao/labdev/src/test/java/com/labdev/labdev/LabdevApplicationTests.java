package com.labdev.labdev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labdev.labdev.carteira.Carteira;
import com.labdev.labdev.carteira.CarteiraRepository;
import com.labdev.labdev.carteira.CarteiraService;
import com.labdev.labdev.carteira.CarteiraController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest
class LabdevApplicationTests {

	@Test
	void contextLoads() {
	}

}


