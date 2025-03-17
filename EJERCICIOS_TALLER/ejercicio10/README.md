¡Por supuesto! 🎯 **Podemos diseñar un Ejercicio 10 diferente, manteniendo la lógica de resolución de conflictos, pero con otro propósito.**

---

## 🔥 **Nuevo Ejercicio 10: Implementar un Historial de Cálculos**

### **📌 Contexto**
Después de la fusión del **Ejercicio 9**, la calculadora ya es funcional, tiene validaciones en el **frontend** y **backend**, y cuenta con un diseño atractivo. Sin embargo, los usuarios han solicitado una nueva funcionalidad: **un historial de cálculos** que les permita ver los últimos resultados.

Dos desarrolladores han trabajado en **diferentes enfoques** para implementar el historial, lo que generará **conflictos al fusionar sus cambios**.

---

## 🎯 **Objetivos del Ejercicio**
✅ Implementar un **historial de cálculos** para que los usuarios vean las operaciones anteriores.  
✅ Resolver **conflictos en Git** cuando dos desarrolladores hayan trabajado en la misma funcionalidad con diferentes enfoques.  
✅ **Verificar que el historial se muestra correctamente en la interfaz.**

---

## **🔀 Diferencias entre las ramas en conflicto**
Los dos desarrolladores han implementado el historial de cálculos, pero de maneras distintas:

- **`ejercicio10-rama1`**  
  🔹 Guarda el historial en una **lista en memoria (ArrayList)** en `CalculatorService.java`.  
  🔹 Muestra el historial en `calculator.html` debajo del resultado.

- **`ejercicio10-rama2`**  
  🔹 Guarda el historial en **un archivo de texto (`historial.txt`)**, registrando cada operación realizada.  
  🔹 Permite al usuario ver el historial desde `calculator.html`.

Cuando intentes fusionarlas, Git **no podrá decidir automáticamente** qué versión del historial debe mantenerse.
