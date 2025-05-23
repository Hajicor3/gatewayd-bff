package com.example.gatewayBff.api.infra.apiestoque;

import com.example.gatewayBff.api.request.MovimentacaoRequest;
import com.example.gatewayBff.api.response.MovimentacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Api-Estoque", url = "${api.estoque.url}")
public interface ApiEstoque {

    @PostMapping(value = "/movimentacoes")
    public ResponseEntity<MovimentacaoResponse> salvarMovimentacao(@RequestBody MovimentacaoRequest movimentacaoRequest);

    @GetMapping(value = "movimentacoes/produto/list/{id}")
    public ResponseEntity<List<MovimentacaoResponse>> resgatarMovimentacoesPorIdProduto(@PathVariable Long id);
}
