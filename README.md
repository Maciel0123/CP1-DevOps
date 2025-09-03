# Docker Compose
Suba com:
```
docker compose up -d --build
docker compose ps
docker compose logs -f app
```
## Endpoints

- GET, POST:
```
http://localhost:8080/api/users
```

- GET, PUT, DELETE:
```
http://localhost:8080/api/users/{id}
```

Swagger: 
```
http://localhost:8080/swagger-ui.html
```

# Troubleshooting

- App não sobe:
```
docker ps
```
Vai listar algo como: 
`
CONTAINER ID   NAMES
123abc456def   dimdim-app
789ghi012jkl   dimdim-db
`
Depois rode:
```
docker compose logs -f dimdim-app
```
e
```
docker compose logs -f dimdim-db
```
Ou
```
docker compose logs -f app
```

- Acesso ao MySQL nega: confira .env e se o volume não travou credenciais antigas; se mudou senha, recrie o volume.

- Porta ocupada: mude APP_PORT (p.ex. 8081) e/ou 3306:3307.

# Integrantes:
- Gabriela Moguinho Gonçalves RM556143

- Henrique Maciel RM556480

- Mariana Christina Rodrigues Fernandes RM554773
