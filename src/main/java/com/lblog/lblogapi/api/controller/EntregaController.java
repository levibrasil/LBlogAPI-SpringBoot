package com.lblog.lblogapi.api.controller;

import com.lblog.lblogapi.api.dto.DestinatarioDTO;
import com.lblog.lblogapi.api.dto.EntregaDTO;
import com.lblog.lblogapi.api.dto.input.EntregaInput;
import com.lblog.lblogapi.assembler.EntregaAssembler;
import com.lblog.lblogapi.domain.model.Entrega;
import com.lblog.lblogapi.domain.repository.EntregaRepository;
import com.lblog.lblogapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;

    private SolicitacaoEntregaService solicitacaoEntregaService;

    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);

        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toDTO(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDTO> listar() {

        return entregaAssembler.toColectionDTO(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {

        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok().body(entregaAssembler.toDTO(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

}
