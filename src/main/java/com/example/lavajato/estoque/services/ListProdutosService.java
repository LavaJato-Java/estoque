package com.example.lavajato.estoque.services;

import com.example.lavajato.estoque.mapper.ProdutoToProdutoResponseMapper;
import com.example.lavajato.estoque.payload.ProdutoResponse;
import com.example.lavajato.estoque.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@RequiredArgsConstructor
@Slf4j
public class ListProdutosService {
    private final ProdutoRepository produtoRepository;

    public Flux<ProdutoResponse> execute(){
        log.info("Executando uma listagem de todos os produtos contidos no banco de dados");
        return produtoRepository.findAll()
                .map(ProdutoToProdutoResponseMapper::maptoProdutoResponse);
    }

}