package com.example.gatewayBff.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class FornecedorResponse {
	
	private Long id;
	private String nome;
	private List<ProdutoResponse> produtos;
}
