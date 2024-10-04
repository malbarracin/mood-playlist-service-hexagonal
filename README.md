# mood-playlist-service-hexagonal

## Descripción del Proyecto

Este proyecto implementa un Servicio de Playlists Basadas en el Estado de Ánimo, que genera playlists personalizadas según el estado de ánimo del usuario. El servicio interactúa con la API de Spotify para buscar canciones que coincidan con estados de ánimo específicos (por ejemplo, Relajado, Motivado, Feliz) y crea playlists utilizando el flujo de credenciales de cliente de Spotify para la autenticación.

## Características

1. **Generación de Playlists Basadas en el Estado de Ánimo**: Los usuarios pueden ingresar su estado de ánimo, y el servicio generará una playlist correspondiente consultando la API de Spotify.

2. **Integración con Spotify**: Utiliza la API de Spotify para buscar canciones basadas en el estado de ánimo y generar playlists.

3. **Programación Reactiva:** Desarrollado con Spring WebFlux, lo que permite manejar peticiones web asíncronas de manera eficiente mediante flujos reactivos.

4. **Flujo de Credenciales de Cliente**: Implementa el flujo de credenciales de cliente de OAuth 2.0 para autenticarse con la API de Spotify.

## Arquitectura Hexagonal

La arquitectura hexagonal, también conocida como Ports and Adapters, es un patrón arquitectónico que separa la lógica de negocio de las preocupaciones externas. En este proyecto, se utilizan diferentes "puertos" para comunicar la lógica de negocio con las diferentes capas de la aplicación:

- **Capa de Aplicación**: Contiene los servicios que orquestan la lógica de negocio.
- **Capa de Persistencia**: Maneja el almacenamiento de usuarios a través de un repositorio.
- **Capa de Entrada/Salida**: Proporciona adaptadores para interactuar con el sistema, como controladores REST y mapeadores.
  
Esta separación permite que la lógica de negocio se mantenga independiente de la forma en que se exponen o almacenan los datos.
     |
## Requisitos

| Tecnología         |
|--------------------|
| ![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)               |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-6DB33F?logo=spring-boot&logoColor=white)        |
| ![Spring WebFlux](https://img.shields.io/badge/Spring%20WebFlux-3.3.3-6DB33F?logo=spring&logoColor=white)    |
| ![Spotify API](https://img.shields.io/badge/Spotify%20API-v1-1DB954?logo=spotify&logoColor=white)     |
| ![Maven](https://img.shields.io/badge/Maven-3.6.3-C71A36?logo=apache-maven&logoColor=white)              |
| ![Docker](https://img.shields.io/badge/Docker-20.10.7-2496ED?logo=docker&logoColor=white)   

## Levantar el Proyecto

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/malbarracin/mood-playlist-service-hexagonal.git
   cd mood-playlist-service-hexagonal


2. **Compilar el Proyecto**

   Asegúrate de tener Maven instalado y ejecuta el siguiente comando para compilar el proyecto:
   
   ```bash
   mvn clean install

3. **Ejecutar el Proyecto**

   Puedes ejecutar el proyecto como una aplicación Spring Boot utilizando el siguiente comando:
   
   ```bash
   mvn spring-boot:run   

## Uso

### 1. Acceder a Swagger UI

   1. Abrir Swagger UI: Accede a http://localhost:8081/mood-playlist-service/webjars/swagger-ui/index.html en tu navegador.

### 4. Utilizando **Postman Get a user by ID**

1. Abre **Postman** y crea una nueva **request** con los siguientes detalles:

   - **Method**: `GET`
   - **URL**: `http://localhost:8081/mood-playlist-service/playlists/mood/{mood}`

2. En la sección de **Headers**, agrega lo siguiente:

   - `Content-Type`: `application/json`

3. Haz clic en **Send** para enviar la solicitud.

4. Ejemplo de respuesta esperada:

   ```json
   {
      "id": "66ff6361ea932152954142df",
      "mood": "MOTIVATED",
      "trackUris": [
         "https://open.spotify.com/album/2M6JthahodGkMQrSOWizP3",
         "https://open.spotify.com/album/1DQimPEysFvVZRR2SI1aP1",
         "https://open.spotify.com/album/3Qq4kVfHPrs8xPKIYKmctl",
         "https://open.spotify.com/album/0yO1XWLElTDipTS8GtyFfw",
         "https://open.spotify.com/album/1AKqQIafedVgJCS1ZJukPn",
         "https://open.spotify.com/album/1ckzTnqodEadTaVWNjx4DK",
         "https://open.spotify.com/album/3mdsJ6WjtODV8Wax7xntBB",
         "https://open.spotify.com/album/6FkGZCPKzGfd142SL3Dunn",
         "https://open.spotify.com/album/70ERLNrnedgmyqSRWaEDld",
         "https://open.spotify.com/album/72i0l28kBTOIaYKC84tMGG"
      ]
   }
    
## ¿Te gusta el contenido que comparto? Invítame un café para ayudarme a seguir creando. ¡Gracias por tu apoyo!
[![Buy Me a Coffee](https://img.shields.io/badge/Buy%20Me%20a%20Coffee-F7DF1E?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://buymeacoffee.com/malbarracin)    
