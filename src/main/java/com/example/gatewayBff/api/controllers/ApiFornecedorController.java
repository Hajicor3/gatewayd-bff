package com.example.gatewayBff.api.controllers;

import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.services.ApiFornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ApiFornecedorController {

    private final ApiFornecedorService apiFornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorResponse> criarFornecedor(@RequestBody FornecedorRequest fornecedor) {
        var fornecedorCriado = apiFornecedorService.salvar(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedorCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(fornecedorCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponse> resgatarFornecedorPorId(@PathVariable Long id){
        var fornecedor = apiFornecedorService.resgatar(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorRequest>> resgatarTodosFornecedores() {
        var fornecedores = apiFornecedorService.resgatarTodos();
        return ResponseEntity.ok().body(fornecedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarDadosFornecedor(@PathVariable Long id, @RequestBody FornecedorRequest fornecedor){
        apiFornecedorService.atualizarDados(id,fornecedor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id){
        apiFornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
