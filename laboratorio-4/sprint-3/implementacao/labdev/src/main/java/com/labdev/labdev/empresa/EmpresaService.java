package com.labdev.labdev.empresa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getAllEmpresas() {
        return this.empresaRepository.findAll();
    }

    public void save(Empresa empresa) {
        this.empresaRepository.save(empresa);
    }

    public Empresa findEmpresaById(long id) {
        return this.empresaRepository.findEmpresaById(id);
    }

    public void deleteEmpresa(long id) {
        if (!empresaRepository.existsById(id))
            throw new IllegalStateException("Empresa do id:" + id + " não encontrado");
        empresaRepository.deleteById(id);
    }

    @Transactional
    public void updateEmpresa(
        long id, 
        String nome, 
        String email, 
        String senha, 
        String cpf, 
        String rg ) {
            if (!empresaRepository.existsById(id))
                throw new IllegalStateException("Empresa do id:" + id + " não encontrado");
            Empresa empresa = empresaRepository.findEmpresaById(id);
            if (empresaStringVerification(nome, empresa.getNome())) {
                empresa.setNome(nome);
            }
            if (empresaStringVerification(email, empresa.getEmail())) {
                empresa.setEmail(email);
            }
            if (empresaStringVerification(senha, empresa.getSenha())) {
                empresa.setSenha(senha);
            }
            if (empresaStringVerification(cpf, empresa.getCpf())) {
                if (cpfVerification(cpf)) {
                    throw new IllegalStateException("cpf em uso ou inexitente");
                }
                empresa.setCpf(cpf);
            }
            if (empresaStringVerification(rg, empresa.getRg())) {
                empresa.setRg(rg);
            }
        

    }

    private String cpfFormatter(String cpf) {
        return cpf;
    }

    private boolean empresaStringVerification(String newStr, String actual) {
        return (newStr != null && newStr.length() > 0 && !newStr.equals(actual));
    }

    private boolean cpfVerification(String cpf) {
        Optional<Empresa> empresaOptional = empresaRepository.findEmpresaByCpf(cpf);
        return (empresaOptional.isPresent());
    }
    
}
