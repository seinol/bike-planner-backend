## Setup Local for Development:
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

## Setup with Docker for Production
1. Prerequisites: <br />
1.1 Make sure you have installed the latest version of maven. <br />
1.2 Make sure you have installed the latest version of docker and docker-compose. <br />
1.3 You will need a DNS (A or CNAME) record pointed to your server for Lets Encrypt certs to work. <br />

2. Docker Setup: <br />
2.1 Go to docker/docker-compose.yml and change example.com with your specific domain. <br />
2.2 You may want to change the Basic Auth of the Traefik Dashboard (traefik.http.middlewares.traefik-auth.basicauth.users=) to your needs. Your setting has to be htpasswd compatible. For moreinformation please refer to the offical Traefik documentation. <br />
2.3 Execute docker-compose up -d to start the prepared Docker containers. <br />

3. Setup the Databse: <br />
3.1 Go back to the root directory of the repository. <br />
3.2 execute mvn flyway:migrate. <br />

4. Scale the Backend Service: <br />
4.1 Go back to the docker directory. <br />
4.2 Execute docker-compose scale backend=X. Replace X with the number of Replicas you need. Traefik will automatically loadbalance trafic between them afterwards.<br />
