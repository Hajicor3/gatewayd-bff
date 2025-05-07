package com.example.gatewayBff.api.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimentacaoResponse {

	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant data;
	private Long idProduto;
	private Long quantidade;
	private String tipoDeMovimentacao;
}
