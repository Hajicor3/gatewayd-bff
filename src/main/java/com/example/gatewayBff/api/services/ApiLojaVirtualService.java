package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiproduto.ApiFornecedorProduto;
import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.request.ProdutoRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import com.example.gatewayBff.api.response.ProdutoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiLojaVirtualService {

    private final ApiFornecedorProduto apiFornecedorProdutoRepository;

    @Transactional
    public FornecedorResponse salvarFornecedor(FornecedorRequest fornecedor){
        return apiFornecedorProdutoRepository.criarFornecedor(fornecedor).getBody();
    }

    @Transactional
    public FornecedorResponse resgatarFornecedor(Long id) {
        return apiFornecedorProdutoRepository.fornecedorPorId(id).getBody();
    }

    @Transactional
    public List<FornecedorRequest> resgatarTodosFornecedores(){
        return apiFornecedorProdutoRepository.listaFornecedores().getBody();
    }

    @Transactional
    public void atualizarDadosFornecedor(Long id, FornecedorRequest fornecedor){
        apiFornecedorProdutoRepository.atualizarFornecedor(id, fornecedor);
    }

    @Transactional
    public void deletarFornecedor(Long id) {
        apiFornecedorProdutoRepository.deletarFornecedor(id);
    }

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
    public List<ProdutoResponse> resgatarTodosProdutos() {
        return apiFornecedorProdutoRepository.listaDeProdutos().getBody();
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
