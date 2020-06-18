#!/bin/bash
#Build all jars in order

cd ../eureka-server/
mvn clean package
mv target/*.jar ../docker

cd ../config-server/
mvn clean package
mv target/*.jar ../docker

cd ../microservice1/
mvn clean package
mv target/*.jar ../docker

cd ../microservice2/
mvn clean package
mv target/*.jar ../docker

cd ../cloud-gateway/
mvn clean package
mv target/*.jar ../docker
