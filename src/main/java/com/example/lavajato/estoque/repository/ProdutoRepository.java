package com.example.lavajato.estoque.repository;

import com.example.lavajato.estoque.entities.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, String> {
    Mono<Produto> findById(UUID id);
}