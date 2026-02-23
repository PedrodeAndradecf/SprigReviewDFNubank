# Projeto Review

Projeto desenvolvido há cerca de 1 ano e revisitado agora para fins de estudo e revisão de conceitos.

## Sobre o projeto

Esta API foi criada para gerenciar **clientes** e seus **contatos associados**, com operações básicas de cadastro e consulta.

O objetivo desta revisão é reforçar conceitos de desenvolvimento backend com Java e Spring Boot, além de boas práticas como uso de DTOs e mapeamento de relacionamentos entre entidades.

## Funcionalidades

- **Cadastro de clientes** (`POST /clientes`)
- **Cadastro de contatos** associados a um cliente existente (`POST /contatos`)
- **Listagem de todos os clientes** com seus contatos (`GET /clientes`)
- **Listagem dos contatos** de um cliente específico (`GET /clientes/{id}/contatos`)

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/clientes` | Cadastra um novo cliente |
| `POST` | `/contatos` | Cadastra um contato para um cliente existente |
| `GET` | `/clientes` | Lista todos os clientes com seus contatos |
| `GET` | `/clientes/{id}/contatos` | Lista os contatos de um cliente específico |

## Tecnologias utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**

## Boas práticas aplicadas

- Uso de **DTOs** para trafegar dados entre as camadas
- Mapeamento de relacionamento entre entidades com:
  - `@OneToMany`
  - `@ManyToOne`
- Organização da API em camadas (ex.: controller, service, repository)

## Objetivo da revisão
Aqui temos duas Entities com relacionamento bidirecional (@OneToMany / @ManyToOne), o que introduz conceitos de cascata, referência circular, e gerenciamento de ciclo de serialização JSON

Reviewing an old project for study purposes.

