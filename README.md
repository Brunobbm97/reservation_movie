# 🎬 Movie Reservation API (Backend)

Este é o backend de um Sistema de Reservas de Cinema, desenvolvido como uma API RESTful em Java com Spring Boot. O objetivo principal deste projeto é gerir o agendamento de sessões, cadastro de filmes e, de forma rigorosa, **evitar a sobrelotação (overbooking)** através de um sistema de reserva de assentos com mapeamento visual (Fila e Número).

O projeto foi construído a pensar numa futura integração com um frontend desenvolvido em Angular.

---

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17 (ou superior)
* **Framework:** Spring Boot 3.x (Spring Web, Spring Data JPA)
* **Banco de Dados:** PostgreSQL 16 (via Docker Alpine)
* **Ferramentas:** Maven, Lombok (para redução de código repetitivo)
* **Testes de API:** Insomnia / Postman

---

## ⚙️ Principais Funcionalidades

O sistema está dividido para atender a duas lógicas de negócio distintas:

### 🛡️ Para Administradores

* **Gestão de Filmes:** Registo de filmes com título, descrição, género e imagem do cartaz.
* **Gestão de Salas:** Controlo das salas de cinema e da sua capacidade total.
* **Gestão de Sessões (Showtimes):** Agendamento de filmes para salas específicas em horários determinados.

### 👤 Para Clientes (Utilizadores)

* **Consulta de Catálogo:** Visualização dos filmes em cartaz e das respetivas sessões disponíveis.
* **Reserva de Assentos:** Escolha visual de lugares (ex: Fila A, Lugar 1) baseada na sala da sessão escolhida.
* **Garantia Anti-Overbooking:** O sistema verifica em tempo real a disponibilidade do assento exato no momento da compra, impedindo transações duplicadas.

---

## 🏛️ Modelo de Dados (Arquitetura)

O banco de dados relacional foi estruturado com as seguintes Entidades:

1. **User (Utilizador):** Guarda dados de acesso e a permissão (Admin/Cliente).
2. **Movie (Filme):** Catálogo de filmes.
3. **Room (Sala):** O espaço físico do cinema.
4. **Seat (Assento):** As cadeiras de uma sala (Fila e Número).
5. **Showtime (Sessão):** O elo que liga um Filme a uma Sala, num horário e com um preço específico.
6. **Reservation (Reserva):** Regista a compra final, ligando o Utilizador à Sessão e aos Assentos escolhidos.

---

## 🛠️ Como Executar o Projeto Localmente

### Pré-requisitos

* [Docker Desktop](https://www.docker.com/products/docker-desktop/) instalado e a rodar.
* [Java Development Kit (JDK) 17+](https://adoptium.net/) instalado.
* Uma IDE à tua escolha (IntelliJ IDEA, Eclipse, VS Code).

### Passo 1: Subir o Banco de Dados com Docker

O projeto utiliza um contentor Docker para o PostgreSQL, mapeado para a porta `5434` local (para evitar conflitos com outras instalações locais).

Na raiz do projeto, abre o terminal e executa:

```bash
docker-compose up -d
```

### Passo 2: Iniciar a Aplicação Spring Boot

Podes iniciar a aplicação diretamente pela tua IDE ou através do terminal usando o Maven:

Bash

```mvn spring-boot:run``` 

_A API ficará disponível na porta `8080` (`http://localhost:8080`)._

### Passo 3: Dados Iniciais (Seeding)

O sistema possui uma classe `DataSeeder` que preenche o banco de dados automaticamente ao iniciar a aplicação pela primeira vez. Ele cria:

* 2 Utilizadores (1 Admin, 1 Cliente).

* 1 Sala (Sala 1 - Principal).

* 3 Assentos na Sala 1 (A1, A2 e A3).

* * *

📡 Endpoints da API (Rotas Principais)
--------------------------------------

Aqui estão as rotas disponíveis para teste no Insomnia ou Postman:

### Filmes

* `GET /api/movies` - Lista todos os filmes.

* `POST /api/movies` - Cria um novo filme.

### Sessões

* `GET /api/showtimes/movie/{movieId}` - Lista as sessões de um filme.

* `POST /api/showtimes?movieId=1&roomId=1&startTime=2026-05-20T20:00:00&price=25.50` - Cria uma nova sessão.

### Reservas

* `POST /api/reservations` - Efetua a compra de bilhetes. (Corpo JSON abaixo)

`JSON
    {
        "userId": 2, 
        "showtimeId": 1,
        "seatIds": [1, 2]
    }`
