# 📄 RESOLUCIÓN DE CONFLICTOS EN ARCHIVOS BINARIOS

## 📌 **Introducción: ¿Por Qué Son Problemáticos los Archivos Binarios en Git?**

A diferencia de archivos de texto, que Git puede fusionar automáticamente, **los archivos binarios no pueden combinarse línea por línea**. Esto significa que, si dos personas editan el mismo archivo binario en ramas diferentes, **Git no podrá resolver el conflicto automáticamente**.

📌 **Ejemplo de archivos binarios comunes en proyectos:**
- 🎨 **Imágenes:** `.png`, `.jpg`, `.svg`
- 📄 **Documentos:** `.pdf`, `.docx`, `.xlsx`
- 🎵 **Audio/Video:** `.mp3`, `.mp4`, `.wav`
- ⚙️ **Archivos compilados:** `.jar`, `.class`, `.dll`

Cuando ocurre un conflicto en estos archivos, Git muestra un mensaje como este:
```sh
CONFLICT (binary): Merge conflict in logo.png
Automatic merge failed; fix conflicts and then commit the result.
```
📌 **En este documento aprenderás:**  
✅ **Cómo detectar y resolver conflictos en archivos binarios.**  
✅ **Estrategias para evitar problemas al versionar estos archivos.**  
✅ **Uso de Git LFS para manejar archivos binarios grandes.**

---

## 🔍 **1️⃣ Cómo Detectar Conflictos en Archivos Binarios**

📌 **Si hay un conflicto en un archivo binario, Git lo marcará en `git status`:**
```sh
git status
```
Salida de ejemplo:
```
Unmerged paths:
  (use "git add <file>..." to mark resolution)
    both modified:   assets/logo.png
```
Esto indica que **el archivo fue modificado en dos ramas diferentes y no puede fusionarse automáticamente**.

📌 **Ejemplo de conflicto en una fusión (`merge` o `rebase`):**
```sh
git merge feature/nueva-imagen
```
Si `logo.png` cambió en ambas ramas, Git no puede decidir qué versión conservar.

---

## 📌 **2️⃣ Métodos para Resolver Conflictos en Archivos Binarios**

Cuando Git no puede fusionar un archivo binario, tienes **tres opciones** para resolverlo:

### 🔹 **A) Elegir una Versión y Descatar la Otra (`--ours` o `--theirs`)**

Si quieres conservar **tu versión actual** y descartar la otra:
```sh
git checkout --ours assets/logo.png
git add assets/logo.png
git commit -m "Resuelto conflicto: Manteniendo mi versión de logo.png"
```
Si quieres conservar **la versión de la otra rama** y descartar la tuya:
```sh
git checkout --theirs assets/logo.png
git add assets/logo.png
git commit -m "Resuelto conflicto: Usando la versión de la otra rama"
```
📌 **¿Cuándo usarlo?**  
✔️ Cuando una versión es claramente mejor que la otra.

---

### 🔹 **B) Fusionar Manualmente el Archivo**

Si el archivo necesita revisarse antes de decidir qué versión mantener:  
1️⃣ Abre ambas versiones del archivo (`logo.png` de tu rama y de la otra rama).  
2️⃣ Decide cuál conservar o si puedes combinar elementos de ambas.  
3️⃣ Guarda la versión final y añádela al commit:
   ```sh
   git add assets/logo.png
   git commit -m "Resuelto conflicto en logo.png"
   ```
📌 **¿Cuándo usarlo?**  
✔️ Cuando ambas versiones tienen cambios importantes y deben combinarse.

---

### 🔹 **C) Renombrar el Archivo Antes de Fusionar**

Si esperas que un archivo binario cambie en varias ramas, **puedes evitar conflictos renombrándolo antes de fusionar**.

📌 **Ejemplo:**  
Antes de hacer un `merge`, puedes guardar una versión separada:
```sh
mv assets/logo.png assets/logo_v2.png
git add assets/logo_v2.png
git commit -m "Evitando conflicto renombrando archivo"
```
Después, puedes comparar las versiones y decidir cuál mantener.

📌 **¿Cuándo usarlo?**  
✔️ Cuando esperas múltiples versiones de un mismo archivo.

---

## 🚀 **3️⃣ Estrategias para Evitar Conflictos con Archivos Binarios**

📌 **Reglas clave para evitar problemas con archivos binarios en Git:**

✔️ **Evita realizar cambios simultáneos en archivos binarios**:
- Comunícate con tu equipo antes de editar imágenes, PDFs o archivos de diseño.  
  ✔️ **Usa nombres de archivo con versión**:
- `logo_v1.png`, `logo_v2.png` para evitar conflictos.  
  ✔️ **No hagas commits innecesarios en archivos binarios**:
- Guarda versiones locales antes de confirmar cambios.

---

## 🔄 **4️⃣ Uso de Git LFS para Archivos Binarios Grandes**

Si el proyecto maneja archivos binarios grandes (por ejemplo, imágenes de alta resolución o videos), es recomendable usar **Git LFS (Large File Storage)**.

📌 **Ventajas de Git LFS:**  
✔️ Reduce el tamaño del repositorio al almacenar archivos grandes externamente.  
✔️ Permite trabajar con archivos binarios sin afectar la velocidad de Git.

📌 **Pasos para instalar y configurar Git LFS:**

1️⃣ Instalar Git LFS (si no está instalado):
```sh
git lfs install
```
2️⃣ Añadir archivos binarios a Git LFS (por ejemplo, imágenes PNG y videos MP4):
```sh
git lfs track "*.png"
git lfs track "*.mp4"
```
Esto crea un archivo `.gitattributes` con la configuración:
```
*.png filter=lfs diff=lfs merge=lfs -text
*.mp4 filter=lfs diff=lfs merge=lfs -text
```
3️⃣ Hacer commit de la configuración:
```sh
git add .gitattributes
git commit -m "Configurado Git LFS para archivos binarios"
git push origin main
```
📌 **Después de configurar Git LFS, los archivos grandes se almacenarán de manera optimizada.**

---

## 🎯 **Conclusión: Buenas Prácticas para Gestionar Archivos Binarios en Git**

✔️ **Evita modificar archivos binarios en paralelo en diferentes ramas.**  
✔️ **Si ocurre un conflicto, decide si conservar `--ours`, `--theirs` o fusionar manualmente.**  
✔️ **Usa `git lfs` para manejar archivos binarios grandes y mejorar el rendimiento del repositorio.**  
✔️ **Cuando sea posible, evita versionar archivos binarios y almacénalos en un sistema de archivos externo (como Drive o SharePoint).**

📌 **Siguiendo estas estrategias, evitarás conflictos y optimizarás el uso de archivos binarios en Git.** 🚀

---

⬅️ **Anterior: [11 - Buenas Prácticas en Colaboración con Git](11_BUENAS_PRACTICAS_COLABORACION_GIT.md)**  
📌 **Este es el último documento del curso. ¡Felicidades por completar la documentación! 🎉**

