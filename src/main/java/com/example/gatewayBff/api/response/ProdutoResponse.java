package com.example.gatewayBff.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ProdutoResponse {
	
	private Long id;
	private String nomeProduto;
	private Double preco;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate data;
	private String status;
	private String finalidade;
	private Long quantidade;
}
