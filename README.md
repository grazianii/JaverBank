# JaverBank

**JaverBank** é um sistema de banco simples desenvolvido em Java utilizando o Spring Framework, que consiste em duas aplicações separadas: `javerbank-api` e `javerbank-service`. A `javerbank-api` é responsável por expor endpoints REST para operações CRUD de clientes, além de calcular o score de crédito. A `javerbank-service` é responsável por persistir os dados dos clientes em um banco de dados H2.

## Estrutura do Projeto

O projeto é dividido em duas aplicações:

- **javerbank-api**: 
  - Exposição de endpoints REST para o cadastro de clientes.
  - Comunicação com o serviço `javerbank-service` usando Feign Client.
  - Autenticação e autorização de usuários.
  - Swagger para documentação da API.

- **javerbank-service**:
  - Serviço responsável por persistir os dados no banco de dados H2.
  - Contém lógica de validação para as operações CRUD.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **Spring Data JPA**
- **Spring Cloud OpenFeign**
- **H2 Database**
- **Swagger**
- **Lombok**

## Configuração e Execução

### Pré-requisitos

- **JDK 17**
- **Maven 3.8+**

### Clonando o Repositório

```bash
git clone https://github.com/grazianii/JaverBank.git
```

## Documentação da API

A documentação completa da API pode ser acessada via Swagger após a execução da aplicação javerbank-api:

```bash
http://localhost:8080/swagger-ui.html
```

## Usuário de teste cadastrado

### Admin
- **Username:** admin
- **Senha:** admin
- **Role:** ADMIN

## Banco de Dados

O projeto utiliza o banco de dados H2 em memória. O console do H2 pode ser acessado em:
```bash
http://localhost:8080/h2-console
```
