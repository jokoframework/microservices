#!/bin/bash
docker ps -a

docker rm -f docker_eureka-server_1 docker_config-server_1 docker_microservice2_1 docker_microservice1_1 docker_cloud-gateway_1
docker rmi joko/cloud-gateway:latest joko/microservice1:latest joko/config-server:latest joko/eureka-server:latest

docker ps -a
docker image ls