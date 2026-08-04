# Turnero Java — contexto y próximos pasos

Documento de continuidad del proyecto personal de agenda de turnos médicos.

## 1. Propósito del proyecto

Construir una aplicación para administrar los turnos de un centro médico pequeño.

La primera versión es una aplicación de consola en Java. Más adelante podrá evolucionar hacia un backend web en Java y una interfaz visual con React y Tailwind.

El proyecto es independiente del proyecto de películas/contenido utilizado como ejemplo en el curso de Platzi.

### Alcance actual

La aplicación permite trabajar con:

- Médicos.
- Pacientes.
- Turnos.
- Especialidades médicas.
- Estados de turno.
- Registro y consulta desde un menú de consola.

Por ahora no se manejan historias clínicas, diagnósticos ni información médica sensible.

## 2. Estado actual del repositorio

### Repositorio remoto

- GitHub: `https://github.com/FacuPompa/turnero-java.git`
- Rama principal: `main`
- Rama de trabajo actual: `feature/registrar-turnos`
- `.gitignore` creado para excluir archivos compilados y configuraciones locales.

### Commits y ramas

| Rama | Commit | Mensaje | Estado |
|---|---|---|---|
| `main` | `db14476` | `feat: create console turner foundation` | Base inicial |
| `feature/registrar-pacientes` | `dbb18a5` | `feat: add patient registration` | Rama de pacientes |
| `feature/registrar-turnos` | `0edaecf` | `feat: add appointment registration` | Rama actual |

Las tres ramas tienen referencias locales y remotas según el estado guardado en el repositorio. La rama de turnos fue creada a partir de la rama de pacientes, por lo que contiene también ese trabajo previo.

### Flujo de ramas adoptado

Por ahora se usa un flujo simple:

```text
main
└── feature/nombre-de-la-funcionalidad
```

`main` representa una versión funcional. Cada funcionalidad nueva se trabaja en una rama propia, se commitea, se sube a GitHub y luego se integra mediante Pull Request.

No se utiliza todavía una rama `develop`, porque agregaría complejidad innecesaria para esta etapa de aprendizaje.

## 3. Estructura actual del código

```text
turnero-java/
├── Main.java
├── .gitignore
└── src/
    ├── classes/
    │   ├── CentroMedico.java
    │   ├── Medico.java
    │   ├── Paciente.java
    │   └── Turno.java
    ├── enums/
    │   ├── Especialidad.java
    │   └── EstadoTurno.java
    └── utils/
        └── ScannerUtils.java
```

## 4. Clases y responsabilidades actuales

### `Medico`

Atributos actuales:

- Nombre.
- Apellido.
- Especialidad.
- Identificador.

Tiene constructor, getters y setters.

### `Paciente`

Atributos actuales:

- Nombre.
- Apellido.
- Email.
- Teléfono como `String`, para aceptar formatos como `+54`, espacios o guiones.
- Identificador.

Tiene constructor, getters y setters.

### `Turno`

Atributos actuales:

- Fecha como `LocalDate`.
- Hora como `LocalTime`.
- Médico relacionado.
- Paciente relacionado.
- Estado como `EstadoTurno`.
- Identificador.

El constructor establece automáticamente el estado inicial como `PENDIENTE`.

### `CentroMedico`

Administra tres listas:

- Lista de médicos.
- Lista de pacientes.
- Lista de turnos.

Actualmente puede:

- Agregar médicos.
- Mostrar médicos.
- Buscar médicos por ID usando streams.
- Agregar pacientes.
- Mostrar pacientes.
- Buscar pacientes por ID usando streams.
- Agregar turnos.
- Mostrar turnos relacionados con médico y paciente.

### `Especialidad`

Enum con especialidades médicas como clínica médica, pediatría, cardiología, dermatología, ginecología y otras.

### `EstadoTurno`

Enum actual:

- `PENDIENTE`.
- `ATENDIDO`.
- `CANCELADO`.

### `ScannerUtils`

Centraliza la entrada por consola mediante métodos estáticos para:

- Leer texto.
- Leer enteros con validación.
- Leer especialidades del enum.
- Leer fechas con formato `AAAA-MM-DD`.
- Leer horas con formato `HH:MM`.

### `Main`

Contiene el menú interactivo y coordina la aplicación.

Opciones actuales:

- Registrar médico.
- Mostrar médicos.
- Registrar paciente.
- Mostrar pacientes.
- Registrar turno.
- Mostrar turnos.
- Salir.

