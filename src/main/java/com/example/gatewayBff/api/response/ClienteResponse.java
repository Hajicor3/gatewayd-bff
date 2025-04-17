package com.example.gatewayBff.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
}
