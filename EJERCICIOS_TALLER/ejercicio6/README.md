¡Sí! Las dos ramas **generarán conflictos** porque han modificado **las mismas partes de `CalculatorController.java` y `calculator.html`**, pero con enfoques distintos:

- **`ejercicio5-rama1`** solo implementa la suma.
- **`ejercicio5-rama2`** permite seleccionar cualquier operación matemática.

Cuando los alumnos intenten fusionarlas, **Git no podrá decidir automáticamente qué versión conservar**, obligándolos a resolver el conflicto.

---

### 🚀 **Ejercicio 6: Manejo de Errores en Frontend y Backend**

---

## **📜 Introducción al Ejercicio**

### **📌 Contexto**
Después de la fusión del **Ejercicio 5**, la calculadora ya permite procesar operaciones matemáticas enviadas desde el formulario. Sin embargo, **no maneja correctamente los errores** cuando se introducen valores inválidos, como dividir entre cero o enviar un campo vacío.

El equipo de desarrollo ha decidido mejorar la aplicación agregando **manejo de errores tanto en el frontend como en el backend**.

Sin embargo, dos desarrolladores han trabajado en **diferentes versiones del manejo de errores**, lo que ha generado **conflictos que deben resolverse**.

---

## **🎯 Objetivos**
✅ Modificar el **controlador (`CalculatorController.java`)** para manejar errores cuando se ingresan datos inválidos.  
✅ Modificar la **plantilla `calculator.html`** para mostrar mensajes de error al usuario.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en versiones incompatibles del código.  
✅ **Ejecutar pruebas funcionales** para verificar que los errores se manejan correctamente.

---

## **🔀 Diferencias entre las ramas en conflicto**
Dos desarrolladores han hecho cambios incompatibles en **`CalculatorController.java` y `calculator.html`**, lo que provocará un **conflicto al intentar fusionarlas**:

- **`ejercicio6-rama1`**  
  🔹 Modifica el **controlador** para manejar la división por cero y devolver un error en la respuesta.  
  🔹 Modifica **`calculator.html`** para mostrar un mensaje de error cuando ocurra un problema en el backend.

- **`ejercicio6-rama2`**  
  🔹 Modifica el **controlador** para verificar que los campos no estén vacíos antes de procesar la operación.  
  🔹 Modifica **`calculator.html`** para mostrar alertas cuando los campos no sean válidos antes de enviarlos al backend.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión del manejo de errores debe mantenerse.

