package com.lblog.lblogapi.assembler;

import com.lblog.lblogapi.api.dto.EntregaDTO;
import com.lblog.lblogapi.api.dto.input.EntregaInput;
import com.lblog.lblogapi.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaDTO toDTO(Entrega entrega) {
        return modelMapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toColectionDTO(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toDTO)
                .toList();
    }

    public Entrega toEntity(EntregaInput entregaInput) {
        return modelMapper.map(entregaInput, Entrega.class);
    }

}
