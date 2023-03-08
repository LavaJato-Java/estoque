package com.example.lavajato.estoque.services;


import com.example.lavajato.estoque.entities.Produto;
import com.example.lavajato.estoque.payload.AddProdutoRequest;
import com.example.lavajato.estoque.payload.ProdutoResponse;
import com.example.lavajato.estoque.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class AddProdutoToEstoqueService {

    private final ProdutoRepository produtoRepository;


    public Mono<ProdutoResponse> execute(AddProdutoRequest addProdutoRequest){
        log.info("Chamando ...");
        return retrieveOrSaveProduct(addProdutoRequest).flatMap(this::toProdutoResponse);
    }

    private Mono<ProdutoResponse> toProdutoResponse(Produto produto) {
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNomeProduto(produto.getNome());
        produtoResponse.setQuantidade(produto.getQuantidade());
        produtoResponse.setMarca(produto.getMarca());
        return Mono.just(produtoResponse);
    }

    private  Mono<Produto> retrieveOrSaveProduct(AddProdutoRequest addProdutoRequest) {
        return Mono.just(addProdutoRequest)
                .flatMap(this::mapToProduto).flatMap(produtoRepository::save);
        //atualiza as informações do produto ou salva um novo produto se nao existe
    }

    private  Mono<Produto> mapToProduto(AddProdutoRequest addProdutoRequest) {
        return  produtoRepository.findById(addProdutoRequest.getId())
                .defaultIfEmpty(this.createProduto(addProdutoRequest))
                .flatMap(produto ->  this.saveOrRetrieve(produto,addProdutoRequest));
    }

    private Produto createProduto(AddProdutoRequest addProdutoRequest) {
        Produto produto = new Produto();
        produto.setNome(addProdutoRequest.getNome());
        produto.setId(addProdutoRequest.getId());
        produto.setMarca(addProdutoRequest.getMarca());
        produto.setQuantidade(addProdutoRequest.getQuantidade());
        return produto;
    }

    private Mono<Produto> saveOrRetrieve(Produto produto, AddProdutoRequest addProdutoRequest) {
        log.info("salvando o produto");
        if(Objects.nonNull(produto.getId())){
            produto.setQuantidade(produto.getQuantidade()+addProdutoRequest.getQuantidade());
            //somando a quantidade que tinha no estoque mais a quantidade que chegou na request

        }
        return Mono.just(produto);

    }
}