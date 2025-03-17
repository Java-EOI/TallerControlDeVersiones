### 🚀 **Ejercicio 4: Creación de una Página HTML con Formulario en Thymeleaf**

---

## **📜 Introducción al Ejercicio**

### **📌 Contexto**
Hasta ahora, hemos creado un controlador para la calculadora y separado la lógica en un servicio. Sin embargo, la interfaz sigue siendo básica.

El equipo de desarrollo ha decidido mejorar la experiencia de usuario añadiendo una página HTML con un **formulario en Thymeleaf** que permita a los usuarios introducir valores y ver los resultados directamente.

Sin embargo, dos desarrolladores han trabajado en **diferentes versiones de la plantilla HTML**, lo que ha generado **conflictos que deben resolverse**.

---

## **🎯 Objetivos**
✅ Crear una **página HTML con Thymeleaf (`calculator.html`)** para que los usuarios puedan realizar operaciones matemáticas.  
✅ Modificar el **controlador (`CalculatorController.java`)** para procesar los datos del formulario.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en versiones incompatibles de la plantilla.  
✅ **Ejecutar pruebas funcionales** para verificar que la vista carga correctamente.

---

## **🔀 Diferencias entre las ramas en conflicto**
Dos desarrolladores han hecho cambios incompatibles en **`calculator.html`**, lo que provocará un **conflicto al intentar fusionarlas**:

- **`ejercicio4-rama1`**  
  🔹 Diseña una versión del formulario **simple** con dos campos de entrada y un botón para enviar.

- **`ejercicio4-rama2`**  
  🔹 Agrega una lista desplegable para seleccionar la operación matemática (`+`, `-`, `*`, `/`).

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión del formulario debe mantenerse.

