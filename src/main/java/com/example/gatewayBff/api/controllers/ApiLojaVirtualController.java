package com.example.gatewayBff.api.controllers;

import com.example.gatewayBff.api.request.ClienteRequest;
import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.request.PedidoRequest;
import com.example.gatewayBff.api.request.ProdutoRequest;
import com.example.gatewayBff.api.response.ClienteResponse;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.response.PedidoResponse;
import com.example.gatewayBff.api.response.ProdutoResponse;
import com.example.gatewayBff.api.services.ApiClienteService;
import com.example.gatewayBff.api.services.ApiFornecedoresService;
import com.example.gatewayBff.api.services.ApiLojaVirtualService;
import com.example.gatewayBff.api.services.ApiProdutosService;
import feign.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "api-LojaVirtual")
@CrossOrigin("http://localhost:3000")
public class ApiLojaVirtualController {

    private final ApiLojaVirtualService apiLojaVirtualService;
    private final ApiProdutosService apiProdutosService;
    private final ApiClienteService apiClienteService;
    private final ApiFornecedoresService apiFornecedoresService;

    @PostMapping("/fornecedor")
    public ResponseEntity<FornecedorResponse> criarFornecedor(@RequestBody FornecedorRequest fornecedor) {
        var fornecedorCriado = apiFornecedoresService.salvarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedorCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(fornecedorCriado);
    }

    @GetMapping("fornecedor/{id}")
    public ResponseEntity<FornecedorResponse> resgatarFornecedorPorId(@PathVariable Long id){
        var fornecedor = apiFornecedoresService.resgatarFornecedor(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping("/fornecedores")
    public ResponseEntity<List<FornecedorRequest>> resgatarTodosFornecedores() {
        var fornecedores = apiFornecedoresService.resgatarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @PutMapping("fornecedor/{id}")
    public ResponseEntity<Void> atualizarDadosFornecedorPorId(@PathVariable Long id, @RequestBody FornecedorRequest fornecedor){
        apiFornecedoresService.atualizarDadosFornecedor(id,fornecedor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("fornecedor/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id){
        apiFornecedoresService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/produto")
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoRequest produto) {
        var response = apiProdutosService.salvarProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(value = "produto/{id}")
    public ResponseEntity<ProdutoResponse> resgatarProdutoPorId(@PathVariable Long id) {
        var response = apiProdutosService.resgatarProduto(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> resgatarTodosProdutos() {
        var response = apiProdutosService.resgatarTodosProdutos();

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("produto/{id}")
    public ResponseEntity<Void> atualizarDadosProdutoPorId(@PathVariable Long id, @RequestBody ProdutoResponse produto){
        apiProdutosService.atualizarDadosProduto(id,produto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("produto/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id){
        apiProdutosService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponse> registrarCliente(@RequestBody ClienteRequest cliente) {
        var response = apiClienteService.salvarCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponse> resgatarClientePorId(@PathVariable Long id) {
        var response = apiClienteService.resgatarCliente(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Void> atualizarClientePorId(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
        apiClienteService.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cliente/pedido")
    public ResponseEntity<PedidoResponse> registrarPedidoCliente(@RequestBody PedidoRequest pedido) {
        var response = apiClienteService.registrarPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
