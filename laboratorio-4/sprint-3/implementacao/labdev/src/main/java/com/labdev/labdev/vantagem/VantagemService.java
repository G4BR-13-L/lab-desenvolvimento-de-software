package com.labdev.labdev.vantagem;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VantagemService {
    private final VantagemRepository vantagemRepository;

    @Autowired
    public VantagemService(VantagemRepository vantagemRepository) {
        this.vantagemRepository = vantagemRepository;
    }

    public List<Vantagem> getAllVantagens() {
        return this.vantagemRepository.findAll();
    }

    public void save(Vantagem vantagem) {
        this.vantagemRepository.save(vantagem);
    }

    public Vantagem findVantagemById(long id) {
        return this.vantagemRepository.findVantagemById(id);
    }

    public void deleteVantagem(long id) {
        if (!vantagemRepository.existsById(id))
            throw new IllegalStateException("Vantagem do id:" + id + " não encontrado");
        vantagemRepository.deleteById(id);
    }

    @Transactional
    public void updateVantagem(
            long id,
            String nome,
            String descricao,
            String foto,
            int custo) {
        if (!vantagemRepository.existsById(id))
            throw new IllegalStateException("Vantagem do id:" + id + " não encontrado");
        Vantagem vantagem = vantagemRepository.findVantagemById(id);
        if (vantagemStringVerification(nome, vantagem.getNome())) {
            vantagem.setNome(nome);
        }
        if (vantagemStringVerification(descricao, vantagem.getDescricao())) {
            vantagem.setDescricao(descricao);
        }
        if (vantagemStringVerification(foto, vantagem.getFoto())) {
            vantagem.setFoto(foto);
        }
        if (custo != vantagem.getCusto()) {
            vantagem.setCusto(custo);
        }
    }

    private boolean vantagemStringVerification(String newStr, String actual) {
        return (newStr != null && newStr.length() > 0 && !newStr.equals(actual));
    }
}
