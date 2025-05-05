package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiproduto.ApiFornecedorProduto;
import com.example.gatewayBff.api.request.ProdutoRequest;
import com.example.gatewayBff.api.response.ProdutoResponse;
import com.example.gatewayBff.api.response.ProdutoResponseMin;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiProdutosService {

    private final ApiFornecedorProduto apiFornecedorProdutoRepository;

    @Transactional
    public ProdutoResponse salvarProduto(ProdutoRequest produto) {

        var produtoSalvo = apiFornecedorProdutoRepository.salvarProduto(produto).getBody();

        return ProdutoResponse
                .builder()
                .data(produtoSalvo.getData())
                .id(produtoSalvo.getId())
                .preco(produtoSalvo.getPreco())
                .nomeProduto(produtoSalvo.getNomeProduto())
                .finalidade(produtoSalvo.getFinalidade())
                .status(produtoSalvo.getStatus())
                .quantidade(produtoSalvo.getQuantidade())
                .build();
    }

    @Transactional
    public ProdutoResponse resgatarProduto(Long id) {
        var produto = apiFornecedorProdutoRepository.pegarProduto(id).getBody();

        return produto;
    }

    @Transactional
    public List<ProdutoResponseMin> resgatarTodosProdutos() {
        var fornecedores = apiFornecedorProdutoRepository.listaDeProdutos().getBody();

        return fornecedores.stream().map(x -> ProdutoResponseMin
                        .builder()
                        .nomeProduto(x.getNomeProduto())
                        .preco(x.getPreco())
                        .id(x.getId())
                        .build())
                        .toList();
    }



    @Transactional
    public void atualizarDadosProduto(Long id, ProdutoResponse produto){
        apiFornecedorProdutoRepository.atualizarProduto(id, produto);
    }

    @Transactional
    public void deletarProduto(Long id) {
        apiFornecedorProdutoRepository.deleteProdutoPorId(id);
    }
}