## 5. Contenidos del curso vistos

Los apuntes disponibles llegan hasta el archivo `030-interfaces.md`.

### Conceptos estudiados

- Casting implícito y explícito.
- Conversión de texto a números.
- Atributos y métodos estáticos.
- Clases utilitarias.
- Gestión de memoria, stack, heap y garbage collector.
- Encapsulamiento.
- Getters y setters.
- Listas y genéricos.
- Recorrido de listas con `for`, `foreach` y `forEach`.
- Asociación, agregación y composición.
- Menús con `while` y `switch`.
- Constantes en lugar de números mágicos.
- Validación de entradas con `Scanner`.
- Búsqueda y eliminación en listas.
- Expresiones lambda.
- Streams.
- `filter`, `findFirst`, `orElse` y `toList`.
- `map`, `mapToInt`, `sum`, `average`, `max` y `min`.
- Ordenamiento con `sorted` y `Comparator`.
- `limit`.
- Referencias a métodos.
- Enums.
- Excepciones checked y unchecked.
- Excepciones personalizadas.
- `throw` y `try-catch`.
- Records.
- Mapas y `HashMap`.
- Lectura de archivos.
- Escritura de archivos.
- Herencia.
- `instanceof` y polimorfismo.
- Clases abstractas.
- Interfaces.

## 6. Contenidos del curso aplicados al proyecto

Ya se aplicaron:

- Clases y objetos.
- Atributos privados.
- Constructores.
- Getters y setters.
- Relaciones entre objetos.
- Listas de objetos.
- `ArrayList`.
- `forEach` con lambdas.
- Búsqueda con streams.
- `findFirst` y `orElse(null)`.
- Enums.
- `LocalDate` y `LocalTime`.
- Menú con `while` y `switch`.
- Constantes para las opciones del menú.
- Métodos estáticos de utilidad mediante `ScannerUtils`.
- Validación básica de números, fechas, horas y especialidades.
- Trabajo con Git, ramas, commits, push y Pull Requests.

Todavía están estudiados pero no aplicados de forma completa:

- Excepciones personalizadas de negocio.
- Records.
- Mapas.
- Lectura y escritura de archivos.
- Herencia.
- `instanceof`.
- Clases abstractas.
- Interfaces.
- Ordenamiento y estadísticas con streams.

No es necesario forzar todos esos conceptos dentro del proyecto. Se incorporarán solamente cuando resuelvan una necesidad real.

## 7. Próximos pasos recomendados

### Paso 1: validar turnos duplicados

Antes de permitir agregar un turno, comprobar que el mismo médico no tenga otro turno con:

- La misma fecha.
- La misma hora.

Esta será la primera regla de negocio importante.

La validación debería vivir en `CentroMedico`, no en `Main`.

### Paso 2: crear una excepción de negocio

Si el horario ya está ocupado, crear una excepción específica y capturarla desde el menú para mostrar un mensaje claro.

Ejemplo conceptual de nombre:

```text
TurnoNoDisponibleException
```

### Paso 3: administrar estados

Agregar acciones para:

- Cancelar un turno.
- Marcar un turno como atendido.
- Consultar turnos pendientes.

Conviene buscar el turno por su ID antes de modificarlo.

### Paso 4: mejorar las búsquedas

Agregar búsquedas por:

- ID de turno.
- Fecha.
- Médico.
- Paciente.
- Estado.

Esto permitirá practicar streams de forma relacionada con el dominio real.

### Paso 5: mejorar la salida de consola

Separar mejor la presentación de los datos para que médicos, pacientes y turnos se lean claramente.

Más adelante se puede centralizar la representación mediante `toString()` o métodos de resumen.

### Paso 6: incorporar estadísticas

Usar streams y mapas para obtener:

- Cantidad de turnos por médico.
- Cantidad de turnos por especialidad.
- Cantidad de turnos por estado.
- Agenda de un médico para una fecha determinada.

### Paso 7: guardar los datos en archivos

Cuando la lógica de consola esté estable, agregar persistencia en archivos de texto.

El orden recomendado sería:

1. Guardar médicos.
2. Guardar pacientes.
3. Guardar turnos mediante sus IDs.
4. Leer los datos al iniciar la aplicación.

No conviene guardar directamente la representación completa de los objetos relacionados sin definir antes un formato estable.

### Paso 8: pruebas manuales y documentación

Probar como mínimo:

