package com.example.lavajato.estoque.services;

import com.example.lavajato.estoque.exception.ProdutoNotFoundException;
import com.example.lavajato.estoque.mapper.ProdutoToProdutoResponseMapper;
import com.example.lavajato.estoque.payload.ProdutoResponse;
import com.example.lavajato.estoque.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@Slf4j
public class FindProdutoByIdService {

    private final ProdutoRepository produtoRepository;

    public Mono<ProdutoResponse> execute(String identificador){
        log.info("procurando o produto de identificador {}", identificador);
        return Mono.just(identificador)
                .flatMap(produtoRepository::findById)
                .switchIfEmpty(Mono.error(ProdutoNotFoundException::new))
                .map(ProdutoToProdutoResponseMapper::maptoProdutoResponse);
    }

}