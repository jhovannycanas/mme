# MME Test 
Repository containing MME challenge code

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. clone or download this repository to your local machine.

### Prerequisites

Java jdk 8
Maven 3.5

## IDE

1.	Intellij IDEA


# Running 
#### Components
1. create docker image-instance postgresql
2. Usuario service
3. Emprendimiento service
4. Angular component


Follow the next steps.

1. We Will download the image and create container 

` docker run -p 5432:5432 --name prueba -e POSTGRES_PASSWORD=postgres -v /c/postgres-data:/var/lib/postgresql/data -d postgres:10.6 `

by default user = postgres


run the container

` Docker run prueba `


We will use postgresql commands

display the databases

` docker exec prueba psql -U postgres -l `

then we execute the following commands to create the project database

` docker exec -it prueba psql -U postgres -c "CREATE DATABASE emprendimiento ENCODING 'utf8' TEMPLATE template0 LC_COLLATE 'C' LC_CTYPE 'C';" `

` docker exec -it prueba psql -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE emprendimiento TO postgres;" `

` docker exec -it prueba psql -U postgres -c "CREATE schema emprendimiento"; ` 

` docker exec -it prueba psql -U postgres -c "CREATE schema usuario"; `


2.	run the following command from the root directory of the project (where pom.xml is located) or at the project IDE terminal to do a first build.

` mvn clean package `

once the executable files have been created, you can check how they work

### Command
 
 ` java -jar [name component].jar `


3.	run the following command from the root directory of the project (where pom.xml is located) or at the project IDE terminal to do a first build to do the creation of docker containers from file for each of the components.

- Usuario component

` docker build -f Dockerfile -t jhovannydocker/usuario `

- Emprendimiento component

` docker build -f Dockerfile -t jhovannydocker/emprendimiento `

3.1 un the following command from the root directory of the project Angual(where package.json is located) or at the project IDE terminal to do a first build to do the creation of docker containers from file for each of the components.
- Angualar component

` docker build -t jhovannydocker/angular-app . `

4. run the containers


` docker run -p 8081:8081 -d jhovannydocker/usuario `

` docker run -p 8080:8080 -d jhovannydocker/emprendimiento ` 

` docker run -d -it -p 80:80/tcp --name angular-app ` 

5.	Individual Swagger URL of microservices :
	Running with docker Tools:
- http://192.168.99.100:8082/swagger-ui.html#/
- http://192.168.99.100:8081/swagger-ui.html#/

	Running with Docker Desktop
- http://localhost:8082/swagger-ui.html#/
- http://localhost:8081/swagger-ui.html#/
