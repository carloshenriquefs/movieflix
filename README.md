# :construction: - Project Movieflix

- Implemente as funcionalidades necessárias para que os teste do projeto passem;
- Desenvolvimento TDD de API Rest com Java e Spring Boot;
- Realização de casos de uso;
- Consultas a banco de dados relacional com Spring Data JPA;
- Tratamento de erros com respostas HTTP customizadas;
- Controle de acesso por perfil de usuário e rotas;

##

## :desktop_computer: - Layout:

![image](https://github.com/carloshenriquefs/movieflix/assets/54969405/6da6c09c-45df-47ab-bfa2-d98c8448d5c1)

![image](https://github.com/carloshenriquefs/movieflix/assets/54969405/10556ee9-a05d-469a-9135-1bdf32ca2db5)

![image](https://github.com/carloshenriquefs/movieflix/assets/54969405/1b6d0649-b8fe-424e-a7db-e21e18f75c75)

##

## [![My Skills](https://skillicons.dev/icons?i=figma&theme=light)](https://skillicons.dev) - Figma:

https://www.figma.com/file/6JQVnxKgKtVHLleSBBgRin/MovieFlix-front-listagem?type=design&node-id=0-1&mode=design

##

## :clipboard: - Diagrama:

![movieflix drawio](https://github.com/carloshenriquefs/movieflix/assets/54969405/93e1a557-f073-44ea-b1f0-d0714459d74c)

##

## :mag: - Casos de Uso:

### :film_projector: - Listar Filmes:

- [] - O sistema aprensenta uma listagem dos nomes de todos gêneros, bem como uma listagem paginada com título, subtítulo, ano e imagem dos filmes, ordenada alfabeticamente por título;
- [] - O usuário visitante ou membro seleciona, opcionalmente, um gênero;
- [] - O sistema apresenta a listagem atualzada, restringindo somente ao gênero selecionado;

### :film_projector: - Visualizar detalhes do filme:

- [] - O usuário visitante ou membro seleciona um filme;
- [] - O sistema informa título, subtítulo, ano, imagem e sinopose do filme, e também uma listagem dos textos das avaliações daquele filme juntamente com nome do usuário que fez cada avaliação;
- [] - O usuário membro informa, opcionalmente, um texto para avaliação do filme;
- [] - O sistema apresenta os dados atualizados, já parecendo também a avaliação feita pelo usuário;

- [] - O sistema apresenta uam mensagem de que não é permitido texto vazio na avaliação;

##

### :white_check_mark: - Critérios:

##

- [] - GET /genres deve retornar 401 para token inválido;
- [] - GET /genres deve retornar 200 com todos gêneros para VISITOR logado;
- [] - GET /genres deve retornar 200 com todos gêneros para MEMBER logado;
- [] - GET /movies/{id} deve retornar 401 para token inválido;
- [] - GET /movies/{id} deve retornar 200 com o filme para VISITOR logado;
- [] - GET /movies/{id} deve retornar 200 com o filme para MEMBER logado;
- [] - GET /movies/{id} deve retornar 404 para id inexistente;
- [] - GET /movies deve retornar 401 para token inválido;
- [] - GET /movies deve retornar 200 com página ordenada de filmes para VISITOR logado;
- [] - GET /movies deve retornar 200 com página ordenada de filmes para MEMBER logado;
- [] - GET /movies?genreId={id} deve retornar 200 com página ordenada de filmes filtrados por gênero;
- [] - POST /reviews deve retornar 401 para token inválido;
- [] - POST /reviews deve retornar 403 para VISITOR logado;
- [] - POST /reviews deve retornar 201 com objeto inserido para MEMBER logado e dados válidos;
- [] - POST /reviews deve retornar 422 para MEMBER logado e dados inválidos;
