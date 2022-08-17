# Rotina de transações

### Sobre: 
* O objetivo desta api é realizar o controle das transações feitas por o cliente
----

Para teste local é possível mudar o profile para `test` no [`application.yml`](https://github.com/lucasbarrossantos/account/blob/main/src/main/resources/application.yml) 
onde a aplicação utiliza como banco de dados o `H2`. É possível acessar o H2 por este [link](http://localhost:8080/api/h2)

#### Caso queira executar a aplicação no ambiente Docker, basta seguir o passo abaixo:

### Preparando ambiente Docker:

Na raiz do projeto execute:

- docker-compose up --build

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
