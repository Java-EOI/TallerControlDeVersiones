### 🚀 **Ejercicio 5: Conectar el Frontend y Backend con Thymeleaf**

---

## **📜 Introducción al Ejercicio**

### **📌 Contexto**
Después de la fusión del **Ejercicio 4**, la calculadora ya cuenta con una interfaz HTML funcional con un formulario. Sin embargo, la conexión entre el **frontend (Thymeleaf)** y el **backend (Spring Boot)** aún no está bien implementada.

El equipo de desarrollo ha decidido mejorar esta integración permitiendo que el formulario envíe los datos correctamente al backend, y que el resultado de la operación se muestre en la misma página.

Sin embargo, dos desarrolladores han trabajado en **diferentes versiones de la conexión entre el formulario y el backend**, lo que ha generado **conflictos que deben resolverse**.

---

## **🎯 Objetivos**
✅ Modificar el **controlador (`CalculatorController.java`)** para procesar los datos enviados desde el formulario.  
✅ Modificar la **plantilla `calculator.html`** para mostrar el resultado en la misma página después de una operación.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en versiones incompatibles del código.  
✅ **Ejecutar pruebas funcionales** para verificar que la integración Thymeleaf - Spring Boot funciona correctamente.

---

## **🔀 Diferencias entre las ramas en conflicto**
Dos desarrolladores han hecho cambios incompatibles en **`CalculatorController.java` y `calculator.html`**, lo que provocará un **conflicto al intentar fusionarlas**:

- **`ejercicio5-rama1`**  
  🔹 Modifica el **controlador** para recibir datos desde el formulario y calcular la suma.  
  🔹 Modifica **`calculator.html`** para mostrar el resultado después de la operación.

- **`ejercicio5-rama2`**  
  🔹 Modifica el **controlador** para procesar la operación seleccionada en el formulario.  
  🔹 Modifica **`calculator.html`** para actualizar dinámicamente el resultado según la operación elegida.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión de la integración Thymeleaf - Spring Boot debe mantenerse.

