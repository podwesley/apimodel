Projeto maven/java.
@Author: Wesley Rodrigues

## Requisitos e execução.

1- A Api deve estar disponível na porta `8080`

2- Acessar a pasta do projeto por um terminal

​	2.1 - Para baixar as dependências do maven e executar os testes basta executar:

​								`mvn clean install test `

3- Para acessar os resultados dos teste basta executar:

​								`mvn allure:serve`



O maven irá abrir todos os resultados dos testes em um dashboard.


#### Connect with me
[<img align="middle" alt="Wesley Soares | LinkedIn" width="115px" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />][linkedin]


## Estrutura do projeto



* Classes do core da api no ciclo de vida do TESTE.

### src/main/java/core/

| Recurso                       | Descrição                                                   |
| ----------------------------- | ----------------------------------------------------------- |
| `RestProvider.class`          | Api de ações encapsuladas do restAssured                    |
| `Usuario.class`               | Classe que representa um usuário de acordo com o resquisito |
| `SimuladoDeEmprestimos.class` | Classe que representa as informações de um empréstimo       |
| `Settings.class`              | Enum que representa a url do ambiente a ser testado.        |
| `UsuarioResource.class`       | Endpoints da classe de usuário.                             |

### src/test/java/

| Camada     | Descrição                     |
| ---------- | ----------------------------- |
| */runners* | Camada de execução dos testes |
| */steps*   | Camada de steps do cucumber   |

### src/test/resources/

| Camada      | Descrição                          |
| ----------- | ---------------------------------- |
| */features* | Arquivos no padrão BDD do cucumber |


### Resultados dos testes

Os resultados de testes gerados pelo allure reports, ficam armazenados em

*\target\allure-results*

E a configuração para a saída dos relatórios ficam encontram

***allure.properties***
e
`pom.xml` na tag ***< resultsDirectory >***


## Features

O Projeto está escrito no padrão BDD



## Ferramentas utilizadas

* Java 1.8.0_301
* Maven 3.8.2
* Selenium java 4.2.2
* Commons.io 2.11.0
* Cucumber junit 7.3.4
* Cucumber java 7.3.4
* Allure cucumver7-jvm 2.18.1
* Allure Maven 2.11.2
* Allure restAssured 2.18.1
* log4j 1.2.17
* RestAssured 4.0.0
* gson 2.9.0
* Hamcrest 2.2


[linkedin]: https://www.linkedin.com/in/podwesley/
[java]: https://www.java.com/pt-BR/
[maven]: https://maven.apache.org/download.cgi
[intelliJ]: https://www.jetbrains.com/idea/download/
[git]: https://git-scm.com/
[github]: https://github.com/
[junit]: https://junit.org/junit4/
[allure-report]: https://docs.qameta.io/allure/
[rest-assured]: https://rest-assured.io/
