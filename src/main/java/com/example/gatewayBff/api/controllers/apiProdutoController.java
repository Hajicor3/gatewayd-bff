package com.example.gatewayBff.api.controllers;

import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.services.ApiProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
@RequiredArgsConstructor
public class apiProdutoController {

    private final ApiProdutoService apiProdutoService;

    @PostMapping
    public ResponseEntity<FornecedorResponse> criarFornecedor(@RequestBody FornecedorRequest fornecedor) {
        var fornecedorCriado = apiProdutoService.salvar(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedorCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(fornecedorCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponse> resgatarFornecedorPorId(@PathVariable Long id){
        var fornecedor = apiProdutoService.resgatar(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorRequest>> resgatarTodosFornecedores() {
        var fornecedores = apiProdutoService.resgatarTodos();
        return ResponseEntity.ok().body(fornecedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarDadosFornecedor(@PathVariable Long id, @RequestBody FornecedorRequest fornecedor){
        apiProdutoService.atualizarDados(id,fornecedor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id){
        apiProdutoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
