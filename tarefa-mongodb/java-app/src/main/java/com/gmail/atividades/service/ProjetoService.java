package com.gmail.atividades.service;

import com.gmail.atividades.model.Projeto;
import com.gmail.atividades.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public boolean existeProjeto(Integer id) {
        return projetoRepository.existsById(id);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public void atualizarLider(Integer projetoId, Integer novoLiderId) {
        projetoRepository.findById(projetoId).ifPresent(p -> {
            p.setLiderId(novoLiderId);
            projetoRepository.save(p);
        });
    }
}
