package com.example.lavajato.estoque.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ProdutoResponse {

    private UUID id;

    @JsonProperty("nome_produto")
    private String nomeProduto;

    private String marca;

    @JsonProperty("quantidade_estoque")
    private long quantidade;

}