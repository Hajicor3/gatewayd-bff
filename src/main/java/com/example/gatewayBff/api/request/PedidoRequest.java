package com.example.gatewayBff.api.request;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoRequest {
	
	private Long clienteId;
	private Integer status;
	private PagamentoRequest pagamento;
	private Set<ItemPedidoRequest> items= new HashSet<>();
}
