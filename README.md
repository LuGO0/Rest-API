# Rest-API
 My Tinkering space for Learning Backend using Spring !
 
## Local Setup
1. Clone the Project
2. Setup mysql container first by pulling the image `docker pull mysql:5.6` then running the container using `docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -e MYSQL_USER=regular -e MYSQL_PASSWORD=root -d mysql:5.6`
3. Make sure the same credentials are setup in the `resources/application.properties` file
4. Build the jar file by running `mvn clean package`
5. Create a Docker container with the jar file by running `docker build . -t restapi`
6. Run the created container and link it to the already running sql container running `docker run -p 8080:8080 --name restapi --link mysql-db:mysql -d restapi`
7. It should run. If not Happy debugging :/

## For subsequent builds
1. Build the jar file again `mvn clean package`
2. Build the docker image again `docker build . -t restapi`
3. Simply run the container again, the DB container should always be running.
