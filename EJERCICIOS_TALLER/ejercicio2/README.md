¡Por supuesto! Aquí tienes el contenido limpio del **README.md** del **Ejercicio 2**, tal como se vería en IntelliJ IDEA.

---

# 🌍 **Ejercicio 2: Creación de un API REST para la Calculadora**

## 📝 **Contexto**
El equipo de desarrollo ha decidido exponer las funcionalidades de la calculadora como un **API REST** en **Spring Boot**, para que otros sistemas o una futura aplicación web puedan utilizarlo.

Sin embargo, dos desarrolladores han trabajado en el **mismo controlador**, realizando cambios incompatibles. **Ahora hay un conflicto que debes resolver.**

---

## **📌 Objetivos**
✅ Crear un **controlador REST (`CalculatorController.java`)** para exponer operaciones matemáticas.  
✅ Exponer un **endpoint para sumar** números a través de una URL con parámetros.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hagan cambios en el mismo archivo.  
✅ Ejecutar **pruebas unitarias** para verificar el correcto funcionamiento del API.

---

## **🔀 Diferencias entre las ramas en conflicto**
Se han generado **dos ramas con cambios incompatibles en `CalculatorController.java`**, lo que ha provocado un **conflicto al intentar fusionarlas**.

- **`ejercicio2-rama1`**:  
  🔹 **Modifica la URL base del API**, cambiándola de `/api/calculator/` a `/api/math/`.

- **`ejercicio2-rama2`**:  
  🔹 **Añade una nueva operación** `multiplicar(int a, int b)`, manteniendo la URL original `/api/calculator/`.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión del controlador debe mantenerse.

---

## **🚀 Paso 1: Ejecutar el API en Spring Boot**
1️⃣ Abre **IntelliJ IDEA** y asegúrate de estar en la rama `main`.  
2️⃣ Inicia la aplicación de Spring Boot:
   ```bash
   ./gradlew bootRun  # Para Mac/Linux
   gradlew.bat bootRun  # Para Windows
   ```
3️⃣ Abre tu navegador y prueba el siguiente **endpoint REST**:
   ```
   http://localhost:8080/api/calculator/sumar?a=5&b=3
   ```
✅ Debería responder con:
   ```json
   {
     "resultado": 8
   }
   ```

---

## **🔥 Paso 2: Fusionar las ramas y resolver el conflicto**
1️⃣ Intenta fusionar la primera rama:
   ```bash
   git merge ejercicio2-rama1
   ```
2️⃣ Luego, intenta fusionar la segunda:
   ```bash
   git merge ejercicio2-rama2
   ```
3️⃣ **💥 Aquí se generará un conflicto en `CalculatorController.java`**.

**Ejemplo de código en conflicto:**
```java
<<<<<<< HEAD (main)
@RestController
@RequestMapping("/api/math") // URL modificada en ejercicio2-rama1
=======
@RestController
@RequestMapping("/api/calculator") // URL original mantenida en ejercicio2-rama2
>>>>>>> ejercicio2-rama2
```

**✅ Resolución del conflicto:**  
El código corregido en `CalculatorController.java` debería quedar así:

```java
package com.eoi.java6.leccionesdegit.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator") // Mantener esta URL para evitar confusión
public class CalculatorController {

    @GetMapping("/sumar")
    public int sumar(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/multiplicar")
    public int multiplicar(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }
}
```

4️⃣ Guarda el archivo (`Ctrl + S` en Windows o `Cmd + S` en Mac).  
5️⃣ Confirma los cambios en Git:
   ```bash
   git add src/main/java/com/eoi/java6/leccionesdegit/controller/CalculatorController.java
   git commit -m "Resuelto conflicto en CalculatorController.java"
   ```

---

## **🧪 Paso 3: Ejecutar las pruebas**
Después de fusionar y corregir los conflictos, ejecuta las pruebas unitarias para asegurarte de que el API funciona correctamente.

🔹 **Ejecutar las pruebas en IntelliJ IDEA**  
1️⃣ Abre la pestaña **Gradle** (`View` → `Tool Windows` → `Gradle`).  
2️⃣ Ve a **"Tasks" → "verification"**.  
3️⃣ Haz doble clic en **`test`**.

🔹 **Ejecutar desde la terminal**
```bash
./gradlew test  # Para Mac/Linux
gradlew.bat test  # Para Windows
```

✅ Si todo ha salido bien, verás **pruebas exitosas** en la consola. 🎉

---

## **🚀 Paso 4: Subir los cambios a GitHub**
Si todo está correcto y quieres guardar los cambios en el repositorio remoto:

1️⃣ Abre **"Git" → "Commit"** en IntelliJ y confirma los cambios.  
2️⃣ Luego, en **"Git" → "Push"**, selecciona `origin/main` y sube tus cambios.

📌 **Desde la terminal:**
```bash
git push origin main
```

⚠ **Si no tienes permisos en el repositorio original, primero debes hacer un "fork" en GitHub y luego trabajar en tu propia versión.**

---

## **🎯 Objetivo Final**
✅ Resolver los conflictos en `CalculatorController.java`.  
✅ Asegurar que los métodos funcionan correctamente.  
✅ Ejecutar y pasar todas las pruebas automatizadas en IntelliJ IDEA.  
✅ Exponer correctamente las operaciones de la calculadora como un API REST.

---

💡 **Cuando termines este ejercicio, habrás aprendido a resolver conflictos en Git relacionados con controladores REST y a exponer APIs en Spring Boot.** ¡Mucho éxito! 🚀

---

📌 **¡Listo! Ahora puedes copiar y pegar este contenido en tu README.md en IntelliJ.**  
📌 **¿Todo bien o necesitas algún ajuste antes de continuar?** 😊