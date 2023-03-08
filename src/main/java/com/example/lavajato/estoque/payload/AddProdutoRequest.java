package com.example.lavajato.estoque.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;


@Data
public class AddProdutoRequest {

    private UUID id;

    private String nome;
    private String marca;



    @JsonProperty("quantidade")
    private int quantidade;
}