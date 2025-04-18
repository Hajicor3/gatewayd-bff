package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiproduto.ApiFornecedorProduto;
import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiFornecedoresService {

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
}
