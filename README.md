# Cadastro de Usuários - Java com JDBC e PostgreSQL

## Sobre o Projeto
Este é um sistema de cadastro de usuários desenvolvido em **Java 17**, utilizando **JDBC** para interagir com um banco de dados **PostgreSQL**. O projeto segue o padrão **MVC (Model-View-Controller)** para uma melhor organização do código.

## Funcionalidades
- 📌 **Cadastro de Usuários** com validação de dados
- 📋 **Listagem** de todos os usuários cadastrados
- 🔍 **Busca de Usuário** por nome
- ✏️ **Atualização** de dados do usuário
- ❌ **Remoção** de usuários por ID
- 🛠️ **Tratamento de erros e exceções**

## Tecnologias Utilizadas
- **Java 17**
- **PostgreSQL**
- **JDBC** (Java Database Connectivity)
- **Padrão MVC**

## Como Executar o Projeto
### 1️⃣ Configurar o Banco de Dados
Certifique-se de que o PostgreSQL está instalado e rodando na sua máquina. Crie o banco de dados e a tabela necessária:

```sql
CREATE DATABASE cadastro_usuarios;

\c cadastro_usuarios

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    idade INT NOT NULL CHECK (idade BETWEEN 1 AND 120)
);
```

### 2️⃣ Configurar as Credenciais de Acesso
No arquivo `Conexao.java`, altere as credenciais para corresponder à sua configuração:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/cadastro_usuarios";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

### 3️⃣ Executar o Programa
Abra o projeto em sua IDE.
Compile e execute o arquivo UsuarioServiceTest.java para testar a lógica de CRUD.
Para rodar o sistema, a classe principal será a do service ou o arquivo de teste.

### 4️⃣ Testar a Persistência em Memória
Se preferir não usar um banco de dados real, você pode optar pela implementação em memória fornecida pela classe UsuarioDAOMemoria.java, que simula a persistência dos dados sem a necessidade de uma conexão com o banco de dados.

## Estrutura do Projeto
```
/src
  ├── app          # Pacote contendo a classe principal (Main)
  ├── dao          # Classes de acesso ao banco de dados (JDBC)
  ├── model        # Classe que representa o modelo de Usuário
  ├── service      # Regra de negócio e validações
  ├── util         # Utilitários como validação e exceções
  ├── view         # Interface de interaçãocom o usuário no terminal
```

## Melhorias Futuras
- 🔐 Implementar autenticação de usuário
- 🖥️ Criar interface gráfica (Swing, JavaFX ou Web)
- 🔄 Implementar logs para auditoria
- ✅ Criar testes automatizados (JUnit)

---
Feito por **Ryan** 🚀


## Autores

- [@RyanCarvalho07](https://github.com/RyanCarvalho07)

