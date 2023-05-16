package com.lblog.lblogapi.controller;

import com.lblog.lblogapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("John");
        cliente1.setTelefone("86 98888-8888");
        cliente1.setEmail("johnsnow@gmail.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Marie");
        cliente2.setTelefone("86 96666-6666");
        cliente2.setEmail("mariesnow@gmail.com");

        return Arrays.asList(cliente1, cliente2);
    }

}
