# Entendimento de  Backend

## Sobre a aplicação

A aplicação consiste em criar uma api de cadastro e validação de cpf, onde o principal objetivo é o cadastro seguro de CPF.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Docker


## Por que Spring Boot ?

O Spring é um framework para desenvolvimento de aplicações em Java que fornece um grande conjunto de recursos e funcionalidades que tornam o processo de desenvolvimento mais fácil, eficiente e produtivo.

Uma das principais razões para escolher o Spring é sua capacidade de facilitar o desenvolvimento de aplicativos robustos e escaláveis, reduzindo a quantidade de código que é necessário escrever e simplificando a configuração de projetos.

Além disso, o Spring possui uma grande comunidade de desenvolvedores e suporte de uma ampla gama de ferramentas e tecnologias, tornando-o uma opção rápida e eficiente para realizar o teste.

# Testes

- Model
- Controller
- Exceptions

# Como executar o projeto

Pré-requisitos: Java 11 +

```bash
# Criar banco de dados

# Criar o container PostgreSql
docker run --name maxmilhas_db -e POSTGRES_PASSWORD=psql -p 5433:5432 -d postgres

#Criar tabela
docker exec -it maxmilhas_db createdb -U postgres maxmilhas


# executar o projeto
./mvnw spring-boot:run
```

# Autor

Christopher Silva de Sousa

https://www.linkedin.com/in/christopher-silva-857205205/# Cpf-Recorver
