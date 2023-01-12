# Proyecto Final: *Backend*

## 1.Introducción
En este proyecto final, más concretamente, para la parte Backend se ha decidido emplear un arquitectura de microservicios.
Se han creado un total de cuatro pequeños servicios que se ejecutan de manera independiente y autónoma.Los cuatro han sido creados
con el mismo lenguaje de programación, siendo en este caso Java el lenguaje escogido. 

## 2.Servicios
Se empezó el proyecto creando los tres servicios:

- *User-info-Service*: servicio en el cual reside toda la información de los usuarios, mediante la conexión a su base de datos. 
- *Post-info-Service*: servicio en el cual reside toda la información de los posts, mediante la conexión a su base de datos. 
- *Blog-data-Service*: responsable de la información del blog. Mediante este servicio se ha conseguido adjudicar una lista de posts 
a un autor concreto. Este servicio no tiene una base de datos propia, sino que se comunica con los dos anteriores para poder obtener 
la información necesaria. 

## 2.1 Servicios con base de datos propia

Como se ha explicado anteriormente, tenemos un total de dos servicios que acceden a una base de datos propia. Dentro de cada proyecto 
se puede encontrar la misma estructura de carpetas basada en el patrón de modelo vista controlador (MVC)

-Controlador: encargado de la comunicación con el exterior. Se encuentran todos los *endpoints* (rutas a las cuales se puede encontrar
el usuario).En ambos servicios se han empleado métodos HTTP (*GET*, *POST* Y *DELETE*). 
-Modelo: representación de los datos del dominio.
-Repositorio: encargado de resolver el acceso a los datos de nuestro servicio, es decir, desde donde se hacen las consultas a la base 
de datos.
-Servicio: componente encargado de resolver la lógica del controlador. 

Cabe destacar que dentro de ambos servicios, se encuentra la carpeta test, donde se han realizado test de las rutas de ambos servicios, 
y también del repositorio de los posts. 

A continuación se van a mostrar dos tablas que resumen la información de las rutas creadas en cada uno de los microservicios

 
#### RUTAS DEL SERVICIO *Post-info-Service* ####

| Ruta | Tipo de petición | Parámetros | Descripción | 
| --- | --- |  --- |  --- |
| /posts | GET | - | Listar todos los post  |
| /posts/{id} | GET | Identificador del post | Listar solo el post con dicho identificador |
| /postsUser/{userId} | GET | Identificador del usuario | Listar todos los post que tengan un mismo identificador de usuario |
| /posts | POST | Objeto de la clase post | Realizar un nuevo post |
| /posts/{id} | DELETE | Identificador del post  | Borrar un post mediante su identificador |


#### RUTAS DEL SERVICIO *User-info-Service* ####

| Ruta | Tipo de petición | Parámetros | Descripción | 
| --- | --- |  --- |  --- |
| /users | GET | - | Listar todos los usuarios  |
| /users/{id} | GET | Identificador del usuario | Listar solo el usuario con dicho identificador |
| /users| POST | Objeto de la clase user | Crear un nuevo usuario |
| /users/{id} | DELETE | Identificador del usuario  | Borrar un usuario mediante su identificador |


## 2.2 Servicio sin base de datos 
En este último servicio se tiene la misma estructura de carpetas basada en el MVC, aunque se carece de repositorio, ya que al no
tener base de datos es totalmente inecesario. 

-Controlador: encargado de la comunicación con el exterior. Se encuentran solamente un *endpoint* que obtiene la información de los
otros dos servicios y retorna la información de cada usuario unida con los posts asignados a este mismo usuario.
-Modelo: representación de los datos del dominio. Contiene tanto un modelo del post, un modelo de usuario y un modelo de blog (objeto 
de tipo usuario y lista de posts)
-Servicio: componente encargado de resolver la lógica del controlador. En este caso, siendo un poco más especificos, se detalla que el 
servicio busca un usuario con el identificador que le hemos pasado a la ruta, y busca a su vez todos los posts que tienen el mismo identificador
de usuario, creando una lista de posts y asignándosela al usuario que se está buscando. 

#### RUTAS DEL SERVICIO *Blog-data-Service* ####

| Ruta | Tipo de petición | Parámetros | Descripción | 
| --- | --- |  --- |  --- |
| /blog/user/{id} | GET | Identificador del usuario | Muestra un usuario concreto con todos sus posts  |


## 3. Discovery Service
Este sería el cuarto servicio que compone el Backend del proyecto en cuestión. Es el responsable de actuar como el Servidor Eureka (*eureka-server*), 
donde se registran todos los servicios (*eureka-clients*).

## 4. Comunicación interna de los servicios
Como ya se ha detallado anteriormente existe una conexión directa entre nuestros servicios, más concretamente entre el blog y los usuarios
y los posts. Para realizar esta comunicación se ha hecho uso de la libreria *OpenFeign*. Básicamente el servicio del Blog se ha creado una carpeta
llamada Cliente, donde internamente se han creado dos interfaces (una para el servicio de posts y la otra para el de usuarios), que contienen
las operaciones de mapeo de los dos servicios que se quieren consumir. 

## 5. Resumen
En este resumen final se muestra una tabla que permite al lector entender mejor como funciona la comunicación interna entre los servicios. Destacar
que cada uno de ellos se ha levantado en un puerto diferente y se le ha asignado un nombre. 
| Servicio | Puerto | Cliente/Servidor | Nombre de la aplicación | 
| --- | --- |  --- |  --- |
| Discovery Service | 8761 | Servidor | - |
| Blog-data-Service | 8081 | Cliente | blog-data-service |
| User-info-Service | 8082 | Cliente | user-data-service |
| Post-info-Service | 8083 | Cliente | post-data-service |

## 6. Lenguajes de programación
