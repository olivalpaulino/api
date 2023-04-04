# Criação de API Spring Boot

Este projeto representa os estudos de criação da API, reaplicando conceitos do Spring Boot Framework, com as dependências Spring Web, Spring JPA, Spring DevTools, MySQL, na IDE Eclipse.

## Para Baixar o Projeto

git clone https://github.com/olivalpaulino/api.git 
Caso não utilize o Git, você pode baixar o .zip do projeto no repositório do github: https://github.com/olivalpaulino/api

## Para Instalar o Projeto

Abra a IDE de sua preferência que já possui a integração com o Spring Boot, seja por extensão, seja o Spring Tool Suite, ou no Eclipse ou no Netbeans, e execute o comando **Maven Install**

## Descrição do Projeto

Atualmente, o projeto possui 5 pacotes, sendo, o principal, controller, model, repository e service, onde o pacote controller possui as rotas, o model possui a entidade que mapeia a classe java para a tabela do banco de dados MySQL, o repository que é responsável pelas pesquisas de dados no banco de dados, através de uma interface e o principal, que inicializa a aplicação.

## Observação

É necessário criar o banco de dados chamado "api_spring". Apenas a criação do banco e necessária. Assim, ao inicializar o projeto Spring Boot, será adicionada as tabelas que são mapeadas no pacote model. Para este projeto, estou usando o sgdb MySQL.
Para testar, após executar a aplicação Spring Boot, basta acessar http://localhost:8080 e testar as possíveis rotas cadastradas na classe Controller.