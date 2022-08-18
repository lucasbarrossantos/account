# Rotina de transações

### Sobre: 
* O objetivo desta api é realizar o controle das transações feitas por o cliente
----

Para teste local é possível mudar o profile para `test` no [`application.yml`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/application.yml)
deixando da seguinte forma:

```yaml
spring:
  profiles:
    active: test
```

Assim a aplicação utiliza como banco de dados o `H2`. Após a execução da aplicação é possível acessar o H2 por este [link](http://localhost:8080/api/h2)

### Swagger
- É possível também acessar o swagger [aqui](http://localhost:8080/api/swagger-ui/#/) após a execução da aplicação

#### Caso queira executar a aplicação no ambiente Docker, basta seguir o passo abaixo:

### Preparando ambiente Docker:

Na raiz do projeto execute: </p>
```dockerfile
docker-compose up --build
```
__É importante que no `application.yml` o profile seja trocado para `docker-dev`__

```yaml
spring:
  profiles:
    active: docker-dev
```

### Tecnologias no projeto

- Java 11
- Maven
- Arquitetura MVC
- Spring Boot(Spring Data, Validation, )
- Banco de dados (H2, PostgreSQL)
- Docker
- Docker Compose
- Lombok
- Junit
- Mockito
- Swagger
