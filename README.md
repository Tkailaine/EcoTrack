# Projeto - Cidades ESG Inteligentes (EcoTrack)

Desenvolvemos o EcoTrack como uma solução para gerenciar pontos de coleta e descarte de resíduos na cidade, incentivando práticas sustentáveis alinhadas aos princípios de ESG. 

A aplicação é uma API REST desenvolvida em Java com Spring Boot, conectada ao banco de dados Oracle, empacotada com Docker e com deploy automatizado na Azure via GitHub Actions.

## Tecnologias utilizadas

- Java 21
- Spring Boot 3.3.5
- Oracle Database (com Flyway)
- Maven
- Docker e Docker Compose
- GitHub Actions
- Azure App Service

## Endpoints da API

Base URL Staging: `https://ecotrack-staging-ebgve0ghemape4ct.southafricanorth-01.azurewebsites.net`
Base URL Produção: `https://ecotrack-prod-egc2csamgqabakak.southafricanorth-01.azurewebsites.net`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | /api/pontos-coleta | Lista todos os pontos de coleta |
| GET    | /api/pontos-coleta/{id} | Busca um ponto por ID |
| POST   | /api/pontos-coleta | Cadastra um novo ponto |
| PUT    | /api/pontos-coleta/{id} | Atualiza um ponto existente |
| DELETE | /api/pontos-coleta/{id} | Remove um ponto por ID |

## Como rodar localmente com Docker

1. Crie o arquivo `.env` copiando o `.env.example`:
   ```bash
   cp .env.example .env
   ```

2. Suba o container com o Docker Compose:
   ```bash
   docker compose up -d --build
   ```

3. Para acompanhar os logs:
   ```bash
   docker compose logs -f
   ```

4. A aplicação fica disponível em:
   `http://localhost:8080`

5. Para parar a aplicação:
   ```bash
   docker compose down
   ```

## Containerização

Criamos o `Dockerfile` utilizando a imagem oficial do Java 21:

```dockerfile
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/EcoTrack-0.0.1-SNAPSHOT.jar"]
```

No `docker-compose.yml`, configuramos o serviço da aplicação mapeando a porta 8080, adicionando a rede `ecotrack-network`, o volume de logs e as variáveis de ambiente necessárias para conectar ao banco de dados Oracle.

## Pipeline CI/CD

Configuramos o workflow do GitHub Actions no arquivo `.github/workflows/deploy.yml` para rodar a cada push na branch `main`.

Dividimos a esteira em 4 etapas:
1. **Build**: baixa o código, instala a JDK 21 e compila o projeto.
2. **Testes**: roda os testes automatizados da aplicação (`./mvnw test`).
3. **Deploy Staging**: gera o arquivo `.jar` e realiza o deploy no ambiente de homologação do Azure App Service.
4. **Deploy Produção**: após o staging rodar com sucesso, publica a versão final no ambiente de produção na Azure.

Variáveis de ambiente (Secrets) configuradas no repositório:
- `AZURE_WEBAPP_NAME_STAGING` e `AZURE_WEBAPP_PUBLISH_PROFILE_STAGING`
- `AZURE_WEBAPP_NAME_PROD` e `AZURE_WEBAPP_PUBLISH_PROFILE_PROD`

## Prints do funcionamento

### Execução local via Docker
Em breve.

### Pipeline CI/CD no GitHub Actions
Em breve.

### Ambiente de Staging (Azure)
Em breve.

### Ambiente de Produção (Azure)
Em breve.
