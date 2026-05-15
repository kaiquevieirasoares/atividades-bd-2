# Documentação Completa - Tarefa MongoDB

Este documento contém a resolução integral da tarefa envolvendo o SGBD NoSQL MongoDB. O tema central é o gerenciamento de atividades em projetos com empregados.

## 2.b. Resumo sobre o MongoDB
O MongoDB é um Sistema de Gerenciamento de Banco de Dados (SGBD) NoSQL classificado como orientado a documentos (document database). Ao contrário dos bancos relacionais, ele armazena dados em documentos BSON (Binary JSON).
* **Esquema Flexível:** Documentos na mesma coleção podem ter estruturas diferentes.
* **Alta Performance:** Otimizado para leitura/escrita mantendo dados relacionados juntos.
* **Alta Disponibilidade e Escalabilidade:** Suporte nativo a Replica Sets e Sharding.

## 6.a. O que é um Replica Set e os papéis dos membros
Para garantir alta disponibilidade e tolerância a falhas, o MongoDB utiliza Replica Sets, que são clusters de instâncias que mantêm o mesmo conjunto de dados. Os papéis (roles) são:
* **Primário (Primary):** Único membro que recebe operações de escrita. Ele registra as mudanças no `oplog`.
* **Secundário (Secondary):** Replica o `oplog` do primário para manter uma cópia exata dos dados. Pode assumir como primário em caso de falha.
* **Arbiter (Árbitro):** Não armazena dados, apenas participa das eleições para garantir o quórum necessário na escolha de um novo primário.

## 6.b. Configuração de Replica Set de 3 Membros
Para transformar o servidor Docker em um Replica Set de três membros para o banco `Atividades Proj`, as etapas seriam:
1. Atualizar o `docker-compose.yml` para iniciar 3 containers distintos na mesma rede, todos com a flag `--replSet rs_atividades`.
2. Acessar o Mongo Shell em um dos nós e executar a inicialização avançada:
```javascript
rs.initiate({
  _id: "rs_atividades",
  members: [
    { _id: 0, host: "mongo-primary:27017" },
    { _id: 1, host: "mongo-sec1:27017" },
    { _id: 2, host: "mongo-sec2:27017" }
  ]
})
```
3. Executar `rs.status()` para validar a configuração.
