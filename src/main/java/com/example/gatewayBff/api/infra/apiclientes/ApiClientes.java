package com.example.gatewayBff.api.infra.apiclientes;

import com.example.gatewayBff.api.request.ClienteRequest;
import com.example.gatewayBff.api.request.PedidoRequest;
import com.example.gatewayBff.api.response.ClienteResponse;
import com.example.gatewayBff.api.response.PedidoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "api-cliente", url = "${api.clientes.url}")
public interface ApiClientes {

    @PostMapping
    public ResponseEntity<ClienteResponse> registrarCliente(@RequestBody ClienteRequest cliente);

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponse> resgatarClientePorId(@PathVariable Long id);

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarUsuarioPorId(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado);

    @PostMapping(value = "/pedido")
    public ResponseEntity<PedidoResponse> registrarPedido(@RequestBody PedidoRequest pedido);
}
