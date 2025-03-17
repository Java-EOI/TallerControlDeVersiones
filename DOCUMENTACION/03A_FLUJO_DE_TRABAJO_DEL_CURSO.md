# 📄 FLUJO DE TRABAJO DEL CURSO
## 🚀 **Flujo de Trabajo en Git para el Curso**

Durante el curso, utilizaremos un **flujo de trabajo híbrido**, inspirado en los modelos de **Git Flow** y **GitHub Flow**, pero adaptado a la dinámica del curso.

Este flujo permitirá a los alumnos:  
✅ **Desarrollar nuevas funcionalidades de manera independiente.**  
✅ **Integrar y estabilizar su código en un entorno de desarrollo compartido.**  
✅ **Recibir revisiones y mejoras durante las tutorías.**  
✅ **Publicar versiones finales en un entorno de "producción" donde el desarrollo será evaluado.**

---

## 📌 **Estructura del Flujo de Trabajo en el Curso**

El flujo de trabajo se organizará en **tres niveles de estabilidad**:

```
📂 main         → Entorno de Producción (Versión Final Evaluada)
│
├── develop     → Entorno de Desarrollo Compartido (Integración y Estabilización)
│
├── feature/*   → Ramas donde cada alumno desarrolla sus funcionalidades.
│
└── release/*   → Versiones listas para revisión antes de pasar a producción.
```

---

## 🔄 **Cómo Trabajar con el Flujo del Curso**

### ✅ **1. Desarrollar una Nueva Funcionalidad (Feature Branch)**

Cada alumno trabajará en **su propia rama de feature** para evitar interferencias con otros desarrolladores.

📌 **Ejemplo: Crear una nueva funcionalidad llamada `login-system`**
```bash
git checkout develop
git checkout -b feature/login-system
```

A partir de aquí, el alumno podrá trabajar en su código, realizar commits y probar su funcionalidad.

📌 **Subir los cambios a GitHub:**
```bash
git add .
git commit -m "Implementado sistema de login"
git push origin feature/login-system
```

---

### ✅ **2. Fusionar la Funcionalidad en el Entorno de Desarrollo (Develop)**

Una vez que la funcionalidad está lista, el alumno deberá fusionarla en `develop`, que actúa como un entorno de pruebas e integración.

📌 **Fusionar la rama de feature en `develop` y eliminar la rama local:**
```bash
git checkout develop
git merge feature/login-system
git branch -d feature/login-system
git push origin develop
```

**En este punto:**  
🔹 `develop` tendrá la nueva funcionalidad, pero **aún no está en producción**.  
🔹 En las **tutorías**, los alumnos y el instructor podrán revisar los cambios, hacer ajustes y corregir errores si es necesario.

---

### ✅ **3. Crear una Versión Estable (`release`) para su Evaluación**

Cuando el desarrollo en `develop` está estable y aprobado en tutorías, se creará una rama de `release` antes de fusionarla en `main`.

📌 **Ejemplo: Crear la versión `v1.0` en una rama de release:**
```bash
git checkout develop
git checkout -b release/v1.0
```

Los alumnos podrán hacer ajustes finales en esta rama, como mejorar documentación, corregir detalles y hacer pruebas finales.

📌 **Una vez lista, la versión se fusiona en `main`:**
```bash
git checkout main
git merge release/v1.0
git tag -a v1.0 -m "Versión 1.0 lista para evaluación"
git push origin main --tags
```

---

### ✅ **4. Corrección de Errores Urgentes en Producción (Hotfix)**

Si se detecta un error grave en `main`, se debe crear una rama de **hotfix** y corregirlo sin afectar `develop`.

📌 **Ejemplo: Arreglo de un error crítico en `main`**
```bash
git checkout main
git checkout -b hotfix/arreglo-login
```

Tras hacer los cambios y confirmar el fix:
```bash
git commit -m "Corregido error en sistema de login"
git checkout main
git merge hotfix/arreglo-login
git push origin main
```

---

## 🏗 **Resumen del Flujo de Trabajo**

| 📌 Paso | Acción |
|---------|--------|
| **1. Crear una Feature** | Se trabaja en una rama `feature/*` hasta completar la funcionalidad. |
| **2. Fusionar en Develop** | Se integra la funcionalidad en `develop`, donde se prueba y revisa. |
| **3. Crear una Release** | Se genera una versión estable en `release/*` antes de pasar a `main`. |
| **4. Fusionar en Producción** | Se sube la release a `main`, donde quedará lista para evaluación. |
| **5. Corrección de Errores** | Si hay fallos en `main`, se hacen hotfixes sin afectar `develop`. |

✅ **Este flujo permite que los alumnos trabajen en paralelo, integren sus cambios y los revisen en tutorías antes de publicar una versión final.**

---

## 🚀 **Comparación con Otros Flujos de Trabajo**

| Flujo de Trabajo | Nuestro Flujo |
|------------------|--------------|
| **Git Flow** | ✅ Similar, pero más ágil y enfocado en revisiones constantes. |
| **GitHub Flow** | ✅ Adoptamos la idea de Pull Requests y revisiones en `develop`. |
| **Trunk-Based Development** | 🚫 No trabajamos directo en `main`, sino en ramas separadas. |

💡 **Este flujo combina lo mejor de Git Flow y GitHub Flow, adaptándose al proceso de aprendizaje del curso.**

---

## 🔗 **Enlaces Relacionados**

📖 [Explicación de Git Flow](https://nvie.com/posts/a-successful-git-branching-model/)  
📖 [Guía de GitHub Flow](https://docs.github.com/en/get-started/quickstart/github-flow)  
📖 [¿Qué es Trunk-Based Development?](https://trunkbaseddevelopment.com/)

---

⬅️ **Anterior: [Flujos de Trabajo en Git](03_FLUJOS_DE_TRABAJO_EN_GIT.md)**  
📌 **Siguiente: [Resolución de Conflictos en Git](04_RESOLUCION_DE_CONFLICTOS.md) →**

