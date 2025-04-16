package com.example.gatewayBff.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FornecedorRequest {

	private Long id;
	private String nome;
}
