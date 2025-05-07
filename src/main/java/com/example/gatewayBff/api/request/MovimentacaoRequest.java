package com.example.gatewayBff.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoRequest {
	
	private Long idProduto;
	private Long quantidade;
	private String tipoDeMovimentacao;
}
