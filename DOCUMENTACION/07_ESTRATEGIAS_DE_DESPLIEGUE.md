# 📄 ESTRATEGIAS_DE_DESPLIEGUE
## 🚀 Estrategias de Despliegue con Git

En proyectos de software, **el despliegue** es el proceso de publicar una aplicación para que los usuarios puedan acceder a ella. Dependiendo del tamaño del equipo y del entorno, existen diferentes estrategias para gestionar el despliegue utilizando Git.

---

## 📌 **1️⃣ Estrategias de Despliegue con Git**

| 🚀 Estrategia | 📌 Descripción | 🛠️ Cuándo Usarla |
|--------------|--------------|----------------|
| **Despliegue Manual** | Se compila el código y se sube manualmente al servidor. | Pequeños proyectos o entornos de prueba. |
| **Despliegue con Tags (`git tag`)** | Se usa un tag (`v1.0.0`) para marcar versiones y desplegarlas. | Cuando hay versiones estables. |
| **Git Hooks (`post-receive`)** | El servidor se actualiza automáticamente cuando se recibe un `push`. | Despliegues rápidos en entornos de prueba. |
| **CI/CD con GitHub Actions/GitLab CI** | Integración continua y despliegue automático tras cada `merge`. | Proyectos con múltiples desarrolladores. |
| **Despliegue con Docker y Kubernetes** | Se crea una imagen Docker y se despliega en un clúster. | Aplicaciones escalables y distribuidas. |

---

## 📌 **2️⃣ Despliegue Manual**

Es la forma más sencilla, pero también la más propensa a errores.
```bash
git pull origin main
mvn clean package
scp target/app.jar usuario@servidor:/ruta
ssh usuario@servidor "java -jar /ruta/app.jar"
```
⚠️ **No recomendado para entornos con múltiples desarrolladores.**

---

## 📌 **3️⃣ Despliegue con `git tag`**

Podemos marcar versiones estables con un **tag** y desplegar esa versión.
```bash
git tag -a v1.0.0 -m "Versión estable 1.0.0"
git push origin v1.0.0
```
El servidor de producción puede hacer `checkout` de una versión específica:
```bash
git checkout v1.0.0
```
✅ **Ideal para entornos donde cada versión debe ser validada antes del despliegue.**

---

## 📌 **4️⃣ Despliegue Automático con Git Hooks (`post-receive`)**

Podemos hacer que un servidor se actualice automáticamente cuando recibe un `push`.  
En el servidor, creamos un **hook** en `.git/hooks/post-receive`:
```bash
#!/bin/bash
GIT_WORK_TREE=/var/www/app git checkout -f main
systemctl restart app.service
```
✅ **Ideal para entornos de desarrollo donde queremos automatizar la actualización.**

---

## 📌 **5️⃣ Despliegue con CI/CD (Integración Continua)**

Se configura una herramienta como **GitHub Actions**, **GitLab CI/CD** o **Jenkins** para ejecutar pruebas y desplegar automáticamente.

📌 **Ejemplo con GitHub Actions (`.github/workflows/deploy.yml`)**
```yaml
name: Deploy to Production
on:
  push:
    branches:
      - main
jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v3
      - name: Build & Test
        run: mvn clean package
      - name: Deploy to Server
        run: scp target/app.jar usuario@servidor:/ruta
```
✅ **Ideal para proyectos donde los despliegues deben ser automáticos y seguros.**

---

## 📌 **6️⃣ Despliegue con Docker y Docker Compose**

Podemos empaquetar nuestra aplicación en un **contenedor Docker** y desplegarla en cualquier servidor.

📌 **Ejemplo de `Dockerfile` para Spring Boot**
```dockerfile
FROM openjdk:17
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```
📌 **Ejemplo de `docker-compose.yml`**
```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
```
✅ **Ideal para entornos donde queremos garantizar la consistencia del despliegue.**

---

⬅️ **Anterior: [Buenas Prácticas en Git](06_BUENAS_PRACTICAS_EN_GIT.md)**  
📌 **Siguiente: [Flujo de Despliegue del Curso](07A_FLUJO_DE_DESPLIEGUE_DEL_CURSO.md) →**
