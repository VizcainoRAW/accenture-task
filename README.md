# Proyecto Base Implementando Clean Architecture

API desarrollada con Spring Boot bajo principios de Clean Architecture, orientada a la gestión de franquicias, sucursales y productos, con persistencia de datos y despliegue mediante Docker.

## Descripción del proyecto

La aplicación permite administrar una lista de franquicias.  
Cada franquicia contiene sucursales, y cada sucursal contiene productos con su respectivo stock.

Este proyecto fue construido para responder a los criterios de una prueba técnica que solicita, entre otros puntos, endpoints para crear franquicias, sucursales y productos, eliminar productos, actualizar stock, consultar el producto con más stock por sucursal para una franquicia puntual, usar persistencia de datos y documentar el despliegue local en un README. :contentReference[oaicite:1]{index=1}

## Antes de iniciar

Empezaremos por explicar los diferentes componentes del proyecto y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

## Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura. Pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo Gradle pertenece a la capa del dominio. Implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos genéricos de los diferentes objetos de persistencia que puedan existir. Este tipo de implementaciones se realiza basándose en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006).

Estas clases no pueden existir solas y deben heredarse en los **Driven Adapters**.

### Driven Adapters

Los driven adapters representan implementaciones externas a nuestro sistema, como conexiones a servicios REST, SOAP, bases de datos, lectura de archivos planos y, en general, cualquier origen de datos con el que debamos interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura. Es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de uso de forma automática, inyectando instancias concretas de las dependencias declaradas. Además, inicia la aplicación. Es el único módulo del proyecto donde encontraremos la función `public static void main(String[] args)`.

Los beans de los casos de uso se disponibilizan automáticamente gracias a un `@ComponentScan` ubicado en esta capa.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Gradle
- WebFlux
- PostgreSQL
- Docker
- Docker Compose

## Funcionalidades

- Crear una nueva franquicia
- Crear una nueva sucursal asociada a una franquicia
- Crear un nuevo producto asociado a una sucursal
- Eliminar un producto de una sucursal
- Actualizar el stock de un producto
- Consultar el producto con mayor stock por sucursal para una franquicia específica
- Obtener un listado de productos indicando a qué sucursal pertenece cada uno

## Criterios de aceptación cubiertos

La prueba solicita, entre otros puntos, los siguientes criterios funcionales y técnicos: desarrollo en Spring Boot, endpoints para franquicia/sucursal/producto, actualización de stock, consulta del producto con mayor stock por sucursal, uso de persistencia de datos, empaquetado con Docker y la posibilidad de usar programación reactiva. :contentReference[oaicite:2]{index=2}

1. El proyecto debe ser desarrollado en Spring Boot.
2. Exponer endpoint para agregar una nueva franquicia.
3. Exponer endpoint para agregar una nueva sucursal a la franquicia.
4. Exponer endpoint para agregar un nuevo producto a la sucursal.
5. Exponer endpoint para eliminar un producto de una sucursal.
6. Exponer endpoint para modificar el stock de un producto.
7. Exponer endpoint para mostrar cuál es el producto que más stock tiene por sucursal para una franquicia puntual.
8. Utilizar un sistema de persistencia de datos.
9. Empaquetar la aplicación con Docker.
10. Utilizar programación funcional y/o reactiva como valor agregado.

## Documentación de la API

### Colección de Postman

Puedes importar la colección para probar los endpoints desde cualquiera de estas opciones:

- Archivo local: `root/criterial-endpoints.postman_collection.json`
- Colección pública:  
  `https://www.postman.com/lunar-space-659938/accenture-task/collection/0uzo3ad/criterial-endpoints?action=share&source=copy-link&creator=47902613&tab=overview`

### Ejecución local

1. Clona el repositorio.
2. Asegúrate de tener instalado:
   - Java 21
   - Docker
   - Docker Compose
3. Configura las variables de entorno necesarias para la base de datos si aplica.
4. Ejecuta la aplicación desde tu IDE o con Gradle.

Ejemplo:

```bash
./gradlew :app-service:bootRun
