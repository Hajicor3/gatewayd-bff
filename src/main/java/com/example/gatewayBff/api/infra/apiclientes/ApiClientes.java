package com.example.gatewayBff.api.infra.apiclientes;

import com.example.gatewayBff.api.request.ClienteRequest;
import com.example.gatewayBff.api.response.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "api-cliente", url = "http://localhost:8082/clientes")
public interface ApiClientes {

    @PostMapping
    public ResponseEntity<ClienteResponse> registrarCliente(@RequestBody ClienteRequest cliente);

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponse> resgatarClientePorId(@PathVariable Long id);

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarUsuarioPorId(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado);
}
