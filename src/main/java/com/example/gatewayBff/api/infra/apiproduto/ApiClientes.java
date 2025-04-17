package com.example.gatewayBff.api.infra.apiproduto;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "api-cliente", url = "http://localhost:8082")
public interface ApiClientes {

    
}
