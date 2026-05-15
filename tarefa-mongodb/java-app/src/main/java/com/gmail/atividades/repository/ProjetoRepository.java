package com.gmail.atividades.repository;

import com.gmail.atividades.model.Projeto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends MongoRepository<Projeto, Integer> {
}
