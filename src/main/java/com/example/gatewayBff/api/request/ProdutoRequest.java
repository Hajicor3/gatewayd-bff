package com.example.gatewayBff.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoRequest {
	
	private String nomeProduto;
	private Double preco;
	private String status;
	private String finalidade;
	private Long fornecedorId;
}
