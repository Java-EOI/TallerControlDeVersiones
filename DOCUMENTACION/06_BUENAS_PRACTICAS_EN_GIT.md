# 📄 BUENAS PRACTICAS EN GIT
## ✅ **Buenas Prácticas en Git**

Trabajar con Git de manera efectiva no solo implica conocer sus comandos, sino también **seguir buenas prácticas** que faciliten la colaboración, reduzcan conflictos y mantengan un historial limpio y útil.

En este documento, exploraremos estrategias clave para mejorar el uso de Git en proyectos reales.

---

## 📌 **1️⃣ Organización del Repositorio**

✅ **Estructura clara de ramas:**
- **`main`** → Versión estable y lista para producción.
- **`develop`** → Integración de cambios antes de fusionarlos en `main`.
- **`feature/*`** → Desarrollo de nuevas funcionalidades.
- **`hotfix/*`** → Correcciones urgentes en producción.
- **`release/*`** → Preparación de versiones antes de su despliegue.

💡 **Ejemplo de flujo de trabajo con ramas:**
```bash
git checkout develop
git checkout -b feature/nueva-funcionalidad
# Desarrollo de la funcionalidad
git add .
git commit -m "Añadida nueva funcionalidad"
git push origin feature/nueva-funcionalidad
```

---

## 📌 **2️⃣ Buenas Prácticas al Hacer Commits**

🔹 **Escribe mensajes de commit claros y descriptivos.**  
🔹 **Evita hacer commits gigantescos** (usa commits pequeños y frecuentes).  
🔹 **Usa el formato estándar en los mensajes de commit.**

💡 **Ejemplo de buenos mensajes de commit:**
```bash
git commit -m "feat: Agregada validación de formulario"
git commit -m "fix: Corregido error en la autenticación de usuario"
git commit -m "docs: Actualizada documentación de la API"
```
📌 **Usa prefijos en los commits para organizarlos mejor:**
- `feat:` → Nueva funcionalidad.
- `fix:` → Corrección de bug.
- `docs:` → Cambios en documentación.
- `style:` → Cambios de formato (espacios, indentación, sin afectar código).
- `refactor:` → Reestructuración sin cambiar funcionalidad.

---

## 📌 **3️⃣ Uso Correcto de `git pull`, `git fetch` y `git rebase`**

🔹 **Evita `git pull` directamente, ya que puede generar conflictos innecesarios.**  
🔹 **Usa `git fetch` para traer cambios sin aplicarlos automáticamente:**
```bash
git fetch origin
git status
```
🔹 **Si necesitas actualizar tu rama sin crear un commit de merge, usa `git rebase`:**
```bash
git checkout feature/nueva-funcionalidad
git rebase origin/main
```
⚠️ **Recuerda:** Solo usa `rebase` en ramas locales que no hayas compartido aún.

---

## 📌 **4️⃣ Evitar Conflictos en Git**

🔹 **Haz `pull` antes de empezar a trabajar:**
```bash
git checkout develop
git pull origin develop
```
🔹 **Usa ramas separadas para cada funcionalidad.**  
🔹 **Antes de hacer `merge`, revisa los cambios con `git diff`.**  
🔹 **Si hay conflictos, resuélvelos en IntelliJ o con `git mergetool`.**

---

## 📌 **5️⃣ Cómo Deshacer Errores en Git**

🔹 **Si agregaste un archivo por error, quítalo del staging antes del commit:**
```bash
git reset HEAD archivo.txt
```
🔹 **Si cometiste un error en el último commit pero aún no hiciste `push`:**
```bash
git commit --amend -m "Nuevo mensaje corregido"
```
🔹 **Si ya hiciste `push` y necesitas revertirlo:**
```bash
git revert HEAD
git push origin main
```
🔹 **Si necesitas volver a un commit anterior sin borrar historial:**
```bash
git checkout <ID_DEL_COMMIT>
```

---

