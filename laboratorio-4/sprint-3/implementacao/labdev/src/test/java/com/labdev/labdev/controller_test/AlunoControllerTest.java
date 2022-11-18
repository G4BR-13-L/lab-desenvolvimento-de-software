package com.labdev.labdev.controller_test;
import org.hibernate.mapping.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.labdev.labdev.aluno.AlunoController;
import com.labdev.labdev.aluno.AlunoService;
import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.carteira.Carteira;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest(Carteira.class)
class AlunoControllerTest {

    @Autowired
	private AlunoController alunoController;
	
	@MockBean
	private AlunoService alunoService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.alunoController);
	}
	
	/*@Test
	public void deveRetornarSucesso_QuandoBuscarFilme() {

		when(this.alunoService.getAllAlunos())
			.thenReturn();
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/aluno", 1L)
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