# Very Useful Tools To Remember API

CRUD para gerenciamento de ferramentas

## Desafio de Código da empresa Bossa Box

Construir uma API e banco de dados para a aplicação VUTTR (Very Useful Tools to Remember). A aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags.

### Requisitos:
1. Deve haver uma rota para listar todas as ferramentas cadastradas (GET /tools).
2. Deve ser possível filtrar ferramentas utilizando uma busca por tag (GET /tools?tag=node).
3. Deve haver uma rota para cadastrar uma nova ferramenta (POST /tools) com resposta Status: 201 Created.
4. O usuário deve poder remover uma ferramenta por ID (DELETE /tools/:id) com resposta Status: 200 OK.

## Stack

- Java 11
- Spring Boot
- Spring Data JPA
- Lombok
- Junit
- Database H2
