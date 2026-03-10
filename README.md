# Projeto Review: API de Clientes e Contatos

Projeto desenvolvido originalmente como **Desafio Nubank** e revisitado para fins de estudo, focado em **evolução arquitetural progressiva**: transformando um código funcional em um sistema profissional, resiliente e defensivo.

## 📝 Sobre o Projeto

API REST para gestão de clientes e seus contatos (Telefone/E-mail), explorando relacionamentos **1:N (Um-para-Muitos) bidirecionais**. O repositório documenta a transição de uma estrutura frágil para padrões sólidos de mercado.

## 🚀 Funcionalidades

- **Gestão de Clientes:** Cadastro com lista opcional de contatos (persistência em cascata).
- **Gestão de Contatos:** Cadastro avulso vinculado a um cliente existente.
- **Consultas Otimizadas:** Listagem de clientes e seus contatos resolvendo o problema de performance N+1.

## 🛣️ Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/clientes` | Cadastra novo cliente (aceita contatos aninhados) |
| `POST` | `/contatos` | Cadastra contato vinculado a um `clienteId` |
| `GET` | `/clientes` | Lista todos os clientes e seus contatos |
| `GET` | `/clientes/{id}/contatos` | Lista contatos de um cliente específico |

## 🛠️ Tecnologias

- **Java 17+** & **Spring Boot 3**
- **Spring Data JPA** & **Hibernate**
- **PostgreSQL**
- **Lombok** & **Bean Validation**

---

## 📈 Jornada de Evolução (Review)

O projeto foi refatorado em 3 etapas para corrigir problemas comuns de arquitetura e design:

### Quadro Comparativo
| Conceito | V1 (Frágil) | V2/V3 (Upgrade) |
| :--- | :--- | :--- |
| **Arquitetura** | Controller acessava Repository | Camada de **Service** obrigatória |
| **Injeção** | Field Injection (`@Autowired`) | **Constructor Injection** (Final fields) |
| **DTOs** | Classes mutáveis (Lombok) | **Records** (Imutabilidade nativa) |
| **Mapeamento** | Lógica duplicada na Service | **Mappers** (Utility Classes estáticas) |
| **Validação** | Parcial ou ignorada | `@Valid` com cascata em Listas |
| **Performance** | Problema **N+1** queries | `JOIN FETCH` + `DISTINCT` |
| **Erros** | `RuntimeException` (500) | Exception de Negócio + `@RestControllerAdvice` |



### Principais Melhorias Aplicadas
* **Imutabilidade:** Uso de Java Records para garantir que os dados do contrato (API) não sejam alterados após a entrada.
* **Relacionamento Bidirecional:** Implementação correta de `@OneToMany` e `@ManyToOne` com `mappedBy`, `cascade` e `orphanRemoval`.
* **Serialização JSON:** Uso de `@JsonManagedReference` e `@JsonBackReference` para evitar recursão infinita no Jackson.
* **Defesa em Profundidade:** Validação dupla — no nível de DTO (Bean Validation) e no nível de banco de dados (Constraints SQL).
* **Código Limpo:** Remoção de injeções ocultas e centralização do tratamento de exceções para respostas HTTP semânticas (400, 404, 201).

## 📂 Estrutura do Projeto (V3)

```text
src/main/java/reviewNubank/
├── controller/  # Exposição dos recursos REST
├── service/     # Regras de negócio e orquestração
├── repository/  # Consultas JPQL otimizadas
├── entities/    # Modelo de dados JPA
├── dto/         # Records para Request e Response
├── mapper/      # Conversores de entidade/DTO
├── handler/     # Tratamento global de exceções
└── exception/   # Exceções customizadas de negócio
