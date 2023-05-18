package com.lblog.lblogapi.controller;

import com.lblog.lblogapi.domain.model.Cliente;
import com.lblog.lblogapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {

        return clienteRepository.findAll();
    }

}
