package com.lblog.lblogapi.domain.service;

import com.lblog.lblogapi.domain.model.Entrega;
import com.lblog.lblogapi.domain.model.StatusEntrega;
import com.lblog.lblogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entrega.setStatus(StatusEntrega.FINALIZADA);

        entregaRepository.save(entrega);
    }

}
