package com.example.gatewayBff.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequest {
	
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
}
