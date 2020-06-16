# Joko Microservices
Joko microservices provee un conjunto de proyectos base para una arquitectura en microservicios, 
está basado en spring cloud.

# Requisitos
- Java jdk 8 o superior
- Maven 

# Configuración de arranque 
Para poner en marcha la arquitectura en microservicios, se recomienda iniciar los proyectos en el siguiente orden:
- eureka-server
- config-server
- microservice1
- microservice2
- oauth2-authorization-server
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
- Autenticar al usuario para obtener access token + refresh token : http://localhost:5555/oauth/token 
  ```
  Headers: 
  Authorization:Basic YXBwY2xpZW50OmFwcGNsaWVudEAxMjM=
  Content-Type :application/x-www-form-urlencoded
  ```
  ```
  Form:
  grant_type = password
  username = john
  password = john@123
  ```
  
- Invoca al microservice1: http://localhost:5555/api/micro1/v1/cities/1 con Header Authorization:Bearer -accessToken-
- Invoca al microservice2: http://localhost:5555/api/micro2/v1/countries/2 con Header Authorization:Bearer -accessToken-


