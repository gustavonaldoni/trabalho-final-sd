# Trabalho Final - Sistemas Distribuídos

Este projeto consiste em uma aplicação desktop em Java para exibição dos 10 filmes mais populares do IMDb, consumindo dados em tempo real a partir de uma API REST. A aplicação apresenta uma interface gráfica simples e funcional, exibindo título, ano, avaliação e imagem (poster) de cada filme retornado.

Projeto desenvolvido para a disciplina de Sistemas Distribuídos, do curso de Ciência da Computação da PUC Minas – Campus Poços de Caldas.

---

## Tecnologias Utilizadas

- Java 11+
- Swing (interface gráfica)
- HttpClient (requisições HTTP)
- JSON (org.json) para parse de dados
- RapidAPI / IMDb API

---

## API Utilizada

Endpoint consultado:
GET https://imdb236.p.rapidapi.com/api/imdb/most-popular-movies

Autenticação via cabeçalhos:
x-rapidapi-key: <SUA_CHAVE_AQUI>
x-rapidapi-host: imdb236.p.rapidapi.com
Accept: application/json

---

## Funcionalidades

- Exibição de lista atualizada dos filmes mais populares
- Apresentação de título, ano, nota e poster
- Consumo de API real sem scraping
- Interface simples e responsiva
- Estrutura modular seguindo princípios de Clean Code
