package com.example.gatewayBff.api.services;

import com.example.gatewayBff.api.infra.apiestoque.ApiEstoque;
import com.example.gatewayBff.api.request.MovimentacaoRequest;
import com.example.gatewayBff.api.response.MovimentacaoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApiEstoqueService {

    private final ApiEstoque apiEstoqueRepository;

    @Transactional
    public MovimentacaoResponse salvarMov(MovimentacaoRequest movimentacao) {
        return apiEstoqueRepository.salvarMovimentacao(movimentacao).getBody();
    }

    @Transactional
    public List<MovimentacaoResponse> resgatarPorIdProduto(Long id){

        return apiEstoqueRepository.resgatarMovimentacoesPorIdProduto(id).getBody().stream().map(
                x -> MovimentacaoResponse
                        .builder()
                        .idProduto(x.getIdProduto())
                        .data(x.getData())
                        .quantidade(x.getQuantidade())
                        .tipoDeMovimentacao(x.getTipoDeMovimentacao())
                        .id(x.getId())
                        .build()).collect(Collectors.toList());


    }
}
