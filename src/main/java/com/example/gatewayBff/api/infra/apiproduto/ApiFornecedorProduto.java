package com.example.gatewayBff.api.infra.apiproduto;

import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.request.ProdutoRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.response.ProdutoResponse;
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

    @PostMapping(value = "/produtos")
    public ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest produto);

    @GetMapping(value = "produtos/{id}")
    public ResponseEntity<ProdutoResponse> pegarProduto(@PathVariable Long id);

    @GetMapping(value = "/produtos")
    public ResponseEntity<List<ProdutoResponse>> listaDeProdutos();

    @PutMapping(value = "produtos/{id}")
    public ResponseEntity<Void> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoResponse produto);

    @DeleteMapping(value = "produtos/{id}")
    public ResponseEntity<Void> deleteProdutoPorId(@PathVariable Long id);
}
