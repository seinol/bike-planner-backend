Setup Local:
    execute docker-compose.yml
        PostgresDB: localhost:4100/greatnamedb
        Adminer: localhost:8095

    create Maven-Configuration:
        Command line: flyway:migrate
        Profiles: LOCAL_greatname_db
    execute Maven Flyway

    start Spring-Boot: GreatnameBackendApplication:
        Endpoint: http://localhost:4110/graphql
        GraphiQL: http://localhost:4110/graphiql (TODO does not work yet)
            alternatively:
                Desktop-App: https://www.electronjs.org/apps/graphiql (with Schema-Documentation)
                https://www.postman.com