Instrucciones:
Crear la BD
Desplegar el Proyecto, creará las tablas y registrará un par de usuarios con algunos roles
Consumir los recursos
Usuarios pre-registrados
username: admin password: 1234 Rol asignado:ADMIN
username: user password: 1234 Rol asignado:USER

EndPoint abiertos:(Considerando que estas en localhost con el puerto 8080)
http://localhost:8080/auth/login (Login con user and password)
http://localhost:8080/auth/register (Creará el usuario con rol user)
http://localhost:8080/swagger-ui.html (Mestra la estructura documentada de los endPoints)
http://localhost:8080/method/get   (Devuelve un mensaje de texto)
http://localhost:8080/actuator/swagger-ui

Utiliza base de datos Postgres, evidentemente puedes cambiarlo a la de tu preferencia que sea relacional y tenga soporte JPA
Lombok y Mapstruct estan configurados para trabaajr juntos y no dar error en tiempo de ejecución.

