# Rotina de transações

### Sobre: 
* O objetivo desta api é realizar o controle das transações feitas por cliente/usuário
----

Para teste local é possível mudar o profile para `test` no [`application.yml`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/application.yml)
deixando da seguinte maneira:

```yaml
spring:
  profiles:
    active: test
```

Assim a aplicação utilizará como banco de dados o `H2`. Após a execução da aplicação é possível acessar o `H2` por este [link](http://localhost:8080/api/h2)

### Swagger
- É possível também acessar o `swagger` [aqui](http://localhost:8080/api/swagger-ui/#/) após a execução da aplicação.

#### Caso queira executar a aplicação no ambiente Docker, basta seguir o passo abaixo:

### Preparando ambiente Docker:

Execute o seguinte comando na raiz do projeto: </p>
```dockerfile
docker-compose up --build
```
__É importante que no [`application.yml`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/application.yml) o profile ativo seja o `docker-dev`__

```yaml
spring:
  profiles:
    active: docker-dev
```

**Obs:** O projeto usa um arquivo chamado [`import.sql`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/import.sql) onde consta os dados iniciais para os tipos de operação. 
Para esse script ser acionado é preciso ter a seguinte configuração no [`application.yml`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/application.yml):
``` yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create
```
Essa configuração vai sempre chamar o [`import.sql`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/import.sql) no momento do _start da aplicação_! Então para os dados permanecerem
no banco mesmo após a próxima execução da aplicação, então basta deixar a configuração como está abaixo e executar a 
aplicação novamente:
``` yaml
spring:
  jpa:
    hibernate:
      ddl-auto: none
```

### Tecnologias utilizadas no projeto

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