package com.lblog.lblogapi.api.assembler;

import com.lblog.lblogapi.api.dto.OcorrenciaDTO;
import com.lblog.lblogapi.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaDTO toDTO(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toCollectionDTO(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
