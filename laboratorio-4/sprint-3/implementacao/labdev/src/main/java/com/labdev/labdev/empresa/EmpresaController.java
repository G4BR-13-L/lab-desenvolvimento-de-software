package com.labdev.labdev.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas(){
        return new ResponseEntity<>(this.empresaService.getAllEmpresas(), HttpStatus.OK);
    }

    @GetMapping(path = "{empresaId}")
    public Empresa getEmpresa(@PathVariable("empresaId") long id) {
        return empresaService.findEmpresaById(id);
    }

    @DeleteMapping(path = "{empresaId}")
    public void deleteEmpresa(@PathVariable("empresaId") long id) {
        empresaService.deleteEmpresa(id);
    }

    @PutMapping(path = "{empresaId}")
    public void updateEmpresa(@PathVariable("empresaId") long empresaId,
            @RequestParam(required = false) String nome, @RequestParam(required = false) String email,
            @RequestParam(required = false) String senha, @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String rg, @RequestParam(required = false) String curso,
            @RequestParam(required = false) double saldo) {
        empresaService.updateEmpresa(empresaId, nome, email, senha, cpf, rg);
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar( 
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) String email, 
        @RequestParam(required = false) String senha, 
        @RequestParam(required = true) String cnpj
    ) {
        Empresa empresa = new Empresa(nome, email, senha, cnpj);
        this.empresaService.save(empresa);
        return "redirect:/usuario/logar";
    }
}
