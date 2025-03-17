## 🚀 **Git Cheat Sheet - Comandos Útiles**

Aquí tienes algunos comandos esenciales de Git que te ayudarán durante el taller.

### 📌 **Estado y ramas del repositorio**

🔹 **Ver el estado del repositorio:** Muestra los archivos modificados, en staging y sin seguimiento.
```bash
git status
```  

🔹 **Ver las ramas disponibles en el repositorio local:**
```bash
git branch
```  

🔹 **Ver las ramas disponibles en el repositorio remoto:**
```bash
git branch -r
```  

🔹 **Crear una nueva rama y cambiar a ella:**
```bash
git checkout -b <nombre-de-la-rama>
```  
🔹 **(Alternativa moderna)** Crear y cambiar de rama con `switch`:
```bash
git switch -c <nombre-de-la-rama>
```  

🔹 **Cambiar a una rama específica:**
```bash
git checkout <nombre-de-la-rama>
```  
🔹 **(Alternativa moderna con switch)**
```bash
git switch <nombre-de-la-rama>
```  

🔹 **Borrar una rama localmente después de haberla fusionado:**
```bash
git branch -d <nombre-de-la-rama>
```  

🔹 **Borrar una rama local forzadamente (si no se ha fusionado aún):**
```bash
git branch -D <nombre-de-la-rama>
```  

🔹 **Borrar una rama remota después de haberla fusionado:**
```bash
git push origin --delete <nombre-de-la-rama>
```  

---

### 🔀 **Trabajando con cambios y commits**

🔹 **Ver qué cambios se han hecho antes de confirmar un commit:**
```bash
git diff
```  

🔹 **Agregar todos los archivos modificados al área de preparación (staging area):**
```bash
git add .
```  

🔹 **Confirmar los cambios con un mensaje:**
```bash
git commit -m "Descripción de los cambios"
```  

🔹 **Modificar el último commit sin cambiar su mensaje:**
```bash
git commit --amend --no-edit
```  

🔹 **Modificar el último commit cambiando su mensaje:**
```bash
git commit --amend -m "Nuevo mensaje"
```  

🔹 **Deshacer un commit antes de hacer push (manteniendo los cambios en staging):**
```bash
git reset --soft HEAD~1
```  

🔹 **Deshacer un commit y eliminar los cambios:**
```bash
git reset --hard HEAD~1
```  

---

### 🔄 **Sincronización con repositorios remotos**

🔹 **Ver los remotos configurados en el repositorio:**
```bash
git remote -v
```  

🔹 **Agregar un nuevo remoto:**
```bash
git remote add <nombre-remoto> <URL-del-repositorio>
```  

🔹 **Actualizar tu fork con los cambios del repositorio original:**
```bash
git remote add upstream https://github.com/ateixeiramunoz/leccionesdegit.git
git fetch upstream
git merge upstream/main
git push origin main
```  

🔹 **Obtener los últimos cambios del repositorio remoto sin fusionarlos aún:**
```bash
git fetch origin
```  

🔹 **Obtener y fusionar los cambios del remoto en la rama actual:**
```bash
git pull origin main
```  

🔹 **Subir los cambios al repositorio remoto:**
```bash
git push origin <nombre-de-la-rama>
```  

---

### 🔧 **Resolviendo conflictos y cambios temporales**

🔹 **Fusionar una rama en la actual (puede generar conflictos):**
```bash
git merge <rama-a-fusionar>
```  

🔹 **Cancelar la fusión en caso de problemas:**
```bash
git merge --abort
```  

🔹 **Guardar cambios temporalmente sin hacer commit (stash):**
```bash
git stash
```  

🔹 **Ver las listas de cambios guardados en stash:**
```bash
git stash list
```  

🔹 **Aplicar los cambios guardados más recientes:**
```bash
git stash pop
```  

🔹 **Descartar un stash sin aplicarlo:**
```bash
git stash drop
```  

🔹 **Descartar todos los cambios en archivos no confirmados:**
```bash
git checkout -- .
```  

---

### 📜 **Historial y revisión de cambios**

🔹 **Ver el historial de commits de forma resumida:**
```bash
git log --oneline
```  

🔹 **Ver el historial de commits con una representación gráfica:**
```bash
git log --oneline --graph --all
```  

🔹 **Ver los cambios entre dos commits o ramas:**
```bash
git diff <commit1> <commit2>
```  

🔹 **Ver qué usuario modificó cada línea de un archivo:**
```bash
git blame <archivo>
```  

✅ **Con esta guía, podrás trabajar eficientemente con Git y manejar conflictos de manera efectiva.** 🚀

---

Esta versión es más completa e incluye comandos modernos (`git switch`), opciones para trabajar con stash y commits, y más comandos útiles para el día a día. ¿Te gustaría agregar algún otro comando o explicación más detallada en alguna parte? 😊