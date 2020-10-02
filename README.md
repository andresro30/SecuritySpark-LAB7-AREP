# SecuritySpark-LAB7-AREP
Aplicación web que usa un login como medio de autenticación y se conecta a través de servicios Rest a un servidor que ofrece información de un ranking de equipos de futbol, con el objetivo final de mostrar la información ofrecida por el servidor.

Las comunicaciones que tiene la aplciación cumplen con los estándares de seguridad y los principios de integridad, autorización y autentitación. Se implementaron un par de llaves (públicas y privada) y se generó un cretificado para poder realizar conexiones a través del protocolo https entre los dos microservicios, implementados en un máquinas virtuales EC2 de AWS.

EC2 Server

![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/server-lab7.PNG)

EC2 Client

![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/cliente-lab7.PNG)

## Arquitectura
![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/arquitectura.png)

En esta arquitectura hay dos microservicios principales:
* Cliente: tiene una página de login donde recibe la información inicial del usuario y la envía a través de apiRest al servidor. Recibe información del servidor y la muestra al usuario en la interfaz gráfica. Tiene un sistema de encirptación de contraseñas(Sha1) para garantizar una correcta autenticación a la aplicación. 
* Servidor : Se encarga de devolver la información del ranking de equipos de futbol en formato JSON al cliente. 

## Diseño
Diagrama de clases de la aplicación:

![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/diagrama.PNG)


## Pre-requisitos
* [Maven](https://maven.apache.org/) : Herramienta encargada de la construcción del proyecto y el manejo de dependencias
* [Git](https://git-scm.com/) : Sistema de control de versiones.
* [JDK](https://www.oracle.com/technetwork/es/java/javase/downloads/index.html) : Herramienta de Desarrollo para Java 

Es importante verificar que usted cuente con los siguientes programas 
* Versión de Maven:
```
mvn -version
```
* Versión de Git:
```
git --version
```
* Versión del JDK:
```
java -version
```

## Instalación
Para instalar el programa debe descargar el repositorio usando el siguiente comando desde su consola CMD
```
git clone https://github.com/andresro30/SecuritySpark-LAB7-AREP.git
```
## Ejecución
Para compilar el proyecto debe use el siguiente comando cuando acceda al directorio SecuritySpark
```
mvn package
```
Cuando ya el proyecto ha compilado, puede proceder a ejecutar el Servidor, use el siguiente comando sobre el directorio SecuritySpark
```
java -cp target/SecuritySparkApp-1.0-SNAPSHOT.jar edu.escuelaing.arep.server.SecuritySparkServer
```
Cuando ya el proyecto ha compilado, puede proceder a ejecutar el Cliente, use el siguiente comando sobre el directorio SecuritySpark
```
java -cp target/SecuritySparkApp-1.0-SNAPSHOT.jar edu.escuelaing.arep.c
lient.SecuritySparkApp
```

Nota: Estos pasos indican la forma de compilar el proyecto localmente

## Visaluización del programa
En este [video](https://youtu.be/GAX_WP6b8dU) se muestra la aplicación funcionando a através de las máquinas de AWS.

## Construido con
* [Maven](https://maven.apache.org/) : Herramienta encargada de la construcción del proyecto y el manejo de dependencias
* [Spark](https://spark.apache.org/docs/0.9.1/java-programming-guide.html) : Framwework para desarrollo de aplicaciones web
* [Git](https://git-scm.com/) : Sistema de control de versiones.
* [CircleCI](https://circleci.com/) : Integración contínua [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/andresro30/SparkWebCalculadora-Lab2AREP)
* [AWS](https://aws.amazon.com/es/education/awseducate/) : Proveedor de servicios cloud 
* Java : Lenguaje de Programación.
## Autor
* **Andrés Rocha** - [andresro30](https://github.com/andresro30)

## Licencia 
Este proyecto está licenciado por Apache License 2.0 - mira aquí [LICENSE.md](LICENSE.txt) los detalles
