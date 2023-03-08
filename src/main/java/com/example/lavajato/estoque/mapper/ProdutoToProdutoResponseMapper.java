package com.example.lavajato.estoque.mapper;

import com.example.lavajato.estoque.entities.Produto;
import com.example.lavajato.estoque.payload.ProdutoResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoToProdutoResponseMapper {

    public static ProdutoResponse maptoProdutoResponse(Produto produto){
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNomeProduto(produto.getNome());
        produtoResponse.setMarca(produto.getMarca());
        produtoResponse.setQuantidade(produto.getQuantidade());
        return produtoResponse;
    }
}