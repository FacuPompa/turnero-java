# Turnero Java

Aplicación de consola desarrollada en Java para administrar médicos, pacientes y turnos de un centro médico.

> Estado: Finalizado.

El proyecto lo construí progresivamente como práctica personal de Java, aplicando conceptos y aprendiendo también un flujo de trabajo real con Git y GitHub.

## Descripción

La aplicación permite registrar y consultar médicos, pacientes y turnos desde un menú interactivo.

Los datos se guardan en archivos de texto para que puedan recuperarse al volver a iniciar la aplicación.

## Funcionalidades actuales

- Registrar médicos.
- Mostrar médicos.
- Buscar médicos por ID.
- Registrar pacientes.
- Mostrar pacientes.
- Buscar pacientes por ID.
- Registrar turnos.
- Mostrar turnos.
- Buscar turnos por ID.
- Filtrar y mostrar turnos pendientes.
- Cancelar turnos.
- Marcar turnos como atendidos.
- Validar IDs duplicados.
- Evitar turnos ocupados para un mismo médico, fecha y hora.
- Validar especialidades mediante enums.
- Validar fechas y horas ingresadas por consola.
- Validar emails.
- Guardar médicos, pacientes y turnos en archivos.
- Leer los datos guardados al iniciar la aplicación.
- Utilizar excepciones personalizadas para errores del negocio.


## Estructura del proyecto

```text
turnero-java/
├── Main.java
├── .gitignore
├── data/
│   ├── medicos.txt
│   ├── pacientes.txt
│   └── turnos.txt
└── src/
    ├── classes/
    │   ├── CentroMedico.java
    │   ├── Medico.java
    │   ├── Paciente.java
    │   └── Turno.java
    ├── enums/
    │   ├── Especialidad.java
    │   └── EstadoTurno.java
    ├── exceptions/
    │   ├── EstadoTurnoInvalidoException.java
    │   ├── IdDuplicadoException.java
    │   └── TurnoNoDisponibleException.java
    └── utils/
        ├── FileUtils.java
        └── ScannerUtils.java
