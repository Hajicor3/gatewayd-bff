package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiestoque.ApiEstoque;
import com.example.gatewayBff.api.request.MovimentacaoRequest;
import com.example.gatewayBff.api.response.MovimentacaoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiEstoqueService {

    private final ApiEstoque apiEstoqueRepository;

    @Transactional
    public MovimentacaoResponse salvarMov(MovimentacaoRequest movimentacao) {
        return apiEstoqueRepository.salvarMovimentacao(movimentacao).getBody();
    }
}
