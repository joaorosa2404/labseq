Pré requisitos:
- Jdk 17 ou superior
- Maven

Como executar:
- Abrir um terminal na pasta do projeto;
- Executar o comando "mvnw quarkus:dev" para correr em modo de desenvolvimento;
- Executar "http://localhost:8080/labseq" no navegador.

Endpoints:

- http://localhost:8080/labseq/{num} //Calcula o valor labseq do número positivo "num"

- http://localhost:8080/labseq/reset //Limpa os valores em cache

- http://localhost:8080/q/openapi //Gera a documentação OpenAPI em ficheiro JSON

- http://localhost:8080/q/swagger-ui //GUI para testar os endpoints REST
