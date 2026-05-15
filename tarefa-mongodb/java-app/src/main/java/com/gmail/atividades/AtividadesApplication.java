package com.gmail.atividades;

import com.gmail.atividades.model.Atividade;
import com.gmail.atividades.service.AtividadeService;
import com.gmail.atividades.service.ProjetoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AtividadesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtividadesApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProjetoService projetoService, AtividadeService atividadeService) {
        return args -> {
            System.out.println("=== Testando operações CRUD ===");

            System.out.println("\n1. Listando inicial...");
            atividadeService.listarProjetosEAtividades();

            System.out.println("\n2. Atualizando líder do projeto 101 para o ID 3...");
            projetoService.atualizarLider(101, 3);

            System.out.println("\n3. Criando nova atividade no projeto 102...");
            Atividade novaAtividade = new Atividade();
            novaAtividade.setId(1004);
            novaAtividade.setTitulo("Nova Atividade de Teste");
            novaAtividade.setProjetoId(102);
            atividadeService.criarAtividade(novaAtividade);

            System.out.println("\n4. Listando após criações e atualizações...");
            atividadeService.listarProjetosEAtividades();

            System.out.println("\n5. Removendo atividade 1004...");
            atividadeService.removerAtividade(1004);

            System.out.println("\n=== Teste finalizado com sucesso! ===");
            System.exit(0);
        };
    }
}
