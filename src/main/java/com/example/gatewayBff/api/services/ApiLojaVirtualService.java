package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiclientes.ApiClientes;
import com.example.gatewayBff.api.infra.apiproduto.ApiFornecedorProduto;
import com.example.gatewayBff.api.request.ClienteRequest;
import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.request.PedidoRequest;
import com.example.gatewayBff.api.request.ProdutoRequest;
import com.example.gatewayBff.api.response.ClienteResponse;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.response.PedidoResponse;
import com.example.gatewayBff.api.response.ProdutoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiLojaVirtualService {
}
