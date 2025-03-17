# 🚀 **Flujo de Despliegue en el Curso**

Este curso sigue un **flujo estructurado de despliegue** que permite a los alumnos **desarrollar nuevas funcionalidades**, **validar los cambios** y **desplegar la aplicación en diferentes entornos**, todo integrado con **Jira y GitHub**.

📌 **Resumen del Flujo de Despliegue**

| 🌍 Entorno | 🚀 Método de Despliegue                 | 📌 Acceso                         |
|------------|-----------------------------------------|-----------------------------------|
| **Local** | Lamzar en IntelliJ modo automático      | `http://localhost:8080`           |
| **Desarrollo** | CI/CD con GitHub Actions                | `https://eoijava.ddns.net:808X`   |
| **Producción** | CI/CD con SonarQube y Aprobación Manual | `https://nombreproyecto.ddns.net` |

---

## 📌 **1️⃣ Integración con Jira: Creación de Ramas de Desarrollo**

📌 **Todos los cambios en el código se inician desde Jira**, donde cada tarea genera una rama asociada en GitHub automáticamente.

🔹 **Cómo se crean las ramas:**
- En Jira, los alumnos verán las tareas asignadas y seleccionarán una para trabajar.
- Al iniciar la tarea, Jira **creará automáticamente una rama en GitHub** con el formato:
  ```yaml
  feature/PROYECTO-123-nombre-de-la-tarea
  ```
- El alumno trabaja en la rama y cuando termina, **crea un Pull Request (PR)** para fusionarla en `develop`.

📌 **Ejemplo de flujo con Jira y GitHub:**
```
    A[Jira: Nueva Tarea] -->|Crea Rama en GitHub| B[feature/PROYECTO-123]
    B -->|Desarrollo en la rama| C[Subir cambios a GitHub]
    C -->|Crear Pull Request| D[Merge a develop]
    D -->|CI/CD valida cambios| E[Despliegue en Desarrollo]
```

✅ **Beneficios:**  
✔️ Facilita la trazabilidad entre tareas de Jira y código en GitHub.  
✔️ Evita errores en la creación manual de ramas.  
✔️ Automatiza el flujo de desarrollo.

---
## 📌 **1️⃣ Desarrollo Local con Testcontainers**

Durante el desarrollo local, utilizaremos **Testcontainers** para gestionar la base de datos PostgreSQL. Esto permite que la aplicación se ejecute en **IntelliJ** utilizando el perfil `AplicaciónEnLocal`, que inicia automáticamente un contenedor de PostgreSQL para pruebas.

**Configuración en `.run/AplicacionEnLocal.xml`:**
```xml
<component name="ProjectRunConfigurationManager">
    <configuration default="false" name="AplicaciónEnLocal" type="SpringBootApplicationConfigurationType" factoryName="Spring Boot">
        <option name="ACTIVE_PROFILES" value="local" />
        <module name="demo" />
        <option name="SPRING_BOOT_MAIN_CLASS" value="com.atm.buenas_practicas_java.Application" />
        <method v="2">
            <option name="Make" enabled="true" />
        </method>
    </configuration>
</component>
```

**Ventajas:**

- **Entorno Consistente:** Cada desarrollador trabaja con la misma versión de la base de datos, eliminando
  discrepancias.
- **Facilidad de Configuración:** Al utilizar Testcontainers, no es necesario instalar manualmente PostgreSQL en cada
  máquina de desarrollo.
- **Automatización de Pruebas:** Permite ejecutar pruebas de integración de manera automática utilizando una base de
  datos real en contenedor.
- **Portabilidad:** Funciona en cualquier entorno que soporte Docker, garantizando uniformidad en el desarrollo.
- **Aislamiento:** Cada contenedor está aislado, lo que reduce conflictos con otras configuraciones locales.

