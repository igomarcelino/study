# Projeto de Java + JDBC + POSTGRESQL


&nbsp;

### Projeto de cadastro de pessoas com Javafx

[Link do Pojeto](Languages/Java/Sistema-para-cadastro-de-clientes-teste)
&nbsp;

&nbsp;

### Camadas do prodjeto
- Aplicacao
- Apresentacao
- Dados
- Dominio
- Logica

&nbsp;


# Modelo de Tabela: cliente_teste

## Descrição
Tabela que armazena informações dos clientes.

## Estrutura da Tabela

| Coluna        | Tipo de Dados  | Restrições              |
|---------------|----------------|-------------------------|
| cliente_id    | serial         | PRIMARY KEY             |
| cod_cliente   | integer        | NOT NULL                |
| nome          | varchar(100)   |                         |
| cpf           | varchar(11)    |                         |
| sexo          | char(1)        |                         |
| d_nascimento  | varchar(10)    |                         |
| rua           | varchar(50)    |                         |
| numero        | varchar(10)    |                         |
| bairro        | varchar(50)    |                         |
| cidade        | varchar(50)    |                         |
| estado        | varchar(30)    |                         |
| telefone      | varchar(15)    |                         |

## Exemplo de Criação de Tabela

```sql
CREATE TABLE cliente_teste (
    cliente_id serial PRIMARY KEY,
    cod_cliente integer NOT NULL,
    nome varchar(100),
    cpf varchar(11),
    sexo char(1),
    d_nascimento varchar(10),
    rua varchar(50),
    numero varchar(10),
    bairro varchar(50),
    cidade varchar(50),
    estado varchar(30),
    telefone varchar(15)
);
```

&nbsp;

Utilizacao do JDBC para realizar a conexao com o banco de dados

[JDBC DOWNLOAD](https://www.oracle.com/br/database/technologies/appdev/jdbc.html)

### Utilizacao do CLIENTEDAO com PreparedStatement
[Link documentacao PreparedStatement](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/sql/PreparedStatement.html#execute())

## Telas do APP

![Tela inicial](https://i.imgur.com/TBOedOg.png)

![Navegacao Menu](https://i.imgur.com/V2pWoBX.png)


![Tela de cadastro](https://i.imgur.com/WpxPJmc.png)

