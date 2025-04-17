package com.example.gatewayBff.api.infra.apiproduto;

import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "api-fornecedor/produto", url = "http://localhost:8080")
public interface ApiFornecedorProduto {

    @PostMapping(value = "/fornecedores")
    ResponseEntity<FornecedorResponse> criarFornecedor(@RequestBody FornecedorRequest fornecedor);

    @GetMapping(value = "fornecedores/{id}")
    public ResponseEntity<FornecedorResponse> fornecedorPorId(@PathVariable Long id);

    @GetMapping(value = "/fornecedores")
    public ResponseEntity<List<FornecedorRequest>> listaFornecedores();

    @DeleteMapping(value = "fornecedores/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id);

    @PutMapping(value = "fornecedores/{id}")
    public ResponseEntity<Void> atualizarFornecedor(@PathVariable Long id,@RequestBody FornecedorRequest fornecedor);
}
