¡Genial! Me alegra saber que todo está en orden. 😃 🚀

### 🚀 **Ejercicio 9: Agregar Estilos con CSS**

---

## **📜 Introducción al Ejercicio**

### **📌 Contexto**
Después de la fusión del **Ejercicio 8**, la calculadora ahora maneja validaciones tanto en el **frontend** como en el **backend**. Sin embargo, la interfaz sigue siendo muy básica y sin estilo.

El equipo de desarrollo ha decidido mejorar la apariencia de la aplicación agregando **CSS para mejorar la interfaz de usuario**.

Sin embargo, dos desarrolladores han trabajado en **diferentes enfoques de diseño**, lo que ha generado **conflictos que deben resolverse**.

---

## **🎯 Objetivos**
✅ Agregar una hoja de estilos CSS (`style.css`) para mejorar la apariencia de la calculadora.
✅ Modificar `calculator.html` para enlazar la hoja de estilos.
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en estilos diferentes.
✅ **Ejecutar pruebas visuales** para verificar que los estilos se aplican correctamente.

---

## **🔀 Diferencias entre las ramas en conflicto**
Dos desarrolladores han hecho cambios incompatibles en **`style.css` y `calculator.html`**, lo que provocará un **conflicto al intentar fusionarlas**:

- **`ejercicio9-rama1`**
🔹 Crea un **diseño minimalista** con colores suaves y centrado en la simplicidad.
🔹 Usa `display: flex;` para centrar los elementos en la página.

- **`ejercicio9-rama2`**
🔹 Agrega un **diseño más vibrante y colorido**, con sombras y bordes redondeados.
🔹 Usa `grid` para organizar los elementos de la calculadora.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión del CSS debe mantenerse.
