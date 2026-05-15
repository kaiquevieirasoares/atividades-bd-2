package com.gmail.atividades.service;

import com.gmail.atividades.model.Atividade;
import com.gmail.atividades.model.Projeto;
import com.gmail.atividades.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ProjetoService projetoService;

    public void criarAtividade(Atividade novaAtividade) {
        if (projetoService.existeProjeto(novaAtividade.getProjetoId())) {
            atividadeRepository.save(novaAtividade);
        } else {
            System.out.println("Erro: Projeto de ID " + novaAtividade.getProjetoId() + " não existe.");
        }
    }

    public void listarProjetosEAtividades() {
        List<Projeto> projetos = projetoService.listarTodos();
        for (Projeto p : projetos) {
            System.out.println("Projeto: " + p.getNome());
            List<Atividade> atividades = atividadeRepository.findByProjetoId(p.getId());
            atividades.forEach(a -> System.out.println(" - Atividade: " + a.getTitulo()));
        }
    }

    public void removerAtividade(Integer atividadeId) {
        atividadeRepository.deleteById(atividadeId);
    }
}
