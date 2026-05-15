📦 Sistema de Controle de Equipamentos (Contador)
Este projeto é uma aplicação Fullstack desenvolvida para o gerenciamento e inventário de equipamentos. O sistema permite cadastrar equipamentos com fotos, listar, visualizar detalhes, editar e excluir registros (CRUD completo).

🚀 Funcionalidades
Cadastro de Equipamentos: Registro de nome, operador, datas de entrada/saída e comentários.

Upload de Fotos: Armazenamento de imagens dos equipamentos em diretório local.

Visualização Detalhada: Página exclusiva para ver informações completas e a foto do equipamento.

Gestão de Dados: Editar informações existentes ou excluir registros do inventário.

Banco de Dados Persistente: Integração com MySQL via Docker.

🛠️ Tecnologias Utilizadas
Backend: Java 17 com Spring Boot 4.0

Frontend: HTML5, Thymeleaf e Bootstrap 5

Banco de Dados: MySQL 9.0

Containerização: Docker & Docker Compose

Persistência: Spring Data JPA / Hibernate

📂 Estrutura de Pastas Principal
Plaintext
src/main/java/br/com/contador/cont/
├── config/       # Configurações de recursos estáticos (fotos)
├── controller/   # Rotas e controle de navegação
├── dtos/         # Objetos de transferência de dados (Data Transfer Objects)
├── model/        # Entidades mapeadas para o Banco de Dados
├── repository/   # Interfaces de comunicação com o MySQL
└── services/     # Regras de negócio e lógica de upload
🔧 Como Executar o Projeto
1. Requisitos
   Java 17 ou superior.

## 📸 Demonstração

### Tela Principal
Aqui você pode ver a listagem de todos os equipamentos cadastrados:
![Home do Sistema](img/home.png)

### Detalhes do Equipamento
Página que exibe as informações detalhadas e a foto do produto:
![Tela de Detalhes](img/detalhes.png)

Maven instalado.

Docker Desktop (para o banco de dados).

2. Configurar o Banco de Dados
   Com o Docker instalado, rode o comando na raiz do projeto:

Bash
docker-compose up -d
Isso subirá um container MySQL na porta 3307.

3. Executar a Aplicação
   Você pode rodar via sua IDE (IntelliJ/Eclipse) ou pelo terminal:

Bash
mvn spring-boot:run
4. Acessar o Sistema
   Abra o navegador e acesse:
   http://localhost:8080/home

🖼️ Configuração de Upload
As fotos enviadas pelo sistema são armazenadas na pasta raiz do projeto:

Pasta: /upload-dir/

Acesso via Web: Mapeado na rota /imagens/ através da classe WebConfig.

✒️ Autor
Cyro Luis - Desenvolvedor Fullstack