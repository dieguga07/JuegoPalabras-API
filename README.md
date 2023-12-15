# API - Juego Palabras DGV

## Equipos

### Obtener todos los equipos

- **Endpoint:** `/equipos`
- **Método:** `GET`
- **Respuesta:** Lista de equipos (200 OK).

### Obtener un equipo por ID

- **Endpoint:** `/equipos/{id}`
- **Método:** `GET`
- **Respuestas:** Detalles del equipo (200 OK), No encontrado (404).

### Agregar un nuevo equipo

- **Endpoint:** `/equipos`
- **Método:** `POST`
- **Cuerpo:** `{"name": "Nombre", "badge": "URL"}`
- **Respuestas:** Equipo creado (201 Created), Solicitud incorrecta (400 Bad Request).

### Eliminar un equipo por ID

- **Endpoint:** `/equipos/{id}`
- **Método:** `DELETE`
- **Respuestas:** Equipo eliminado (202 Accepted), No encontrado (404).

### Actualizar un equipo por ID

- **Endpoint:** `/equipos/{id}`
- **Método:** `PUT`
- **Cuerpo:** `{"name": "Nuevo Nombre", "badge": "Nueva URL"}`
- **Respuestas:** Equipo actualizado (200 OK), No encontrado (404).

## Jugadores

### Obtener todos los jugadores

- **Endpoint:** `/jugadores`
- **Método:** `GET`
- **Respuesta:** Lista de jugadores (200 OK), No encontrado (404).

### Obtener un jugador por ID

- **Endpoint:** `/jugadores/{id}`
- **Método:** `GET`
- **Respuestas:** Detalles del jugador (200 OK), No encontrado (404).

### Crear un nuevo jugador

- **Endpoint:** `/jugadores`
- **Método:** `POST`
- **Cuerpo:** `{"user": "Nombre", "avatarimg": "URL"}`
- **Respuesta:** Jugador creado (201 Created).

### Eliminar un jugador por ID

- **Endpoint:** `/jugadores/{id}`
- **Método:** `DELETE`
- **Respuestas:** Jugador eliminado (200 OK), No encontrado (404).

### Actualizar un jugador por ID

- **Endpoint:** `/jugadores/{id}`
- **Método:** `PUT`
- **Cuerpo:** `{"user": "Nuevo Nombre", "avatarimg": "Nueva URL"}`
- **Respuestas:** Jugador actualizado (200 OK), No encontrado (404).
