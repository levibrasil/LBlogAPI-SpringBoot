package com.lblog.lblogapi.domain.service;

import com.lblog.lblogapi.domain.exception.EntidadeNaoEncontradaException;
import com.lblog.lblogapi.domain.model.Entrega;
import com.lblog.lblogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }

}
