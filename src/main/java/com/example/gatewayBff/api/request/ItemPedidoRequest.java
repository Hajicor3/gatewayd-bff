package com.example.gatewayBff.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoRequest {

	private Long produtoId;
	private Long quantidade;
}
