package com.example.gatewayBff.api.controllers;

import com.example.gatewayBff.api.request.*;
import com.example.gatewayBff.api.response.*;
import com.example.gatewayBff.api.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "api-LojaVirtual")
@CrossOrigin("${api.front-end.url}")
public class ApiLojaVirtualController {

    private final ApiLojaVirtualService apiLojaVirtualService;
    private final ApiProdutosService apiProdutosService;
    private final ApiClienteService apiClienteService;
    private final ApiFornecedoresService apiFornecedoresService;
    private final ApiEstoqueService apiEstoqueService;

    @Operation(description = "Salva um fornecedor no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salva o fornecedor no banco de dados"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PostMapping("/fornecedor")
    public ResponseEntity<FornecedorResponse> criarFornecedor(@RequestBody FornecedorRequest fornecedor) {
        var fornecedorCriado = apiFornecedoresService.salvarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedorCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(fornecedorCriado);
    }

    @Operation(description = "Resgata um fornecedor do banco de dados pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um fornecedor"),
            @ApiResponse(responseCode = "404", description = "Não existe fornecedor no id informado")
    })
    @GetMapping("fornecedor/{id}")
    public ResponseEntity<FornecedorResponse> resgatarFornecedorPorId(@PathVariable Long id){
        var fornecedor = apiFornecedoresService.resgatarFornecedor(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @Operation(description = "Retorna uma lista de Dto´s de todos os fornecedores do banco. este Dto contem apenas o nome dos fornecedores")
    @ApiResponses(value = @ApiResponse(responseCode = "200",description = "Retorna uma lista de fornecedoresDto"))
    @GetMapping("/fornecedores")
    public ResponseEntity<List<FornecedorRequest>> resgatarTodosFornecedores() {
        var fornecedores = apiFornecedoresService.resgatarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @Operation(description = "Atualiza um fornecedor no banco de dados pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Efetua a atualização do fornecedor no banco de dados"),
            @ApiResponse(responseCode = "404", description = "Não existe fornecedor no id informado"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PutMapping("fornecedor/{id}")
    public ResponseEntity<Void> atualizarDadosFornecedorPorId(@PathVariable Long id, @RequestBody FornecedorRequest fornecedor){
        apiFornecedoresService.atualizarDadosFornecedor(id,fornecedor);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Deleta um fornecedor do banco de dados pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Efetua a exclusão do fornecedor"),
            @ApiResponse(responseCode = "404", description = "Não existe fornecedor no id informado"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @DeleteMapping("fornecedor/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id){
        apiFornecedoresService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Salva um produto no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salva o produto no banco de dados."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos.")
    })
    @PostMapping("/produto")
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoRequest produto) {
        var response = apiProdutosService.salvarProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @Operation(description = "Resgata um produto do banco de dados pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um produto."),
            @ApiResponse(responseCode = "404", description = "Não existe produto no id informado.")
    })
    @GetMapping(value = "produto/{id}")
    public ResponseEntity<ProdutoResponse> resgatarProdutoPorId(@PathVariable Long id) {
        var response = apiProdutosService.resgatarProduto(id);
        return ResponseEntity.ok().body(response);
    }

    @Operation(description = "Retorna uma lista de Dto´s de todos os produtos do banco.")
    @ApiResponses(value = @ApiResponse(responseCode = "200",description = "Retorna uma lista de fornecedoresDto."))
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponseMin>> resgatarTodosProdutos() {
        var response = apiProdutosService.resgatarTodosProdutos();

        return ResponseEntity.ok().body(response);
    }

    @Operation(description = "Atualiza um produto no banco de dados pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Efetua a atualização do produto no banco de dados."),
            @ApiResponse(responseCode = "404", description = "Não existe produto no id informado."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos.")
    })
    @PutMapping("produto/{id}")
    public ResponseEntity<Void> atualizarDadosProdutoPorId(@PathVariable Long id, @RequestBody ProdutoResponse produto){
        apiProdutosService.atualizarDadosProduto(id,produto);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Deleta um produto do banco de dados pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Efetua a exclusão do produto."),
            @ApiResponse(responseCode = "404", description = "Não existe produto no id informado."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos.")
    })
    @DeleteMapping("produto/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id){
        apiProdutosService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(description = "Salva uma movimentação no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salva uma movimentação no banco de dados."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos."),
            @ApiResponse(responseCode = "404", description = "O estoque do id não existe.")
    })
    @PostMapping("/movimentacao")
    public ResponseEntity<MovimentacaoResponse> registrarMovimentacao(@RequestBody MovimentacaoRequest movimentacao) {
        var response = apiEstoqueService.salvarMov(movimentacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/produto/movimentacoes/{id}")
    public ResponseEntity<List<MovimentacaoResponse>> resgatarMovimentacoesPorIdProduto(@PathVariable Long id){
        var response = apiEstoqueService.resgatarPorIdProduto(id);
        return ResponseEntity.ok().body(response);
    }

    @Operation(description = "Salva um Cliente no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salva um cliente."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos.")
    })
    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponse> registrarCliente(@RequestBody ClienteRequest cliente) {
        var response = apiClienteService.salvarCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @Operation(description = "Resgata um cliente do banco de dados pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um cliente."),
            @ApiResponse(responseCode = "404", description = "Não existe cliente no id informado.")
    })
    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponse> resgatarClientePorId(@PathVariable Long id) {
        var response = apiClienteService.resgatarCliente(id);
        return ResponseEntity.ok().body(response);
    }

    @Operation(description = "Atualiza um cliente no banco de dados pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Efetua a atualização do cliente."),
            @ApiResponse(responseCode = "404", description = "Não existe cliente no id informado."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos.")
    })
    @PutMapping("/cliente/{id}")
    public ResponseEntity<Void> atualizarClientePorId(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
        apiClienteService.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Salva um Pedido de um cliente no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salva um pedido."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos.")
    })
    @PostMapping("/cliente/pedido")
    public ResponseEntity<PedidoResponse> registrarPedidoCliente(@RequestBody PedidoRequest pedido) {
        var response = apiClienteService.registrarPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
