package com.gmail.atividades.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "projetos")
public class Projeto {
    @Id
    private Integer id;
    private String nome;
    
    @Field("lider_id")
    private Integer liderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLiderId() {
        return liderId;
    }

    public void setLiderId(Integer liderId) {
        this.liderId = liderId;
    }
}
