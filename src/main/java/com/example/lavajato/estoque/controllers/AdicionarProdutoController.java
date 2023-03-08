package com.example.lavajato.estoque.controllers;

import com.example.lavajato.estoque.payload.AddProdutoRequest;
import com.example.lavajato.estoque.payload.ProdutoResponse;
import com.example.lavajato.estoque.services.AddProdutoToEstoqueService;
import com.example.lavajato.estoque.services.FindProdutoByIdService;
import com.example.lavajato.estoque.services.ListProdutosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class AdicionarProdutoController {

    private final AddProdutoToEstoqueService addProdutoToEstoqueService;
    private final FindProdutoByIdService findProdutoByIdentificadorService;

    private final ListProdutosService listProdutosService;

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProdutoResponse> realizarPagamentoFornecedor(@RequestBody AddProdutoRequest addProdutoRequest){

        return addProdutoToEstoqueService.execute(addProdutoRequest);
    }

    @GetMapping(path = "/find/{id}")
    public Mono<ProdutoResponse> getProdutoByIdentificador(@PathVariable("id") String identificador){
        return findProdutoByIdentificadorService.execute(identificador);
    }

    @GetMapping(path = "")
    public Flux<ProdutoResponse> getAllProdutos(){
        return listProdutosService.execute();
    }
}



