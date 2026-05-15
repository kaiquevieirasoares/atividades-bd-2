package com.gmail.atividades.repository;

import com.gmail.atividades.model.Atividade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends MongoRepository<Atividade, Integer> {
    List<Atividade> findByProjetoId(Integer projetoId);
}
