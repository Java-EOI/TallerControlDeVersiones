# 📄 RESOLUCIÓN DE CONFLICTOS.md
## 🚀 **Resolución de Conflictos en Git**

Los conflictos en Git ocurren cuando dos o más desarrolladores modifican las mismas líneas de un archivo en diferentes ramas y luego intentan fusionarlas. Git no puede decidir automáticamente qué cambios conservar, por lo que es necesario resolver el conflicto manualmente.

Este documento explica **cómo surgen los conflictos, cómo resolverlos y las mejores prácticas para evitarlos**.

---

## 🔥 **¿Por qué Ocurren los Conflictos en Git?**

Un conflicto en Git ocurre cuando:  
🔹 Dos ramas modifican **las mismas líneas de un archivo** de manera diferente.  
🔹 Un archivo se **elimina en una rama pero se modifica en otra**.  
🔹 Se mueve o renombra un archivo en una rama, pero se edita en otra.

---

## 🛠 **Cómo Identificar un Conflicto en Git**

Cuando intentas hacer un `merge` y hay un conflicto, Git te mostrará un mensaje como este:

```bash
Auto-merging archivo.java
CONFLICT (content): Merge conflict in archivo.java
Automatic merge failed; fix conflicts and then commit the result.
```

✅ **Para ver qué archivos están en conflicto:**
```bash
git status
```

Salida esperada:
```bash
On branch main
You have unmerged paths.
  (fix conflicts and run "git commit")
Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   src/main/java/com/eoi/Calculator.java
```

---

## 🏗 **Cómo Resolver un Conflicto en Git**

### 🚀 **Método 1: Resolución Manual en IntelliJ IDEA**

1️⃣ **Abrir IntelliJ y revisar el conflicto:**
- Ve a `View > Tool Windows > Git` (`Alt + 9`).
- IntelliJ mostrará los archivos en conflicto.
- Haz clic en `Merge Conflicts`.

2️⃣ **Seleccionar qué cambios conservar:**
- `Accept Left` → Mantener los cambios de tu rama.
- `Accept Right` → Mantener los cambios de la rama fusionada.
- `Merge Manually` → Editar el código para combinar ambos cambios.

3️⃣ **Confirmar la resolución del conflicto:**
- Haz clic en `Apply` para guardar los cambios.
- Luego, **añade el archivo al commit:**
  ```bash
  git add archivo.java
  git commit -m "Resuelto conflicto en archivo.java"
  ```

4️⃣ **Subir los cambios:**
   ```bash
   git push origin main
   ```

---

### 🚀 **Método 2: Resolución Manual en la Terminal**

Si prefieres resolver el conflicto sin IntelliJ, abre el archivo en un editor y verás algo como esto:

```java
<<<<<<< HEAD
System.out.println("Hola desde la versión A");
=======
System.out.println("Hola desde la versión B");
>>>>>>> feature-nueva
```

✏️ **Debes editar el código manualmente y eliminar los marcadores `<<<<<<<`, `=======` y `>>>>>>>`.**

✅ **Ejemplo de solución final:**
```java
System.out.println("Hola desde la versión A y B combinadas");
```

Luego, confirma los cambios con:
```bash
git add archivo.java
git commit -m "Conflicto resuelto en archivo.java"
git push origin main
```

---

## 📌 **Cómo Evitar Conflictos en Git**

Los conflictos pueden ser molestos, pero hay varias estrategias para **minimizarlos**:

✅ **Hacer `pull` antes de empezar a trabajar:**
   ```bash
   git pull origin main
   ```  
Así obtienes la versión más reciente antes de hacer cambios.

✅ **Dividir el código en archivos más pequeños y modulares:**
- Si todos los desarrolladores trabajan en un solo archivo, los conflictos son más frecuentes.
- Una buena arquitectura reduce los conflictos.
- La modularidad y el principio de responsabilidad única, por tanto, son muy importantes
 

✅ **Comunicación en equipo:**
- Coordina con tu equipo qué partes del código está modificando cada uno.
- Usa herramientas como **Jira** para discutir los cambios.

✅ **Hacer commits pequeños y frecuentes:**
   ```bash
   git add .
   git commit -m "Cambio incremental"
   git push origin feature-nueva
   ```  
Cuanto más pequeños sean los cambios en cada commit, **más fácil será resolver los conflictos**.

✅ **Revisar los cambios antes de hacer un merge:**
   ```bash
   git diff main feature-nueva
   ```  
Esto te ayuda a **detectar posibles conflictos antes de fusionar ramas**.

✅ **Usar `rebase` en lugar de `merge` en algunos casos:**
   ```bash
   git checkout feature-nueva
   git rebase main
   ```  
`rebase` mueve los commits de tu rama sobre `main`, reduciendo la posibilidad de conflictos al fusionar.

---

## 📌 **Ejemplo Práctico: Resolviendo un Conflicto Paso a Paso**

### 📌 **1. Crear dos ramas y hacer cambios en el mismo archivo**
```bash
git checkout -b rama1
echo 'System.out.println("Versión en rama1");' >> src/main/java/App.java
git add .
git commit -m "Cambio en rama1"

git checkout main
git checkout -b rama2
echo 'System.out.println("Versión en rama2");' >> src/main/java/App.java
git add .
git commit -m "Cambio en rama2"
```

### 📌 **2. Intentar fusionar las ramas en `main`**
```bash
git checkout main
git merge rama1
git merge rama2
```

💥 **Aparecerá un conflicto en `App.java`**.

### 📌 **3. Resolver el conflicto en IntelliJ o manualmente**

Edición manual del archivo `App.java`:
```java
System.out.println("Versión combinada de rama1 y rama2");
```

### 📌 **4. Confirmar la resolución y subir los cambios**
```bash
git add App.java
git commit -m "Resuelto conflicto en App.java"
git push origin main
```

✅ **¡Conflicto resuelto con éxito!**

---

## 📜 **Resumen: Resolución de Conflictos en Git**

| 💡 Situación | 🔧 Solución |
|-------------|------------|
| **Conflicto al fusionar ramas** | Editar manualmente el archivo, elegir qué cambios conservar. |
| **No sé qué archivos tienen conflictos** | `git status` mostrará los archivos en conflicto. |
| **Quiero descartar los cambios en conflicto** | `git checkout -- <archivo>` restaurará la última versión. |
| **Quiero ver qué cambios se han hecho** | `git diff` muestra las diferencias entre ramas. |
| **Quiero evitar conflictos en el futuro** | Hacer `pull` antes de trabajar y commits pequeños. |

---

## 🔗 **Enlaces Relacionados**

📖 [Documentación Oficial de Git](https://git-scm.com/doc)  
📖 [Guía de GitHub sobre Conflictos](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/about-merge-conflicts)

---

⬅️ **Anterior: [Flujos de Trabajo en Git](03_FLUJOS_DE_TRABAJO_EN_GIT.md)**  
📌 **Siguiente: [Git en Equipos Colaborativos](05_GIT_EN_EQUIPOS_COLABORATIVOS.md) →**



