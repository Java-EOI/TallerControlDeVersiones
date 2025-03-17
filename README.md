
# 🚀 **Taller de Resolución de Conflictos en Git**

## 📌 **Introducción**
Bienvenido al **Taller de Resolución de Conflictos en Git**, diseñado para ayudarte a **comprender y resolver conflictos de Git en un entorno realista**.

Git es una de las herramientas más utilizadas en el desarrollo de software para gestionar versiones de código y facilitar el trabajo colaborativo. Sin embargo, cuando varios desarrolladores trabajan en el mismo proyecto, es común que surjan **conflictos en la fusión de cambios**.

En este taller, aprenderás:  
✅ Cómo identificar y resolver **conflictos de Git** de manera efectiva.  
✅ Cómo usar **IntelliJ IDEA** para gestionar conflictos sin necesidad de línea de comandos.  
✅ Buenas prácticas en **control de versiones** para evitar problemas en equipos de desarrollo.  
✅ La importancia de los **tests automatizados** para validar los cambios después de resolver conflictos.

El objetivo es que al finalizar el taller, te sientas cómodo resolviendo conflictos en proyectos colaborativos y puedas aplicar estas habilidades en el mundo real.

---

## 🛠 **Requisitos Previos**
Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu equipo:

- **Git** → [Descargar aquí](https://git-scm.com/downloads)
- **IntelliJ IDEA** (versión Community o Ultimate) → [Descargar aquí](https://www.jetbrains.com/idea/download/)
- **Java 17+** → [Descargar aquí](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Maven** → [Descargar aquí](https://maven.apache.org/download.cgi)
- **Spring Boot** (se ejecutará automáticamente desde IntelliJ con Maven)

Si aún no los tienes instalados, puedes descargarlos desde sus sitios oficiales antes de continuar.

---

## 🔄 **Cómo Obtener el Proyecto**
Para realizar el taller, primero debes hacer un **fork** del repositorio original.

### ✅ **Paso 1: Hacer un Fork del Repositorio en GitHub**
1️⃣ **Haz clic en el botón `Fork` (arriba a la derecha).**  
2️⃣ **Selecciona tu cuenta de GitHub o una organización donde quieras guardar el fork.**

Esto creará una copia del repositorio en tu cuenta, donde podrás trabajar sin afectar el original.

---

### ✅ **Paso 2: Clonar el Proyecto en IntelliJ IDEA**
💡 **Trabajaremos exclusivamente desde IntelliJ IDEA**, así que sigue estos pasos para clonar el proyecto correctamente:

1️⃣ **Abre IntelliJ IDEA**  
2️⃣ **En la pantalla de inicio, selecciona `Get from VCS`**  
3️⃣ **En `Version Control`, elige `Git`**  
4️⃣ **Introduce la URL de tu fork del repositorio:**
   ```
   https://github.com/TU-USUARIO/TallerControlDeVersiones.git
   ```
5️⃣ **Haz clic en `Clone` y espera a que IntelliJ descargue el proyecto.**  
6️⃣ **Una vez clonado, IntelliJ detectará automáticamente que es un proyecto Maven.**  
7️⃣ **Ejecuta el comando `mvn install` desde la terminal de IntelliJ o usa la opción de `Reload Maven Project`.**

7✅ **Ahora estás listo para empezar el taller.**

---

## 📂 **Estructura del Proyecto**
```
📂 leccionesdegit
 ├── 📂 src
 │   ├── 📂 main
 │   │   ├── 📂 java/com/eoi/java6/leccionesdegit
 │   │   │   ├── 📂 controller     (Controladores Spring)
 │   │   │   ├── 📂 service        (Lógica de negocio)
 │   │   │   ├── 📂 model          (Modelos de datos)
 │   │   │   ├── 📂 repository     (Acceso a datos si fuera necesario)
 │   │   │   ├── 📄 Calculator.java  (Clase de lógica matemática)
 │   │   ├── 📂 resources
 │   │       ├── 📂 templates      (Vistas Thymeleaf)
 │   │       ├── 📂 static         (CSS, JS, imágenes)
 │   │       └── 📄 application.properties  (Configuración)
 │   ├── 📂 test
 │       ├── 📂 java/com/eoi/java6/leccionesdegit
 │       │   ├── 📂 controller  (Tests de controladores)
 │       │   ├── 📂 service     (Tests de lógica)
 │       │   ├── 📄 CalculatorServiceTest.java
 ├── 📄 README.md
 ├── 📄 pom.xml  (Archivo Maven)
 └── 📄 .gitignore
```

✅ **Cada ejercicio en el taller se basa en una rama de Git diferente que contiene un conflicto intencional.**

---

### 🚀 **Cómo Resolver los Ejercicios del Taller**

### 🏆 **Metodología del Taller**
Este taller está estructurado en **10 ejercicios**, organizados de forma progresiva. En cada ejercicio:

1️⃣ Harás un **fetch para asegurarte de tener todas las ramas disponibles** en tu copia local.  
2️⃣ **Cambiarás a la rama del ejercicio** en IntelliJ IDEA.  
3️⃣ **Intentarás fusionarla con la otra rama que genera el conflicto**.  
4️⃣ Resolverás el conflicto utilizando **las herramientas de IntelliJ IDEA**.  
5️⃣ **Ejecutarás los tests automatizados** para validar que el código funciona correctamente.  
6️⃣ **Confirmarás (`commit`) y subirás (`push`) la solución a GitHub**.

Cada ejercicio tiene su propio archivo **README.md** con instrucciones detalladas. **Es importante seguirlos en orden, ya que los cambios en un ejercicio afectan los siguientes.**

---

### ✅ **Paso 1: Asegurar que tienes todas las ramas disponibles**

🔹 **Si no ves las ramas del ejercicio en IntelliJ, primero haz un `fetch` para traer la información de las ramas
remotas:**

📌 **En IntelliJ IDEA:**  
1️⃣ Ve al menú **Git > Fetch** o usa el atajo `Ctrl + Alt + J` (Windows/Linux) o `Cmd + Shift + J` (Mac).


📌 **Comando equivalente en la terminal de IntelliJ:**
```bash
git fetch --all
```

2️⃣ Espera a que IntelliJ actualice la lista de referencias remotas.  
3️⃣ Abre la ventana de Git (`Alt + 9` o `View > Tool Windows > Git`) y haz clic en `Branches`.  
4️⃣ Expande `Remote Branches` y verifica que aparecen las ramas `ejercicioX-rama1` y `ejercicioX-rama2`.


📌 **Nota:** Si también necesitas descargar el contenido de las ramas remotas, debes crear localmente una copia de las
ramas remotas que desees, usando el siguiente comando, aunque por el momento no hace falta:

```bash
git checkout -b [nombre_rama_local] origin/[nombre_rama_remota]
```

---

### ✅ **Paso 2: Cambiar a la Rama del Ejercicio**

📌 **En IntelliJ IDEA:**  
1️⃣ Abre la ventana de Git (`Alt + 9` o `View > Tool Windows > Git`).  
2️⃣ Haz clic en `Branches` y selecciona `ejercicio1-rama1`.  
3️⃣ Haz clic en `Checkout`.

📌 **Comando equivalente en la terminal de IntelliJ:**
```bash
git checkout -b ejercicio1-rama1
```

✅ **Ahora estás en la rama del ejercicio y listo para el siguiente paso.**

---

### ✅ **Paso 3: Intentar Fusionar con la Otra Rama**

📌 **En IntelliJ IDEA:**  
1️⃣ Abre la ventana de Git (`Alt + 9`).  
2️⃣ Haz clic en `Branches`.  
3️⃣ Selecciona `ejercicio1-rama2` y elige `Merge into Current`.

📌 **Comando equivalente en la terminal de IntelliJ:**
```bash
git merge ejercicio1-rama2
```

💥 **Git mostrará un conflicto en `Calculator.java`.**

---

### ✅ **Paso 4: Resolver el Conflicto en IntelliJ IDEA**

📌 **En IntelliJ IDEA:**  
1️⃣ Se abrirá automáticamente la vista de resolución de conflictos.  
2️⃣ Verás las versiones en conflicto:
- **LEFT (HEAD - tu versión actual)**
- **RIGHT (rama fusionada - cambios que intentas agregar)**  
  3️⃣ **Usa los botones `Accept Left`, `Accept Right` o `Merge Manually`** para decidir qué cambios mantener.  
  4️⃣ **Si es necesario, edita manualmente el código** para combinar ambas versiones.  
  5️⃣ Haz clic en `Apply` para guardar los cambios.

📌 **Comando equivalente en la terminal de IntelliJ:**
```bash
git status  # Verifica los archivos en conflicto
nano src/main/java/com/eoi/java6/leccionesdegit/Calculator.java  # Editar manualmente el archivo
git add src/main/java/com/eoi/java6/leccionesdegit/Calculator.java  # Marcar como resuelto
```

✅ **El conflicto está resuelto y listo para confirmarse.**

---

### ✅ **Paso 5: Ejecutar los Tests para Validar la Solución**

📌 **En IntelliJ IDEA:**  
1️⃣ Abre la ventana de **Maven** (`View > Tool Windows > Maven`).  
2️⃣ Expande `leccionesdegit > Lifecycle`.  
3️⃣ Haz doble clic en `test`.

📌 **Comando equivalente en la terminal de IntelliJ:**
```bash
./mvnw test  # Si usas Maven Wrapper
mvn test     # Si tienes Maven instalado globalmente
```

✅ **Si todos los tests pasan, la fusión fue exitosa.**

---

### ✅ **Paso 6: Confirmar y Subir los Cambios**

📌 **En IntelliJ IDEA:**  
1️⃣ Abre la ventana de `Commit` (`Ctrl + K` en Windows/Linux, `Cmd + K` en Mac).  
2️⃣ Escribe un mensaje de commit como `Resuelto conflicto en Ejercicio 1`.  
3️⃣ Marca la casilla `Push` para subir los cambios automáticamente.  
4️⃣ Haz clic en `Commit and Push`.

📌 **Comandos equivalentes en la terminal de IntelliJ:**
```bash
git add .
git commit -m "Resuelto conflicto en Ejercicio 1"
git push origin ejercicio1-rama1
```

✅ **Ahora los cambios están subidos a GitHub y puedes pasar al siguiente ejercicio.**

---
Sí, **lo correcto en el flujo del taller es fusionar cada ejercicio en `main`**, ya que los cambios resueltos en cada ejercicio afectan los siguientes.

---

### 🎯 **Resumen del Flujo de Trabajo en IntelliJ**

🔹 **1️⃣ Verificar las ramas disponibles (`Fetch`)**  
📌 `Git > Fetch` o `git fetch --all`

🔹 **2️⃣ Cambiar a la rama del ejercicio**  
📌 `Git > Branches > Checkout` o `git checkout ejercicioX-ramaY`

🔹 **3️⃣ Fusionar con la otra rama del ejercicio**  
📌 `Git > Merge into Current` o `git merge ejercicioX-ramaZ`  
💥 **Si hay conflictos, resolverlos en IntelliJ.**

🔹 **4️⃣ Ejecutar los tests para validar la solución**  
📌 `Maven > Lifecycle > test` o `mvn test`  
✅ **Si los tests pasan, proceder al siguiente paso.**

🔹 **5️⃣ Confirmar y subir los cambios en la rama del ejercicio**  
📌 `Commit and Push` o
```bash
git add .
git commit -m "Resuelto conflicto en Ejercicio X"
git push origin ejercicioX-ramaY
```

🔹 **6️⃣ Volver a `main` para fusionar los cambios del ejercicio**  
📌 `Git > Branches > Checkout > main` o
```bash
git checkout main
```

🔹 **7️⃣ Fusionar la rama del ejercicio en `main`**  
📌 `Git > Merge into Current` o
```bash
git merge ejercicioX-ramaY
```
💥 **Si hay conflictos, resolverlos.**

🔹 **8️⃣ Ejecutar nuevamente los tests para asegurarse de que `main` está estable**  
📌 `Maven > Lifecycle > test` o `mvn test`

🔹 **9️⃣ Confirmar y subir los cambios en `main`**  
📌 `Commit and Push` o
```bash
git add .
git commit -m "Fusionado Ejercicio X en main"
git push origin main
```

✅ **Ahora puedes continuar con el siguiente ejercicio.**



📌 **Con este flujo, cada ejercicio se resuelve en su propia rama y luego se fusiona en `main`, asegurando que el código siempre esté actualizado y listo para el siguiente ejercicio.** 🚀🔥

📌 **Al completar estos pasos en cada ejercicio, progresarás en el taller resolviendo conflictos de Git de manera efectiva.** 🚀🔥

---


## 🎯 **Conclusión**
Al finalizar el taller, habrás adquirido experiencia práctica en **resolución de conflictos en Git**, manejo de ramas y fusión de cambios en un proyecto real.

Si tienes dudas, consulta la documentación oficial de Git o pregunta a tus compañeros e instructores.

📌 **¡Buena suerte y que comience el taller! 🚀🔥**

