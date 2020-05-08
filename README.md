# Joko Microservices
Joko microservices provee un conjunto de proyectos base para una arquitectura en microservicios, 
está basado en spring cloud.

# Configuración de arranque 
Para poner en marcha la arquitectura en microservicios, se recomienda iniciar los proyectos en el siguiente orden:
- eureka-server
- config-server
- microservice1
- microservice2
- cloud-gateway

Pasos para arrancar los proyecto, como son proyectos spring-boot, se pueden hacerlo con el comando `mvn spring-boot:run`

En lo que respecta al visualizador de logs, se utiliza Zipkin server. El mismo debe estar activo una vez que empecemos a utilizar nuestra arquitectura si queremos de una interfaz para rastrear visualmente las llamadas que se realizan entre microservicios. 
Para descargar y arrancar el zipkin-server, se pueden seguir los siguientes pasos:
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```
Para hacerlo desde un docker:
```
docker run -d -p 9411:9411 openzipkin/zipkin
```

# Probar funcionamiento del `cloud-gateway`

- Invoca al microservice1: http://localhost:5555/api/micro1/v1/cities/1 
- Invoca al microservice2: http://localhost:5555/api/micro2/v1/countries/2


