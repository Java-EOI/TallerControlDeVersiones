## 📄 05 GIT EN EQUIPOS COLABORATIVOS

### 👥 **Git en Equipos Colaborativos: Buenas Prácticas**

Cuando trabajamos en equipo, el uso correcto de Git es clave para evitar conflictos, mejorar la colaboración y asegurar que el código sea estable.

### 📌 **¿Qué Veremos en Esta Sección?**
✅ Cómo organizar el trabajo con ramas colaborativas.  
✅ Cómo evitar conflictos en proyectos con múltiples desarrolladores.  
✅ Introducción a herramientas avanzadas (`rebase`, `cherry-picking`, `reset`).

---

## 📌 **1️⃣ Ramas y Colaboración en Git**

En equipos, se recomienda seguir un flujo de trabajo estructurado para evitar problemas. En este curso seguimos un modelo híbrido basado en **Git Flow** y **GitHub Flow**, donde cada funcionalidad se desarrolla en una **feature branch** antes de fusionarse en `develop` o `main`.

**Ejemplo de ciclo de trabajo en equipo:**
```bash
git checkout develop
git checkout -b feature/nueva-funcionalidad
# Desarrollo y commits
git push origin feature/nueva-funcionalidad
# Pull Request y revisión en equipo
git checkout develop
git merge feature/nueva-funcionalidad
git push origin develop
```

🔹 **Está prohido hacer cambios directamente en `main` o `develop`**, siempre se debe trabajar con ramas separadas y fusionarlas  
🔹 **Usar Pull Requests para revisión de código antes de fusionar cambios.**

---

## 📌 **2️⃣ Merge vs. Rebase en Equipos**

Cuando trabajamos con varias ramas, es importante entender muy bien cuándo usar `merge` y cuándo usar `rebase`.

| Comando | ¿Qué Hace? | Cuándo Usarlo en Equipos |
|---------|-----------|--------------------------|
| `git merge` | Fusiona dos ramas y conserva la historia de commits original. | Cuando varios desarrolladores trabajan en la misma rama. |
| `git rebase` | Reorganiza los commits de una rama sobre otra, reescribiendo el historial. | **Solo en ramas privadas**, nunca en ramas compartidas. |

⚠️⚠️⚠️⚠️ **MUY IMPORTANTE:** ⚠️⚠️⚠️⚠️
**No uses `rebase` en ramas compartidas, puede causar problemas al cambiar la historia de Git.**

📌 **Para aprender más sobre `rebase`, revisa [01_REBASE_Y_SUS_RIESGOS.md](avanzado/01_REBASE_Y_SUS_RIESGOS.md)**.

---

## 📌 **3️⃣ Pull Requests y Code Reviews**

🔹 **¿Qué es un Pull Request?**  
Un Pull Request (PR) permite que otros desarrolladores revisen tu código antes de fusionarlo en la rama principal. Se usa en plataformas como **GitHub, GitLab o Bitbucket**.

🔹 **Proceso Típico de un PR en GitHub:**  
1️⃣ **Subir la rama al repositorio remoto:**
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
2️⃣ **Abrir un Pull Request en GitHub.**  
3️⃣ **El equipo revisa el código y sugiere cambios.**  
4️⃣ **Si todo está bien, se aprueba y se fusiona en `develop` o `main`.**  
5️⃣ **Eliminar la rama una vez fusionada:**
   ```bash
   git branch -d feature/nueva-funcionalidad
   git push origin --delete feature/nueva-funcionalidad
   ```

📌 **Más información sobre Pull Requests en la [Guía Oficial de GitHub](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests).**

---

## 📌 **4️⃣ Introducción a Herramientas Avanzadas**

🔹 **`git cherry-pick`** → Aplicar un commit específico de otra rama.  
🔹 **`git reset` vs. `git revert`** → Cómo deshacer cambios de manera segura.  
🔹 **`git squash`** → Combinar múltiples commits en uno solo.  
🔹 **`git bisect`** → Depuración para encontrar commits que introducen errores.

📌 **Para profundizar en estas herramientas, revisa la documentación en `documentacion/avanzado/`.**

---

## 📜 **Resumen de Git en Equipos**

| 💡 Situación | 🔧 Solución |
|-------------|------------|
| **Evitar conflictos al fusionar cambios** | Usar Pull Requests y revisión de código antes de hacer `merge`. |
| **¿Merge o Rebase?** | Usar `merge` en equipos, `rebase` solo en ramas privadas. |
| **Revertir un commit erróneo** | Usar `git revert` en lugar de `reset` para evitar cambios destructivos. |
| **Encontrar errores en el historial** | Usar `git bisect` para identificar el commit problemático. |

📌 **Siguientes pasos: Aprende herramientas avanzadas en [`documentacion/avanzado/`](avanzado/).**

---

## 🔗 **Enlaces Relacionados**

📖 [Guía de GitHub sobre Pull Requests](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests)  
📖 [Cómo gestionar ramas en equipos](https://www.atlassian.com/git/tutorials/using-branches)

---

⬅️ **Anterior: [Resolución de Conflictos en Git](04_RESOLUCION_DE_CONFLICTOS.md)**  
📌 **Siguiente: [Rebase y sus Riesgos](avanzado/01_REBASE_Y_SUS_RIESGOS.md) →**

---

✅ **Este documento ya está listo para `documentacion/05_GIT_EN_EQUIPOS_COLABORATIVOS.md`** 🚀  
💡 **¿Quieres que pase ahora a los archivos dentro de `avanzado/` empezando con `01_REBASE_Y_SUS_RIESGOS.md`?** 😃