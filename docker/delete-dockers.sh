#!/bin/bash
docker ps -a

docker rm -f eureka-server  config-server  microservice2  cloud-gateway  microservice1
docker rmi joko/cloud-gateway:latest joko/microservice1:latest joko/config-server:latest joko/eureka-server:latest

docker ps -a
docker image ls