- Registrar un médico.
- Registrar un paciente.
- Registrar un turno válido.
- Buscar un médico inexistente.
- Buscar un paciente inexistente.
- Intentar reservar el mismo horario para el mismo médico.
- Cancelar un turno.
- Reiniciar la aplicación cuando exista persistencia.

Actualizar el `README.md` con la descripción, instrucciones de ejecución y flujo de ramas.

### Paso 9: futuro web

Cuando la versión de consola sea sólida:

- Separar la lógica de dominio de la entrada por consola.
- Crear un backend web en Java.
- Exponer operaciones como servicios web.
- Crear un frontend con React y Tailwind.
- Reemplazar los archivos por una base de datos.
- Agregar autenticación y roles.

La interfaz visual futura podría incluir agenda diaria, calendario semanal, filtros por médico, tarjetas de pacientes y estados visuales de los turnos.

## 8. Estado recomendado al retomar

Al continuar el proyecto:

1. Confirmar la rama actual con `git status`.
2. Verificar que los cambios de `feature/registrar-turnos` estén subidos.
3. Abrir o revisar el Pull Request correspondiente.
4. No empezar una nueva funcionalidad hasta decidir si la rama actual se integra a `main`.
5. Crear la siguiente rama desde la base correcta, por ejemplo `feature/validar-turnos`.

El próximo objetivo funcional recomendado es impedir turnos duplicados para un mismo médico, fecha y hora.

## 9. Instrucciones para la IA que continúe el proyecto

Copiar estas instrucciones al iniciar una nueva conversación con otra IA o con un nuevo asistente:

```text
Estoy construyendo un proyecto personal llamado turnero-java.

Es una aplicación de consola en Java para administrar un centro médico pequeño.
El proyecto es independiente de los ejemplos del curso de Platzi.

Mi nivel actual es inicial/intermedio. Estoy aprendiendo Java progresivamente y quiero construir el proyecto mientras estudio. Mis apuntes del curso están en archivos Markdown y deben considerarse la referencia principal para decidir qué conceptos introducir.

Reglas de acompañamiento:

1. Actuá como tutor y compañero de proyecto, no como generador automático de soluciones.
2. No me entregues código completo ni la resolución de un problema salvo que yo lo pida explícitamente.
3. Ayudame a pensar con preguntas, decisiones y pasos pequeños.
4. Si te pido ayuda con un método, explicame qué debería razonar y qué conceptos usar, pero dejame escribirlo.
5. Si comparto código, revisalo y señalame errores o decisiones de diseño sin reescribir todo.
6. Cuando haya un error, explicame primero qué significa, por qué ocurre y qué debería investigar.
7. Introducí un solo concepto nuevo por vez y relacionálo con los apuntes que ya estudié.
8. No avances todavía hacia Spring Boot, APIs, bases de datos, React o Tailwind salvo que yo lo pida.
9. No agregues complejidad por anticipado. No crear clases, patrones o capas que todavía no sean necesarias.
10. No modifiques archivos, borres código ni ejecutes comandos que cambien el repositorio sin pedirme autorización explícita.
11. Antes de sugerir cambios, revisá el estado actual de los archivos y respetá las decisiones ya tomadas.
12. Mantené separado el proyecto personal del turnero de los ejercicios y ejemplos de películas/contenido del curso.

Forma actual de trabajo:

- Primero definimos el problema en lenguaje normal.
- Luego identificamos clases, atributos y relaciones.
- Después implemento yo una parte pequeña.
- La IA revisa mi intento y me guía.
- Probamos manualmente desde la consola.
- Recién después pasamos a la siguiente funcionalidad.

Estado actual del proyecto:

- Aplicación de consola en Java.
- Clases principales: CentroMedico, Medico, Paciente y Turno.
- Enums: Especialidad y EstadoTurno.
- Utilidad: ScannerUtils.
- Se usan listas, relaciones entre objetos, streams, lambdas, enums, LocalDate, LocalTime, menú con while/switch y validación básica de entradas.
- GitHub remoto: https://github.com/FacuPompa/turnero-java.git
- Flujo de ramas: main y feature/nombre-de-la-funcionalidad.
- La funcionalidad de pacientes y la de turnos ya tienen ramas y commits propios.

Próximo objetivo definido:

Impedir que un médico tenga dos turnos para la misma fecha y hora. Primero ayudame a pensar la regla y dónde debería vivir; no me des la implementación completa.
```
