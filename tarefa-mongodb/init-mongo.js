db = db.getSiblingDB('Atividades_Proj');

// Empregados
db.empregados.insertMany([
  { _id: 1, nome: "Alice Silva", cargo: "Desenvolvedora Backend", email: "alice@gmail.com" },
  { _id: 2, nome: "Bruno Costa", cargo: "Tech Lead", email: "bruno@gmail.com" },
  { _id: 3, nome: "Carla Souza", cargo: "Gerente de Projetos", email: "carla@gmail.com" }
]);

// Projetos
db.projetos.insertMany([
  { _id: 101, nome: "Sistema iService", descricao: "Modernização da arquitetura SaaS", lider_id: 2, status: "Em Andamento" },
  { _id: 102, nome: "Portal B2B", descricao: "Tendências de publicidade", lider_id: 3, status: "Em Andamento" },
  { _id: 103, nome: "Migração Cloud", descricao: "Migração de infraestrutura on-premise", lider_id: 2, status: "Planejamento" }
]);

// Atividades
db.atividades.insertMany([
  { _id: 1001, titulo: "Configurar OAuth2 e JWT", projeto_id: 101, responsavel_id: 1, status: "Concluída" },
  { _id: 1002, titulo: "Criar colunas discriminator", projeto_id: 102, responsavel_id: 1, status: "Em Andamento" },
  { _id: 1003, titulo: "Aprovar pull request #7", projeto_id: 101, responsavel_id: 2, status: "Pendente" }
]);
