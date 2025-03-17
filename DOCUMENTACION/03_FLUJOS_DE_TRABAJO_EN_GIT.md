
## 📄 FLUJOS DE TRABAJO EN GIT
### 🚀 **Flujos de Trabajo en Git: ¿Cómo Organizar el Desarrollo?**

Cuando varios desarrolladores trabajan en un mismo proyecto, es fundamental seguir un **flujo de trabajo (workflow) organizado** para evitar conflictos, mantener un historial de cambios limpio y garantizar la estabilidad del código.

Existen varios flujos de trabajo en Git que se adaptan a diferentes necesidades y estilos de desarrollo. En este documento exploraremos los más utilizados, sus ventajas y en qué contextos se recomienda cada uno.

---

## 📌 **¿Por qué es Importante un Buen Flujo de Trabajo?**

Un flujo de trabajo en Git define **cómo se crean, gestionan y fusionan las ramas**, estableciendo reglas para que el equipo colabore de manera eficiente.

🔹 **Beneficios de un buen workflow:**  
✅ Evita sobrescribir cambios accidentalmente.  
✅ Reduce conflictos en la fusión de código.  
✅ Facilita la colaboración entre múltiples desarrolladores.  
✅ Permite revisar código antes de que llegue a la rama principal.  
✅ Mejora la trazabilidad y claridad del historial de cambios.

---

## 🔄 **1. Git Flow (Flujo Clásico de Git)**

Este es uno de los workflows más populares y se basa en **ramas bien definidas** para diferentes propósitos. Fue propuesto por **Vincent Driessen** en 2010 y es ideal para proyectos grandes con ciclos de desarrollo estructurados.

### 📌 **Estructura de Ramas en Git Flow**

```
📂 main         → Contiene solo código estable y listo para producción.
│
├── develop     → Rama donde se integran nuevas funcionalidades antes de llegar a main.
│
├── feature/*   → Ramas para desarrollar nuevas funcionalidades.
│
├── release/*   → Ramas temporales para preparar una nueva versión estable.
│
└── hotfix/*    → Ramas para corregir errores urgentes en producción.
```

### 🚀 **Cómo Trabajar con Git Flow**

📌 **1️⃣ Crear una nueva funcionalidad (`feature` branch)**
```bash
git checkout -b feature/nueva-funcionalidad develop
```

📌 **2️⃣ Una vez terminada, fusionarla con `develop`**
```bash
git checkout develop
git merge feature/nueva-funcionalidad
git branch -d feature/nueva-funcionalidad  # Eliminar la rama localmente
```

📌 **3️⃣ Cuando `develop` está listo, crear una rama de `release`**
```bash
git checkout -b release/v1.0 develop
```

📌 **4️⃣ Fusionar `release` en `main` y crear un tag**
```bash
git checkout main
git merge release/v1.0
git tag -a v1.0 -m "Lanzamiento versión 1.0"
git push origin main --tags
```

📌 **5️⃣ Corregir errores urgentes con un `hotfix`**
```bash
git checkout -b hotfix/arreglo-crítico main
# Hacer cambios y confirmar
git checkout main
git merge hotfix/arreglo-crítico
git push origin main
```

✅ **Ventajas de Git Flow:**  
✔️ Ideal para equipos grandes con lanzamientos planificados.  
✔️ Permite múltiples desarrolladores trabajando en paralelo.  
✔️ Mantiene el código en `main` siempre estable.

❌ **Desventajas:**  
⛔ Puede ser excesivamente complejo para proyectos pequeños.  
⛔ Requiere disciplina para mantener la estructura de ramas.

---

## 🚀 **2. GitHub Flow (Desarrollo Continuo en Main)**

Este flujo es más **ligero y ágil** que Git Flow, y se usa comúnmente en **GitHub** para proyectos que necesitan una entrega continua de código.

### 📌 **Estructura de Ramas en GitHub Flow**
```
📂 main        → Siempre contiene el código estable.
│
└── feature/*  → Se crean ramas para cada cambio, se revisan con Pull Requests y se fusionan en `main`.
```

### 🚀 **Cómo Trabajar con GitHub Flow**

📌 **1️⃣ Crear una rama para una nueva funcionalidad**
```bash
git checkout -b feature/nueva-funcionalidad
```

📌 **2️⃣ Subir la rama al repositorio y abrir un Pull Request**
```bash
git push origin feature/nueva-funcionalidad
```
📌 En GitHub, se abre un **Pull Request (PR)** para que otros revisen los cambios antes de fusionarlos en `main`.

📌 **3️⃣ Una vez aprobado, fusionar los cambios en `main`**
```bash
git checkout main
git merge feature/nueva-funcionalidad
git push origin main
```

📌 **4️⃣ Eliminar la rama después de la fusión**
```bash
git branch -d feature/nueva-funcionalidad
```

✅ **Ventajas de GitHub Flow:**  
✔️ Flujo simple y fácil de implementar.  
✔️ Ideal para proyectos con integración y despliegue continuo (CI/CD).  
✔️ Se revisan los cambios antes de fusionarlos a `main`.

❌ **Desventajas:**  
⛔ No es ideal para proyectos con múltiples versiones en paralelo.  
⛔ No gestiona versiones de manera estructurada como Git Flow.

---

## 🔁 **3. Trunk-Based Development (Desarrollo en una Única Rama)**

En este enfoque, **todos los desarrolladores trabajan directamente en `main`**, usando **feature flags** para ocultar funcionalidades hasta que estén listas.

### 📌 **Flujo de Trabajo en Trunk-Based Development**
1️⃣ Se trabaja directamente en `main`.  
2️⃣ Se hacen commits frecuentes con cambios pequeños.  
3️⃣ Se usan **feature flags** para habilitar o deshabilitar código en producción.

📌 **Ejemplo de commit en main con feature flag:**
```java
if (FeatureFlags.nuevaFuncion) {
    ejecutarNuevaFuncion();
}
```

📌 **Ventajas:**  
✔️ Ideal para desarrollo ágil y entregas continuas.  
✔️ Menos complejidad en la gestión de ramas.

❌ **Desventajas:**  
⛔ Puede generar inestabilidad en `main` si no hay control de calidad.  
⛔ Requiere **feature flags** para evitar lanzar código incompleto.

---

## 🏆 **¿Cuál Workflow Deberías Usar?**

| Flujo de Trabajo    | Mejor para... |
|---------------------|--------------|
| **Git Flow**        | Equipos grandes con lanzamientos planificados. |
| **GitHub Flow**     | Proyectos pequeños o medianos con entrega continua. |
| **Trunk-Based**     | Equipos ágiles con CI/CD y releases rápidos. |

Cada equipo debe elegir el workflow que mejor se adapte a sus necesidades.

---

## 🔗 **Enlaces Relacionados**

📖 [Guía Oficial de Git Flow](https://nvie.com/posts/a-successful-git-branching-model/)  
📖 [Documentación de GitHub Flow](https://docs.github.com/en/get-started/quickstart/github-flow)  
📖 [Explicación de Trunk-Based Development](https://trunkbaseddevelopment.com/)

---

⬅️ **Anterior: [Cómo Funciona Git](02_COMO_FUNCIONA_GIT.md)**  
📌 **Siguiente: [Resolución de Conflictos en Git](04_RESOLUCION_DE_CONFLICTOS.md) →**


