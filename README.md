# Gerenciador de Tarefas 
Esta aplicação é um sistema de gerenciamento de tarefas que consiste em um backend desenvolvido em Java 11 utilizando o framework Spring Boot, um frontend desenvolvido em Angular e um banco de dados PostgreSQL 14.

## Requisitos
- Java 11 
- Node.js
- Angular CLI
- PostgreSQL 14

## Configuração do Backend (Java)
- Importe o projeto Spring Boot em sua IDE preferida (por exemplo, IntelliJ IDEA, Eclipse).
- Certifique-se de que as dependências foram baixadas corretamente pelo Maven.
- Execute a aplicação a partir da classe principal TaskManagerApplication.
- O backend estará disponível em http://localhost:8080.

## Configuração do Frontend (Angular)
- Navegue até o diretório frontend usando o terminal.
- Execute npm install para instalar as dependências do Angular.
- Execute ng serve para iniciar o servidor de desenvolvimento do Angular.
- O frontend estará disponível em http://localhost:4200.

## Configuração do Banco de Dados (PostgreSQL)
- Certifique-se de que o PostgreSQL 14 está instalado e em execução.
- Atualize as credenciais do banco de dados no arquivo de configuração do backend (application.properties ou application.yml).

## Uso
- Acesse a aplicação pelo navegador no endereço http://localhost:4200 para usar o sistema de gerenciamento de tarefas.
- Certifique-se de que o backend está em execução para que o frontend possa se comunicar corretamente com a API.

## Funcionalidades desenvolvidas
- Criação de tarefas
- Edição de tarefas
- Filtro de tarefas
- Seleção de responsavel
- Seleção de prioridade
- Seleção de deadline
- Conclusão de tarefas
- Exclusão de tarefas
