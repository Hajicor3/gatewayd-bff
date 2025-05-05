package com.example.gatewayBff.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProdutoResponseMin {
	
	private Long id;
	private String nomeProduto;
	private Double preco;

}
