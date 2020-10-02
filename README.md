# SecuritySpark-LAB7-AREP
Aplicación web con conexión segura de https que consulta un ranking de equipos de futbol alojado en un servidor. El servidor y el cliente están desplegados en dos máquinas virtuales EC2 de AWS

EC2 Server

![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/server-lab7.PNG)

EC2 Client

![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/cliente-lab7.PNG)

## Arquitectura
![](https://github.com/andresro30/SecuritySpark-LAB7-AREP/blob/master/resources/img/arquitectura.png)

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
