package com.lblog.lblogapi.api.controller;

import com.lblog.lblogapi.api.assembler.OcorrenciaAssembler;
import com.lblog.lblogapi.api.dto.OcorrenciaDTO;
import com.lblog.lblogapi.api.dto.input.OcorrenciaInput;
import com.lblog.lblogapi.domain.model.Ocorrencia;
import com.lblog.lblogapi.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;

    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        Ocorrencia ocorrencia = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toDTO(ocorrencia);
    }

}
