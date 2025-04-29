## Commandes utiles

* url de dev

```
http://localhost:8080/healthcheck
```

* lacement de l'application

```
./mvnw spring-boot:run
```

* lancement des tests

```
 ./mvnw clean test

```

* afficher le dependency tree

```
./mvnw dependency:tree  
  ```

## Rappel Docker

* Bd posgres de l'appli

```
version: '3.8'
services:
  postgresql:
    image: postgres:15
    container_name: postgres-spring-boot
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
    ports:
      - '5432:5432'
    volumes:
      - ./postgres.data:/var/lib/postgresql/data
```

* pour lancer la bd

```
docker-compose -f src/main/docker/postgresql.yml up

```


