package com.labdev.labdev.controller_test;
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
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest(Carteira.class)
class CarteiraTest {

    @Autowired
	private CarteiraController carteiraController;
	
	@MockBean
	private CarteiraService carteiraService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.carteiraController);
	}
	
	/*@Test
	public void deveRetornarSucesso_QuandoBuscarFilme() {

		when(this.carteiraService.getAl(1L))
			.thenReturn(new Filme(1L, "O Poderoso Chefão", "Sem descrição"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarFilme() {
		
		when(this.filmeService.obterFilme(5L))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", 5L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarBadRequest_QuandoBuscarFilme() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", -1L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.filmeService, never()).obterFilme(-1L);
	}
    
    
    
    // ... Test methods TBA*/ 
}