*Referencia:* [Spring Boot Application Testing and Development with Testcontainers](https://www.docker.com/blog/spring-boot-application-testing-and-development-with-testcontainers/)

## 📌 **2️⃣ Despliegue en Local con Docker Compose**

📌 **Cada alumno puede ejecutar la aplicación en su PC utilizando la configuración de ejecución indicada.**

🔹 **Pasos:**  
1️⃣ Clonar el repositorio:

```bash
git clone https://github.com/ateixeiramunoz/BuenasPracticasSpringBoot.git
cd BuenasPracticasSpringBoot
```

2️⃣ Ejecutar la configuración de ejecución **`AplicaciónEnLocal`** en IntelliJ:

- Esta configuración utiliza automáticamente el archivo `compose.yml` incluido en el proyecto mediante Spring
  Boot, lo que inicia los servicios definidos (aplicación y base de datos) sin comandos adicionales.

3️⃣ Acceder a la aplicación en `http://localhost:8080`

📌 **Ejemplo de `docker-compose.yml`**

```yaml
# Este archivo se utiliza para configurar los servicios de contenedores en un entorno de desarrollo, como la base de datos PostgreSQL que interactúa con una aplicación Spring Boot.
name: local
services:
  db:
    # Imagen de Docker que se utilizará, en este caso PostgreSQL
    image: postgres:latest
    # Indica que el contenedor se reiniciará automáticamente si falla
    restart: always
    environment:
      # Nombre de la base de datos que se creará al iniciar el contenedor
      POSTGRES_DB: 'localdb'
      # Usuario que se creará para acceder a la base de datos
      POSTGRES_USER: 'localuser'
      # Contraseña del usuario creado
      POSTGRES_PASSWORD: 'password123'
    ports:
      # Mapea el puerto 5432 del contenedor al puerto 5432 del anfitrión
      - '5432:5432'
    expose:
      # Expone el puerto 5432 dentro del contenedor para comunicación con otros servicios
      - '5432'
```

✅ **Beneficios:**  
✔️ Cada alumno trabaja en un entorno idéntico al del servidor.  
✔️ La base de datos y la aplicación se inician automáticamente sin comandos adicionales.  
✔️ Simplifica la ejecución local al integrarse con la configuración existente del proyecto.

---

## 📌 **3️⃣ Despliegue en Entorno de Desarrollo (CI/CD Automático)**

Cuando un alumno hace `merge` de su rama `feature/PROYECTO-123` en `develop`, se ejecuta un **pipeline automático** que:  
1️⃣ **Ejecuta los tests** para comprobar que el código funciona.  
2️⃣ **Construye la imagen Docker** y la sube a un **registro privado**.  
3️⃣ **Despliega la aplicación en el servidor de desarrollo**, accesible para todos.

📌 **Flujo Automático de Despliegue:**
```
    A[Alumno sube cambios a feature/*] -->|Merge| B[Branch develop]
    B -->|Ejecución de pruebas| C[CI/CD con GitHub Actions]
    C -->|Si todo es correcto| D[Despliegue en Servidor de Desarrollo]
    D -->|Aplicación accesible| E[Alumnos pueden probar]
```

📌 **Ejemplo de Pipeline (`.github/workflows/SubirDesarrollo.yml`)**
```yaml
name: Subida a Desarrollo

on:
  push:
    branches: [ "desarrollo" ]
  pull_request:
    branches: [ "desarrollo" ]

jobs:

  realizar_tests:
    runs-on: self-hosted
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 23
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      - name: Build with Maven
        run: mvn --batch-mode verify jacoco:report

  arrancar_en_servidor_de_desarrollo:
    needs: realizar_tests
    runs-on: self-hosted
    steps:
      - uses: actions/checkout@v4
      - name: Build the Docker image
        run: docker compose -f compose-desarrollo.yaml up -d
```

📌 **Acceso al Servidor de Desarrollo:**
- `develop` se despliega automáticamente siempre que se hayan cumplido los mínimos de cobertura y los test no fallen.
- Se puede acceder a la aplicación en `https://eoijava.ddns.net:808x`. Donde `x`corresponde al número del grupo.


✅ **Beneficios:**  
✔️ Asegura que únicamente código validado llega a `develop`.  
✔️ Permite que todos los alumnos prueben su aplicación en un entorno común.

¡Entendido! Voy a agregar un apartado específico dentro de **08_GESTION_DE_VERSIONES.md** para explicar **la validación de cobertura de código y cómo hacerlo desde IntelliJ IDEA**.

---

### 📌 **Validaciones en CI/CD: Cobertura de Código**

Para garantizar la calidad del código antes de fusionarlo en `develop`, cada **Pull Request** debe incluir pruebas automatizadas **y garantizar un nivel adecuado de cobertura de código**.

🔹 **Las pruebas verifican el correcto funcionamiento del código.**  
🔹 **La cobertura de código mide qué porcentaje del código ha sido ejecutado por los tests.**  
🔹 **El CI/CD rechazará cambios sin cobertura adecuada.**

✅ **Ejecutar las pruebas con cobertura antes de subir código**  
Los alumnos deben validar su código antes de hacer `commit`, verificando la cobertura con **JaCoCo** en IntelliJ IDEA o desde la terminal.

---

## 🛠 **Cómo Verificar la Cobertura de Código en IntelliJ IDEA**

### 🔹 **1️⃣ Ejecutar las pruebas con cobertura**
En **IntelliJ IDEA**, hay una opción integrada para ver la cobertura de código directamente.

📌 **Pasos en IntelliJ:**  
1️⃣ **Abrir la clase de test**, por ejemplo: `CalculatorServiceTest.java`.  
2️⃣ Hacer **clic derecho en la clase** y seleccionar **Run 'CalculatorServiceTest' with Coverage** (ícono de escudo verde 🛡️).  
3️⃣ IntelliJ ejecutará los tests y mostrará **el porcentaje de cobertura de código**.

---

### 🔹 **2️⃣ Interpretar los Resultados en IntelliJ**
🔹 **Código en verde** → Correctamente probado.  
🔹 **Código en amarillo** → Parcialmente cubierto.  
🔹 **Código en rojo** → No probado.

📌 **Ejemplo visual en IntelliJ:**
- Si una línea tiene un fondo **verde**, significa que los tests la ejecutaron.
- Si una línea tiene un fondo **rojo**, significa que no está cubierta por los tests.

---

## 📌 **Cómo Verificar la Cobertura desde Maven**
Si prefieres usar **la línea de comandos**, puedes ejecutar las pruebas y generar un informe de cobertura en formato HTML:

```sh
mvn clean verify jacoco:report
```

📌 **El informe se generará en:**
```
target/site/jacoco/index.html
```
✅ Abre este archivo en un navegador para ver el detalle de cobertura.

---

## 🚀 **Validación en CI/CD (GitHub Actions)**
Cada `Pull Request` activará **GitHub Actions**, que ejecutará las pruebas y generará un **reporte de cobertura**.

🔹 **Si las pruebas fallan o la cobertura es baja, el PR será rechazado.**  
🔹 **Los alumnos deberán mejorar la cobertura antes de fusionar los cambios.**

📌 **Ejemplo del pipeline en GitHub Actions:**
```yaml
name: Validación de Código

on:
  pull_request:
    branches: [develop]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout código
        uses: actions/checkout@v4
      - name: Ejecutar Pruebas y Cobertura
        run: mvn clean verify jacoco:report
      - name: Subir Reporte de Cobertura
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-report
          path: target/site/jacoco/
```

✅ **Esto garantiza que los cambios que se fusionan en `develop` cumplen con los estándares del curso.**

---

### 🎯 **Conclusión: Qué Deben Hacer los Alumnos**

✔️ **Ejecutar las pruebas con cobertura antes de hacer commit (`Run with Coverage`).**  
✔️ **Si hay líneas en rojo en IntelliJ, escribir más tests.**  
✔️ **Si la cobertura es baja, agregar más validaciones en los tests.**  
✔️ **Si el PR es rechazado por baja cobertura, corregirlo antes de fusionarlo.**

---

## 📌 **5️⃣ Creación de Release Semanal y Publicación**

Para garantizar un ciclo de desarrollo claro y organizado, el equipo sigue un flujo estructurado para crear y publicar *
*releases semanales**.

### 📌 **Flujo de Trabajo de Release Semanal**

1️⃣ **Planificación en Jira**: Identificar las tareas completadas durante la semana y validar que todas las `features` y
`bugfixes` están correctamente integradas en la rama `develop`.

2️⃣ **Creación de la Rama `release/*`**:

- Se crea una nueva rama `release/YYYY-MM/DD` desde `develop`.
- Esta rama recoge el estado final preparado para ser revisado y desplegado como una versión.

3️⃣ **Validación en Tutoría**:

- Durante una sesión de tutoría semanal, se realiza una validación conjunta del contenido de la rama `release`.
- Se identifican posibles problemas y se definen las tareas finales necesarias antes del despliegue en producción.

4️⃣ **Creación del Release Tag en GitHub**:

- Una vez validado, se genera un **tag en GitHub** con el esquema `vX.X.X`.
- Este tag será la referencia oficial utilizada para el despliegue en producción.

5️⃣ **Despliegue a Producción**:

- El tag generado es desplegado a producción sólo después de superar las validaciones de calidad (tests, SonarQube,
  etc.).
- Esto garantiza que únicamente código validado es publicado en el entorno de producción.


---

### ✅ **Beneficios:**

✔️ Permite seguimiento detallado y organizado del estado del proyecto cada semana.  
✔️ Involucra revisión y validación en equipo antes de desplegar.  
✔️ Evita errores al garantizar verificaciones en múltiples etapas.  
✔️ Publicar con tags en GitHub asegura rastreabilidad y control de versiones.

---

## 📌 **4️⃣ Despliegue en Producción (Control de Calidad y Aprobación)**

Para evitar errores en producción, el flujo de despliegue final pasa por **validación de calidad** antes de publicar la aplicación.

📌 **Pasos del Despliegue en Producción:**  
1️⃣ **Se crea una rama `release/*`** cuando la versión está lista.  
2️⃣ **El código pasa pruebas automáticas y validación en SonarQube**.  
3️⃣ **Si todo está correcto, se hace `merge` a `main` y se despliega.**

📌 **Acceso al Servidor de Producción:**

- `main` se despliega automáticamente siempre que se hayan cumplido los mínimos de calidad
- Sólo se podrán fusionar ramas release o en casos excepcionales, hotfix-
- Cada grupo podrá acceder a la aplicación en `https://proyecto.ddns.net`



📌 **Flujo de Producción:**
```
    A[Creación de rama release/*] --> B[Validación en SonarQube]
    B -->|Cumple calidad| C[Merge a main]
    B -->|No cumple calidad| D[Corrección en release/*]
    C -->|Despliegue en Producción| E[Disponible en app.leccionesgit.com]
```

📌 **Pipeline de Producción (`.github/workflows/production.yml`)**
```yaml
name: Deploy to Production
on:
  push:
    branches:
      - main
      - release/*
jobs:
  validate:
    runs-on: ubuntu-latest
    steps:
      - name: Ejecutar Tests
        run: mvn clean test
      - name: SonarQube Analysis
        env:
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}
        run: mvn sonar:sonar -Dsonar.projectKey=leccionesdegit
  deploy:
    needs: validate
    runs-on: ubuntu-latest
    steps:
      - name: Build Docker Image
        run: docker build -t lecciones-git .
      - name: Deploy on Production Server
        run: ssh usuario@servidor "docker-compose pull && docker-compose up -d"
```

✅ **Beneficios:**  
✔️ Solo código validado llega a producción.  
✔️ Se reducen errores en despliegues finales.  
✔️ Facilita la identificación de errores y problemas en etapas tempranas.  
✔️ Mantiene la estabilidad del entorno de producción con revisiones adicionales.  
✔️ Permite integración con herramientas de calidad como SonarQube para garantizar código optimizado.  
 

---

## 📜 **Conclusión: ¿Cómo Funciona el Flujo de Despliegue?**

1️⃣ **Cada tarea empieza en Jira y crea una rama `feature/*` en GitHub**.  
2️⃣ **El código se sube y se fusiona en `develop`, desplegándose automáticamente en desarrollo.**  
3️⃣ **Se crea una `release/*`, se valida la calidad y se despliega en producción.**

⬅️ **Anterior: [Estrategias de Despliegue](07_ESTRATEGIAS_DE_DESPLIEGUE.md)**  
📌 **Siguiente: [Gestión de Versiones con Git](08_GESTION_DE_VERSIONES.md) →**

