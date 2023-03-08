package com.example.lavajato.estoque.entities;

//import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "Produto")
public class Produto {
    @Id
    @Column(name = "id")
    private UUID id;

    private String nome;
    private String marca;
    private int quantidade;

}