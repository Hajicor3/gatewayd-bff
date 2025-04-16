package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiproduto.ApiProduto;
import com.example.gatewayBff.api.request.FornecedorRequest;
import com.example.gatewayBff.api.response.FornecedorResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiProdutoService {

    private final ApiProduto apiProdutoRepository;

    @Transactional
    public FornecedorResponse salvar(FornecedorRequest fornecedor){
        return apiProdutoRepository.criarFornecedor(fornecedor).getBody();
    }

    @Transactional
    public FornecedorResponse resgatar(Long id) {
        return apiProdutoRepository.fornecedorPorId(id).getBody();
    }

    @Transactional
    public List<FornecedorRequest> resgatarTodos(){
        return apiProdutoRepository.listaFornecedores().getBody();
    }

    @Transactional
    public void atualizarDados(Long id, FornecedorRequest fornecedor){
        apiProdutoRepository.atualizarFornecedor(id, fornecedor);
    }

    @Transactional
    public void deletar(Long id) {
        apiProdutoRepository.deletarFornecedor(id);
    }

}