## 📌 **6️⃣ Manejo de Archivos Sensibles y `.gitignore`**

🔹 **No subas archivos con información sensible (contraseñas, claves de API).**  
🔹 **Configura un `.gitignore` para evitar subir archivos innecesarios.**

💡 **Ejemplo de `.gitignore` para proyectos Java:**
```
# Archivos de compilación
*.class
*.jar
*.war

# Configuración de IDEs
.idea/
.vscode/

# Dependencias de Maven y Gradle
target/
build/
```
🔹 **Si accidentalmente agregaste un archivo sensible, usa:**
```bash
git rm --cached archivo-secreto.txt
git commit -m "Eliminado archivo sensible del repositorio"
git push origin main
```

---

## 📌 **7️⃣ Uso de Pull Requests y Code Reviews**

🔹 **Usa Pull Requests (PRs) para revisar código antes de fusionarlo en `main`.**  
🔹 **Comenta en los PRs para mejorar el código en equipo.**  
🔹 **No fusiones PRs sin revisión de otro desarrollador.**  
🔹 **Usa herramientas como GitHub Actions o SonarQube para verificar la calidad del código.**

💡 **Ejemplo de flujo con PRs:**  
1️⃣ Crear una nueva rama de funcionalidad:
```bash
git checkout -b feature/nueva-funcionalidad
```
2️⃣ Hacer commits y subir la rama:
```bash
git add .
git commit -m "feat: Implementado nuevo login"
git push origin feature/nueva-funcionalidad
```
3️⃣ Abrir un Pull Request en GitHub y solicitar revisión.  
4️⃣ Revisar comentarios y hacer cambios antes de fusionar con `develop` o `main`.

---

## 📌 **8️⃣ Control de Versiones y Releases con Tags**

🔹 **Usa `git tag` para marcar versiones importantes.**  
🔹 **Crea etiquetas semánticas (`v1.0.0`, `v1.1.0`, etc.).**

💡 **Ejemplo:**
```bash
git tag -a v1.0.0 -m "Versión 1.0.0 estable"
git push origin v1.0.0
```
🔹 **Si necesitas volver a una versión anterior:**
```bash
git checkout v1.0.0
```

---

## 📜 **Resumen de Buenas Prácticas en Git**

| ✅ Acción | 🔧 Cómo Hacerlo |
|----------|---------------|
| **Estructura de ramas clara** | Usa `main`, `develop`, `feature/*`, `hotfix/*`, `release/*` |
| **Commits bien escritos** | Usa `feat:`, `fix:`, `docs:`, `refactor:`, etc. |
| **Actualizar código antes de trabajar** | `git fetch origin && git pull origin develop` |
| **Rebase en vez de merge (cuando sea seguro)** | `git rebase origin/main` en ramas locales |
| **Evitar archivos innecesarios** | Usa `.gitignore` |
| **Deshacer errores sin destruir historial** | `git revert HEAD` |
| **Usar Pull Requests para revisión de código** | No fusiones cambios sin revisión |
| **Marcar versiones con `git tag`** | `git tag -a v1.0.0 -m "Versión estable"` |

---

## 🔗 **Enlaces Relacionados**

📖 [Guía Oficial de Git](https://git-scm.com/doc)  
📖 [Flujos de Trabajo en GitHub](https://guides.github.com/introduction/flow/)  
📖 [Cómo Escribir Buenos Commits](https://chris.beams.io/posts/git-commit/)

---

⬅️ **Anterior: [Rebase y sus Riesgos](05_REBASE_Y_SUS_RIESGOS.md)**  
📌 **Siguiente: [Estrategias de Despliegue con Git](07_ESTRATEGIAS_DE_DESPLIEGUE.md) →**

---

✅ **Este documento ya está listo para `documentacion/06_BUENAS_PRACTICAS_EN_GIT.md`** 🚀  
💡 **¿Quieres hacer algún ajuste antes de continuar con el siguiente?** 😃

