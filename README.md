# mega-sena

Projeto desenvolvido para estudos com o objetivo de gerar números aleatórios para a Mega-Sena

## Links do Projeto original

- [Documentação] - [clique aqui](http://144.91.91.185:4002/documentation)

## Descrição
Usuários podem consultar os resultados oficiais dos jogos da Mega-Sena, 
gerar números aleatórios para realizar uma aposta 
e salvar seus jogos para consulta posterior.

### Tecnologias usadas no projeto

- Postgres
- SpringCloud
- Swagger
- liquibase

### Instruções para Execução

Clone o repositório:
```bash
$ git clone https://github.com/vinicius-hora/mega-sena.git
```

### Execução Local:

Executar através da IDE.

### Execução via docker-compose:

```bash
$ docker-compose up -d
Obs: Isso realizará o build da imagem e executará o projeto.
```
Os scripts sql para criação das tabelas estão no diretório resources/db/migrations

### Variáveis de Ambiente

PORT: porta que será iniciado o projeto

ACTIVE_PROFILE:
dev - Banco de dados em memória,
test - deve passar os parametros do banco de dados

DB_URL: postgres (usuário do banco)

DB_USERNAME: postgres (senha do banco)

DB_PASSWORD: devbook (nome do banco)

TOKEN_API:

URL_API_MEGASENA: "https://apiloterias.com.br/app/"

DEV_URL: url do ambiente de dev - swagger

PROD_URL: url do ambiente de prod - swagger

