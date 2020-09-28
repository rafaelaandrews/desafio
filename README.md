# Star Wars API

### Desafio técnico proposto durante o processo seletivo para vaga de desenvolvedora back-end na B2W.

<br/>

## 🔗 Tabela de conteúdo

- [Descrição](#Descrição)
- [Requisitos](#Requisitos)
- [Funcionalidades](#Funcionalidades)
- [Instalação](#Instalação)
- [MongoDB](#MongoDB)
- [Pré-requisitos](#Pré-requisitos)
- [Endpoints](#Endpoints)
- [Tecnologias](#tecnologias)
- [Autor](#Autor)

---

## Descrição
Desenvolver uma API que contenha os dados dos planetas de Star Wars.


## Requisitos:
- A API deve ser REST

- Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente:
  - Nome
  - Clima
  - Terreno

- Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: https://swapi.co/


## Funcionalidades

- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta


## Instalação
```bash
$ git clone https://github.com/rafaelaandrews/desafio-b2w.git

$ cd desafio-b2w

$ mvn clean install

Para rodar o projeto utilizei a IDE Eclipse com Spring Tools 3.
```

## MongoDB
O projeto está configurado para usar um cluster hospedado em um servidor cloud mongodb.
Para visualizá-lo no MongoDB Compass, utilize a conexão: 
```bash
mongodb+srv://admin:BSAvpDFDnMV8CPH6@cluster0.y6j52.mongodb.net/test
```

## Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina as seguintes ferramentas:
java 1.8 e Git.


## Endpoints

★ Retorna uma lista de Planetas

- HTTP Method: **GET**
- Path: /planet/

★ Retorna um Planeta pelo Id

- HTTP Method: **GET**
- Path: /planet/:id

★ Retorna um Planeta pelo nome

- HTTP Method: **GET**
- Path: /planet?name=:name

★ Permite deletar um Planeta

- HTTP Method: **DELETE**
- Path: /planet/:id

★ Permite inserir um Planeta

- HTTP Method: **POST**
- path: /planet
- _Body_ de exemplo:

```JSON
{
  "name": "Alderaan",
  "climate": "temperate",
  "terrain": "grasslands, mountains"
}
```


---

## Tecnologias

👉 [Git](https://git-scm.com/)

👉 [Spring Boot](https://spring.io/projects/spring-boot)

👉 [Spring Data Mongodb](https://spring.io/projects/spring-data-mongodb)

👉 [Mongodb](https://www.mongodb.com/)

👉 [MapStruct](https://mapstruct.org/)

---

## Autor

<a href="https://github.com/rafaelaandrews">
 <img style="border-radius: 50% 50% 0 0; padding-top:10px" src="https://avatars2.githubusercontent.com/u/37222413?s=460&u=dbdf89d17de90d22a48ae014e52e15402e2096c1&v=4" width="100px;" alt=""/>
</a>
<br />

### Feito por Rafaela Andrews 🤘 Entre em contato!

[<img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" height="40" width="40" alt="Medium" />](https://github.com/rafaelaandrews)&nbsp;&nbsp;&nbsp;
[<img src="https://www.iconfinder.com/data/icons/social-messaging-ui-color-shapes-2-free/128/social-linkedin-circle-512.png" height="40" width="40" alt="Linkedin" />](https://www.linkedin.com/in/rafaela-andrews-403190153/)&nbsp;&nbsp;

---
---