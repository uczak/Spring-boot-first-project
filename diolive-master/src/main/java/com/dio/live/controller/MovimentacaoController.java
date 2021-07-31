package com.dio.live.controller;

import com.dio.live.ServiceRN.JornadaService;
import com.dio.live.ServiceRN.MovimentacaoService;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Movimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getJornadaList() {
        return movimentacaoService.getMovimentacaoList();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getJornadaListId(@PathVariable("idMovimentacao") Movimentacao.MovimentacaoId idMovimentacao) throws Exception {
        return ResponseEntity.ok(movimentacaoService.getById(idMovimentacao).orElseThrow(() -> new Exception("Movimentacao not found.")));
    }

    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping("/{idMovimentacao}")
    public ResponseEntity deleteById(@PathVariable("idMovimentacao") Movimentacao.MovimentacaoId idMovimentacao) throws Exception {
        try{
            movimentacaoService.deleteMovimentacao(idMovimentacao);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();
    }
}
