sudo apt update
sudo apt install openjdk-17-jdk -y
sudo apt install nginx -y
sudo apt install maven -y
mvn --version
cd Simple-spring-boot-app
mvn install

sudo kill -9 $(sudo lsof -t -i:8080)
java -jar ./target/springboot-first-app-0.0.1-SNAPSHOT.jar > application.log &