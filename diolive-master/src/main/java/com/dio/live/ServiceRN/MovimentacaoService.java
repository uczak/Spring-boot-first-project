package com.dio.live.ServiceRN;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Movimentacao;
import com.dio.live.repositoryBD.JornadaRepository;
import com.dio.live.repositoryBD.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao saveMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao getMovimentacao(Movimentacao Movimentacao) {
        return movimentacaoRepository.getOne(Movimentacao.getMovimentacaoId());
    }

    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> getById(Movimentacao.MovimentacaoId idMovimentacao) {
        return movimentacaoRepository.findById(idMovimentacao);
    }

    public Movimentacao updateMovimentacao(Movimentacao jornadaTrabalho) {
        return movimentacaoRepository.save(jornadaTrabalho);
    }

    public void deleteMovimentacao(Movimentacao.MovimentacaoId idMovimentacao) {
        movimentacaoRepository.deleteById(idMovimentacao);
    }
}
