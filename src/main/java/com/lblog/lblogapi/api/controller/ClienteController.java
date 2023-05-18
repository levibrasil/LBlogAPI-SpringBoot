package com.lblog.lblogapi.api.controller;

import com.lblog.lblogapi.domain.model.Cliente;
import com.lblog.lblogapi.domain.repository.ClienteRepository;
import com.lblog.lblogapi.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {

        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long clienteId) {
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//
//        if (cliente.isPresent()) {
//            return ResponseEntity.ok().body(cliente.get());
//        }
//
//        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable Long clienteId,
            @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        catalogoClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }

}
