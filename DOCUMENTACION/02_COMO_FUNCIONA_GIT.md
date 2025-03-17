
## 📄 CÓMO FUNCIONA GIT

### 🏗 **Cómo Funciona Git: Conceptos Fundamentales**

Git es un **sistema de control de versiones distribuido**, lo que significa que cada desarrollador tiene una copia completa del repositorio en su máquina. A diferencia de los sistemas centralizados como **Subversion (SVN)**, en Git se pueden hacer commits, ramas y comparaciones de código sin necesidad de estar conectado a un servidor remoto.

En este documento, exploraremos cómo funciona Git desde la base y sus conceptos fundamentales.

---

## 🏛 **Estructura de Git: ¿Cómo está organizado un repositorio?**

Cuando trabajamos con Git, nuestro código se organiza en un **repositorio** que sigue esta estructura básica:

```
📂 MiProyecto
 ├── 📂 .git/               (Carpeta oculta con toda la información del repositorio)
 ├── 📂 src/                (Código fuente del proyecto)
 ├── 📄 README.md           (Descripción del proyecto)
 ├── 📄 .gitignore          (Archivos que Git debe ignorar)
 ├── 📄 config.yml          (Archivos de configuración)
 ├── 📂 docs/               (Documentación del proyecto)
 ├── 📂 tests/              (Pruebas unitarias)
```

🔹 **`.git/`** → Esta carpeta es el corazón del repositorio. Contiene todo el historial de cambios, commits, ramas y referencias del proyecto.  
🔹 **`src/`** → Carpeta con el código fuente del proyecto.  
🔹 **`.gitignore`** → Lista de archivos y carpetas que no deben ser rastreados por Git (por ejemplo, dependencias o archivos temporales).

✅ **Cuando clonas un repositorio, descargas toda esta estructura en tu computadora.**

---

## 🔗 **Conceptos Clave de Git**

### 🟢 **1. Repositorio (Repository)**
Un repositorio es un **directorio que Git gestiona**, permitiendo rastrear cambios en los archivos. Puede estar en tu computadora (**local**) o en una plataforma como GitHub o GitLab (**remoto**).

### 🔵 **2. Commit**
Un **commit** es un "punto de guardado" del código. Cada commit almacena un **estado exacto del proyecto** y un mensaje descriptivo sobre qué cambios se realizaron.

📌 **Ejemplo de comando para hacer un commit:**
```bash
git add .
git commit -m "Agregado nuevo método de validación"
```

### 🟡 **3. Branch (Rama)**
Las ramas permiten trabajar en nuevas funcionalidades sin afectar la versión estable del código.

📌 **Ejemplo de cómo crear y cambiar a una nueva rama:**
```bash
git checkout -b nueva-funcionalidad
```

📌 **Volver a la rama principal (`main`):**
```bash
git checkout main
```

### 🔴 **4. Merge (Fusión)**
Cuando terminas de trabajar en una rama, debes **fusionarla** con otra (por lo general `main`).

📌 **Ejemplo de fusión de una rama en `main`:**
```bash
git checkout main
git merge nueva-funcionalidad
```

Si hay cambios conflictivos, Git te pedirá que los resuelvas manualmente antes de completar la fusión.

### 🟣 **5. Remoto (Remote)**
Un repositorio remoto es una versión del código almacenada en la nube, como GitHub o GitLab. Permite que varios desarrolladores trabajen en el mismo proyecto.

📌 **Comandos útiles para interactuar con el repositorio remoto:**
- **Ver qué repositorio remoto está configurado:**
  ```bash
  git remote -v
  ```
- **Obtener cambios del repositorio remoto:**
  ```bash
  git pull origin main
  ```
- **Subir cambios al repositorio remoto:**
  ```bash
  git push origin main
  ```

---

## 🏗 **Cómo Funciona Git Internamente**

Cuando hacemos cambios en un archivo y usamos Git para guardarlos, estos pasan por **tres estados principales**:

1️⃣ **Working Directory (Directorio de trabajo)** → Donde editamos archivos.  
2️⃣ **Staging Area (Área de preparación o "index")** → Donde se preparan los archivos antes de hacer commit.  
3️⃣ **Repository (Repositorio local)** → Donde se guardan los commits.

📌 **Ejemplo de flujo de trabajo en Git:**
```bash
# 1️⃣ Editas un archivo en tu directorio de trabajo
nano archivo.java  

# 2️⃣ Añades el archivo al área de preparación
git add archivo.java  

# 3️⃣ Haces un commit para guardar el cambio en el repositorio
git commit -m "Actualizado archivo.java con nueva funcionalidad"

# 4️⃣ Subes el commit al repositorio remoto (GitHub/GitLab)
git push origin main
```

✅ **Este flujo permite trabajar de manera ordenada y mantener un historial de cambios limpio.**

---

## 🔄 **Flujo de Trabajo Típico en un Proyecto con Git**

1️⃣ **Clonar el repositorio**
```bash
git clone https://github.com/usuario/repo.git
```

2️⃣ **Crear una nueva rama para trabajar en una funcionalidad**
```bash
git checkout -b nueva-funcionalidad
```

3️⃣ **Hacer cambios en los archivos y confirmarlos**
```bash
git add .
git commit -m "Implementada nueva funcionalidad"
```

4️⃣ **Fusionar la nueva funcionalidad en `main`**
```bash
git checkout main
git merge nueva-funcionalidad
```

5️⃣ **Subir los cambios al repositorio remoto**
```bash
git push origin main
```

✅ **Este proceso se repite para cada nueva funcionalidad o corrección en el proyecto.**

---

## 🔗 **Enlaces Relacionados**

📖 [Documentación Oficial de Git](https://git-scm.com/doc)  
📖 [Tutorial de Git en GitHub](https://docs.github.com/es/get-started/using-git)  
📖 [Git Cheat Sheet (Atajos y Comandos Rápidos)](https://education.github.com/git-cheat-sheet-education.pdf)

---

⬅️ **Anterior: [Pasado y Presente del Control de Versiones](01_PASADO_Y_PRESENTE.md)**  
📌 **Siguiente: [Flujos de Trabajo en Git](03_FLUJOS_DE_TRABAJO_EN_GIT.md) →**

