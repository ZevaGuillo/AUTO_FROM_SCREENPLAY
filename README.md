# AUTO_FRONT_SCREENPLAY

Framework de pruebas automatizadas para la aplicacion de Ticketing, desarrollado con Serenity BDD, Screenplay y Cucumber.

## Tecnologias

- **Serenity BDD 5.3.2** - Framework de reportes y integracion
- **Serenity Screenplay** - Patron de diseno Actor-Task
- **Cucumber 7.34.2** - BDD con Gherkin
- **Selenium WebDriver** - Automatizacion de navegador
- **Gradle 8.10** - Gestion de build y dependencias

## Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── com/ticketing/
│           ├── tasks/          # Tareas (Screenplay)
│           ├── questions/      # Preguntas al UI
│           ├── ui/             # Page Objects y Selectors
│           └── interactions/   # Interacciones especiales
└── test/
    ├── java/
    │   └── com/ticketing/
    │       ├── stepdefinitions/  # Step definitions de Cucumber
    │       └── runners/          # Test runners
    └── resources/
        ├── features/           # Archivos .feature (Gherkin)
        └── serenity.conf       # Configuracion de Serenity
```

## Escenarios de Prueba

| Tag | Escenario | Descripcion |
|-----|-----------|-------------|
| `@admin` | Admin Event Management | Suite de pruebas para gestion de eventos |
| `@edit-event` | Admin edits an existing event | Verifica la edicion de un evento existente |
| `@generate-seats` | Admin generates seats for an event | Verifica la generacion de asientos |
| `@create-event` | Admin attempts to create event with invalid data | Verifica validacion de campos obligatorios |

## Ejecucion de Tests

### Requisitos Previos

- **Java 21** instalado y configurado en PATH
- **Google Chrome** instalado
- **ChromeDriver** compatible con la version de Chrome (manejado automaticamente por WebDriverManager)

### Ejecutar Todos los Tests

```bash
gradle clean test
```

### Ejecutar Tests Especificos por Tag

```bash
gradle test -Dcucumber.filter.tags="@edit-event"
gradle test -Dcucumber.filter.tags="@generate-seats"
gradle test -Dcucumber.filter.tags="@create-event"
```

### Ejecutar un Escenario Especifico

```bash
gradle test -Dcucumber.filter.tags="@admin and @edit-event"
```

### Ver Reportes

Los reportes de Serenity se generan automaticamente en:

```
target/site/serenity/index.html
```

Para abrir en el navegador:

```bash
# Linux
xdg-open target/site/serenity/index.html

# macOS
open target/site/serenity/index.html

# Windows
start target/site/serenity/index.html
```

## Configuracion

### serenity.conf

Archivo principal de configuracion ubicado en la raiz del proyecto.

#### Propiedades Principales

| Propiedad | Descripcion | Valor por Defecto |
|-----------|-------------|-------------------|
| `webdriver.driver` | Navegador a usar | `chrome` |
| `webdriver.wait.for.timeout` | Tiempo de espera global | `30000` ms |
| `webdriver.timeouts.implicitlywait` | Tiempo de espera implicito | `5000` ms |
| `webdriver.base.url` | URL base de la aplicacion | `http://localhost:3000` |
| `serenity.take.screenshots` | Captura de pantallas | `AFTER_EACH_STEP` |

#### Ambientes

El framework soporta multiples ambientes:

```hocon
environments {
  default {
    ticketing.url = "http://localhost:3000"
  }
  
  staging {
    ticketing.url = "https://staging.ticketing.com"
  }
  
  production {
    ticketing.url = "https://ticketing.com"
  }
}
```

Para ejecutar contra un ambiente especifico:

```bash
gradle test -Denvironment=staging
```

### Configuracion de Chrome

```hocon
chrome {
  switches = "--no-sandbox,--disable-dev-shm-usage,--disable-extensions,--disable-gpu,--window-size=1920,1080"
}
```

## Patron Screenplay

El proyecto utiliza el patron **Screenplay**, donde:

- **Actors** (Actores): Usuarios que realizan acciones
- **Tasks** (Tareas): Acciones que los actores realizan
- **Questions** (Preguntas): Consultas al estado de la aplicacion
- **Interactions** (Interacciones): Acciones de bajo nivel con el navegador

### Ejemplo de Actor

```java
OnStage.theActorInTheSpotlight().attemptsTo(
    Click.on(AdminEventsPage.CREATE_BUTTON),
    WaitUntil.the(AdminEventFormPage.EVENT_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds()
);
```

## Apoyar en Fallos

### Error: `UndefinedEnvironmentVariableException`

Verificar que el archivo `serenity.conf` tenga las propiedades de ambiente configuradas correctamente y que el ambiente seleccionado exista.

### Error: `NoSuchElementException`

- El elemento no se encuentra en el DOM. Verificar que el locator sea correcto.
- El modal/pagina no cargo completamente. Agregar `WaitUntil` antes de interactuar.

### Error: `ChromeDriver version mismatch`

Limpiar cache de Gradle:

```bash
rm -rf ~/.gradle/caches/modules-2/files-2.1/org.seleniumhq.selenium
gradle clean test
```

## Comandos Utiles

```bash
# Limpiar build y reportes
gradle clean

# Ejecutar solo compile (sin tests)
gradle compileJava compileTestJava

# Ver version de Gradle
gradle --version

# Forzar actualizacion de dependencias
gradle --refresh-dependencies test
```

## Notas Adicionales

- Los tests ejecutan contra `http://localhost:3000` por defecto
- El navegador Chrome se maximiza automaticamente
- Se capturan pantallas en cada paso (`AFTER_EACH_STEP`)
- El navegador se reinicia por escenario (`restart.the.browser.each.scenario = false`)
