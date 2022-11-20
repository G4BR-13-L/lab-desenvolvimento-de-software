package com.labdev.labdev.vantagem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vantagem")
public class VantagemController {

    private final VantagemService vantagemService;

    @Autowired
    public VantagemController(VantagemService vantagemService) {
        this.vantagemService = vantagemService;
    }

    @GetMapping
    public ResponseEntity<List<Vantagem>> getAllVantagens() {
        return new ResponseEntity<>(this.vantagemService.getAllVantagens(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public void cadastrarVantagem(@RequestBody Vantagem vantagem) {
        this.vantagemService.save(vantagem);
    }

    @GetMapping(path = "{vantagemId}")
    public Vantagem getVantagem(@PathVariable("vantagemId") long id) {
        return vantagemService.findVantagemById(id);
    }

    @DeleteMapping(path = "{vantagemId}")
    public void deleteVantagem(@PathVariable("vantagemId") long id) {
        vantagemService.deleteVantagem(id);
    }

    @PutMapping(path = "{vantagemId}")
    public void updateVantagem(@PathVariable("vantagemId") long vantagemId,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String foto,
            @RequestParam(required = false) int custo,
            @RequestParam(required = false) boolean ativa) {
        vantagemService.updateVantagem(vantagemId, nome, descricao, foto, custo, ativa);
    }
}
