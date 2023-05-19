package com.lblog.lblogapi.api.controller;

import com.lblog.lblogapi.api.dto.DestinatarioDTO;
import com.lblog.lblogapi.api.dto.EntregaDTO;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega) {

        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar() {

        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {

        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaDTO dto = new EntregaDTO();
                    dto.setId(entrega.getId());
                    dto.setNomeCliente(entrega.getCliente().getNome());
                    dto.setDestinatario(new DestinatarioDTO());
                    dto.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    dto.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    dto.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                    dto.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                    dto.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    dto.setTaxa(entrega.getTaxa());
                    dto.setStatus(entrega.getStatus());
                    dto.setDataPedido(entrega.getDataPedido());
                    dto.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok().body(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
