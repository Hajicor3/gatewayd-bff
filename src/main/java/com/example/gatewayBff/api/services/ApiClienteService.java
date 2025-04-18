package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiclientes.ApiClientes;
import com.example.gatewayBff.api.request.ClienteRequest;
import com.example.gatewayBff.api.request.PedidoRequest;
import com.example.gatewayBff.api.response.ClienteResponse;
import com.example.gatewayBff.api.response.PedidoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiClienteService {

    private final ApiClientes apiClientesRepository;

    @Transactional
    public ClienteResponse salvarCliente(ClienteRequest cliente) {
        return apiClientesRepository.registrarCliente(cliente).getBody();
    }

    @Transactional
    public ClienteResponse resgatarCliente(Long id) {
        return apiClientesRepository.resgatarClientePorId(id).getBody();
    }

    @Transactional
    public void atualizarCliente(Long id, ClienteRequest clienteAtualizado) {
        apiClientesRepository.atualizarUsuarioPorId(id, clienteAtualizado);
    }

    @Transactional
    public PedidoResponse registrarPedido(PedidoRequest pedido) {
        return apiClientesRepository.registrarPedido(pedido).getBody();
    }
}
