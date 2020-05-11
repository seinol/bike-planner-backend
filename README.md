## Setup Local:
1. execute docker-compose.yml: <br />
1.1 PostgresDB: localhost:4100/greatnamedb <br />
1.2 Adminer: localhost:8095 <br />

2. create Maven-Configuration: <br />
2.1 Command line: flyway:migrate <br />
2.2 Profiles: LOCAL_greatname_db <br />
3. execute Maven Flyway <br />

4. start Spring-Boot: GreatnameBackendApplication:<br />
4.1 Endpoint: http://localhost:4110/graphql <br />
4.2 GraphiQL: http://localhost:4110/graphiql (TODO does not work yet) <br />
Alternatively: <br />
Desktop-App: https://www.electronjs.org/apps/graphiql (with Schema-Documentation) <br />
Postman: https://www.postman.com