### 🚀 **Ejercicio 7: Agregar Más Operaciones Matemáticas**

---

## **📜 Introducción al Ejercicio**

### **📌 Contexto**
Después de la fusión del **Ejercicio 6**, la aplicación maneja errores correctamente tanto en el backend como en el frontend. Sin embargo, la calculadora solo soporta **operaciones básicas** (`suma`, `resta`, `multiplicación` y `división`).

El equipo de desarrollo ha decidido **ampliar la funcionalidad** agregando nuevas operaciones matemáticas como:  
✔ **Potenciación (`a^b`)**  
✔ **Raíz cuadrada (`√a`)**  
✔ **Módulo (`a % b`)**

Sin embargo, dos desarrolladores han trabajado en **diferentes versiones de esta ampliación**, lo que ha generado **conflictos que deben resolverse**.

---

## **🎯 Objetivos**
✅ Modificar el **servicio (`CalculatorService.java`)** para agregar nuevas operaciones matemáticas.  
✅ Modificar el **controlador (`CalculatorController.java`)** para permitir seleccionar estas operaciones desde el formulario.  
✅ Modificar la **plantilla `calculator.html`** para agregar estas nuevas opciones.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en versiones incompatibles del código.  
✅ **Ejecutar pruebas funcionales** para verificar que las nuevas operaciones funcionan correctamente.

---

## **🔀 Diferencias entre las ramas en conflicto**
Dos desarrolladores han hecho cambios incompatibles en **`CalculatorService.java`, `CalculatorController.java` y `calculator.html`**, lo que provocará un **conflicto al intentar fusionarlas**:

- **`ejercicio7-rama1`**  
  🔹 Modifica **`CalculatorService.java`** para agregar `potenciación` y `raíz cuadrada`.  
  🔹 Modifica **`calculator.html`** para agregar opciones de `potenciación` y `raíz cuadrada` en la lista de operaciones.

- **`ejercicio7-rama2`**  
  🔹 Modifica **`CalculatorService.java`** para agregar `módulo` (`a % b`).  
  🔹 Modifica **`calculator.html`** para agregar opción de `módulo`.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión de `CalculatorService.java` y `calculator.html` debe mantenerse.

---

📌 **Ahora continuamos con la creación de los archivos en `main`.**  