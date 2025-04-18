package com.example.gatewayBff.api.response;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.example.gatewayBff.api.request.PagamentoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {
	
	private Long id;
	private Long clienteId;
	private int status;
	private PagamentoRequest pagamento;
	private Set<ItemPedidoResponse> itemsPedido = new HashSet<>();
	private Instant momento;
}
