package com.example.gatewayBff.api.controllers;

import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.request.ProdutoRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.response.ProdutoResponse;
import com.example.gatewayBff.api.services.ApiLojaVirtualService;
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

    @PostMapping("/fornecedor")
    public ResponseEntity<FornecedorResponse> criarFornecedor(@RequestBody FornecedorRequest fornecedor) {
        var fornecedorCriado = apiLojaVirtualService.salvarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedorCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(fornecedorCriado);
    }

    @GetMapping("fornecedor/{id}")
    public ResponseEntity<FornecedorResponse> resgatarFornecedorPorId(@PathVariable Long id){
        var fornecedor = apiLojaVirtualService.resgatarFornecedor(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping("/fornecedores")
    public ResponseEntity<List<FornecedorRequest>> resgatarTodosFornecedores() {
        var fornecedores = apiLojaVirtualService.resgatarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @PutMapping("fornecedor/{id}")
    public ResponseEntity<Void> atualizarDadosFornecedorPorId(@PathVariable Long id, @RequestBody FornecedorRequest fornecedor){
        apiLojaVirtualService.atualizarDadosFornecedor(id,fornecedor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("fornecedor/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id){
        apiLojaVirtualService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/produto")
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoRequest produto) {
        var response = apiLojaVirtualService.salvarProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(value = "produto/{id}")
    public ResponseEntity<ProdutoResponse> resgatarProdutoPorId(@PathVariable Long id) {
        var response = apiLojaVirtualService.resgatarProduto(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> resgatarTodosProdutos() {
        var response = apiLojaVirtualService.resgatarTodosProdutos();

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("produto/{id}")
    public ResponseEntity<Void> atualizarDadosProdutoPorId(@PathVariable Long id, @RequestBody ProdutoResponse produto){
        apiLojaVirtualService.atualizarDadosProduto(id,produto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("produto/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id){
        apiLojaVirtualService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
