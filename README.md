# Proyecto Prueba Practica Desarrollador Java/AWS

Se requiere implementar una API para un catalogo de productos, que permita agregar un nuevo producto, listar los productos, esta
solucion debe estar desplegada en AWS

## Pre-requisitos para ambientar proyecto
* [AWS CLI](https://aws.amazon.com/cli/)
* [SAM CLI](https://github.com/awslabs/aws-sam-cli)
* [Maven](https://maven.apache.org/)
* [Java 11]

## Compilar proyecto XX
En linea de comando navegar hasta la carpeta raiz donde se encuentra el archivo template.yml, usar sam cli para compilar proyecto
```
$ sam build
```

## Desplegar proyecto a la nube
En linea de comando usar sam cli para realizar el despliegue, mediante --guided se preguntan paso a paso los datos de configuración

```
$ sam deploy --guided
```

Una vez que el despliegue este completo, sam cli mostrara los outputs como es la URL de Api Gateway

## Repositorio Git del Proyecto

https://github.com/jmaynec/challenge-principal

## ApiGateway

https://5yd9pwfh6i.execute-api.us-east-1.amazonaws.com/productos

## Archivo POSTMAN en la raiz del proyecto

PRUEBA_PRINCIPAL.postman_collection.json

## Implementacion de AWS Workflow Actions mediante archivo .github/worflows/sam-pipeline.yml



