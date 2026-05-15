# Atividade BD2 - MongoDB com Spring Boot

Este projeto contém a resolução da tarefa envolvendo gerenciamento de atividades e projetos com empregados utilizando o MongoDB.

## Estrutura do Projeto

* `docker-compose.yml`: Sobe o container do MongoDB.
* `init-mongo.js`: Script de inicialização do banco que popula as coleções `empregados`, `projetos` e `atividades`.
* `java-app/`: Diretório contendo a aplicação Java (Spring Boot) responsável por interagir e realizar as operações de CRUD no banco.

---

## Passo a Passo para Rodar

### 1. Subindo o Banco de Dados (MongoDB)

O banco de dados roda via Docker e já é alimentado automaticamente. 

1. Abra o terminal na raiz da pasta `tarefa-mongodb`.
2. Rode o comando para subir o banco em segundo plano:
   ```bash
   docker compose up -d
   ```
*(O container ficará disponível na porta padrão 27017 com as credenciais cadastradas no docker-compose).*

### 2. Rodando a Aplicação Java

A aplicação Java possui um componente (CommandLineRunner) configurado para rodar todas as validações do CRUD automaticamente assim que iniciar, imprimindo o resultado no terminal.

1. Pelo terminal, entre na pasta do projeto Java:
   ```bash
   cd java-app
   ```
2. Execute o projeto usando o Maven:
   ```bash
   mvn clean spring-boot:run
   ```

> **Aviso Importante (Versão do Java)**: 
> O Spring Boot requer o **Java 17** (ou superior). Como detectamos que a versão padrão do seu sistema é o Java 8, você pode habilitar o Java 17 no seu terminal via SDKMAN executando:
> ```bash
> source ~/.sdkman/bin/sdkman-init.sh
> sdk use java 17.0.18-librca
> ```
> Depois disso, basta rodar o comando do Maven normalmente!
