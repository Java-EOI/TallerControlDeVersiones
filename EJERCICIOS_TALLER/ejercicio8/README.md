### 🚀 **Ejercicio 8: Manejo de Errores en Frontend y Backend (Validaciones Avanzadas)**

---

## **📜 Introducción al Ejercicio**

### **📌 Contexto**
Después de la fusión del **Ejercicio 7**, la calculadora ahora permite realizar operaciones avanzadas como **potencia y raíz cuadrada**. Sin embargo, **no valida correctamente los valores ingresados**, lo que puede causar errores en la aplicación.

El equipo de desarrollo ha decidido mejorar la aplicación agregando **validaciones más avanzadas en el backend y el frontend** para evitar errores cuando los usuarios ingresan valores no válidos.

Sin embargo, dos desarrolladores han trabajado en **diferentes enfoques para la validación**, lo que ha generado **conflictos que deben resolverse**.

---

## **🎯 Objetivos**
✅ Modificar el **controlador (`CalculatorController.java`)** para manejar errores con validaciones avanzadas en el backend.  
✅ Modificar el **frontend (`calculator.html`)** para evitar que los usuarios ingresen valores inválidos antes de enviar el formulario.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en versiones incompatibles del código.  
✅ **Ejecutar pruebas funcionales** para verificar que la validación funciona correctamente.

---

## **🔀 Diferencias entre las ramas en conflicto**
Dos desarrolladores han hecho cambios incompatibles en **`CalculatorController.java`** y **`calculator.html`**, lo que provocará un **conflicto al intentar fusionarlas**:

- **`ejercicio8-rama1`**  
  🔹 Modifica el **backend** para manejar errores con **mensajes específicos** cuando se ingresan valores no válidos.  
  🔹 Modifica **`calculator.html`** para mostrar mensajes de error devueltos por el backend.

- **`ejercicio8-rama2`**  
  🔹 Modifica el **frontend** para validar los datos ingresados **antes de enviarlos al backend**.  
  🔹 Evita que el formulario se envíe si hay valores inválidos, mostrando alertas en el navegador.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión del manejo de errores debe mantenerse.

