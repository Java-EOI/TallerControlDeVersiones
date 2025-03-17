
## 📌 **Introducción a la Carga de Datos en el Proyecto**

En este proyecto, se utiliza un sistema de **carga de datos automatizada** para inicializar registros en la base de datos en diferentes entornos.

📌 **¿Por qué es útil?**  
✔️ **Facilita el desarrollo**, permitiendo trabajar con datos predefinidos en entornos locales.  
✔️ **Asegura la integridad del entorno de producción**, garantizando que los datos críticos sean creados de forma controlada.  
✔️ **Permite automatizar la carga inicial de datos en nuevos despliegues.**

📌 **¿Cómo funciona?**
- Se definen **perfiles de Spring Boot** (`local`, `produccionDATALOAD`) para ejecutar la carga de datos solo en los entornos adecuados.
- Los datos se cargan automáticamente en la base de datos cuando la aplicación arranca.
- En producción, la carga de datos se realiza bajo un modo especial controlado, sin afectar la ejecución normal de la aplicación.

---

## 🔄 **1️⃣ Estrategia de Carga de Datos Según el Entorno**

- Se definen **perfiles de Spring Boot** (`local`, `desarrollo`, `produccion`) para ejecutar la carga de datos solo en
  los entornos adecuados.
- Los datos se cargan automáticamente en la base de datos cuando la aplicación arranca.
- En producción, la carga de datos se realiza bajo un modo especial controlado, sin afectar la ejecución normal de la
  aplicación.

---

## 🔄 **1️⃣ Estrategia de Carga de Datos Según el Entorno**

📌 **El proyecto implementa tres estrategias distintas para la carga de datos:**

| 🌍 **Entorno** | ⚙️ **Perfil de Spring** | 🛠️ **Función**                                                                      |
|----------------|-------------------------|--------------------------------------------------------------------------------------|
| **Local**      | `local`                 | Los desarrolladores pueden definir datos de prueba que no afectan a otros entornos.  |
| **Desarrollo** | `desarrollo`            | Carga el estado inicial deseado para pruebas en el entorno de desarrollo.            |
| **Producción** | `produccion`            | Solo se ejecuta cuando se requiere una carga controlada de datos en un entorno real. |




---

## 🏗️ **2️⃣ Implementación del Data Loader en `local`**

📌 **El perfil `local` carga automáticamente datos al iniciar la aplicación.**

```java
package com.eoi.leccionesgit.loaders;

import com.eoi.leccionesgit.entities.Usuario;
import com.eoi.leccionesgit.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * Carga de datos en el entorno local para pruebas y desarrollo.
 */
@Configuration
@Log4j2
@Profile("local") // Solo se ejecuta en el perfil 'local'
public class LocalDataLoader {

    private final UsuarioRepository usuarioRepository;

    public LocalDataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Inserta datos de prueba automáticamente en la base de datos.
     */
    @PostConstruct
    public void loadData() {
        log.info("📥 Cargando datos de prueba en la base de datos...");

        Usuario[] usuarios = {
            new Usuario("Juan", "juan@example.com"),
            new Usuario("Ana", "ana@example.com"),
            new Usuario("Pedro", "pedro@example.com")
        };

        usuarioRepository.saveAll(Arrays.asList(usuarios));

        log.info("✅ Datos de prueba cargados correctamente.");
    }
}
```

📌 **Cómo activar este perfil:**

- Para ejecutar la configuración `AplicaciónEnLocal` del proyecto en IntelliJ IDEA y activar el perfil `local`, siga
  estos pasos:

    1. **Seleccione la configuración de ejecución:**
        - En la esquina superior derecha de IntelliJ IDEA, asegúrese de que la configuración de ejecución
          `AplicaciónEnLocal` esté seleccionada.

    2. **Abra las configuraciones de la configuración de ejecución:**
        - Haga clic en el icono de configuración (⚙️) junto a `AplicaciónEnLocal` y seleccione **Editar configuraciones
          **.

    3. **Ingrese el perfil en los parámetros de VM:**
        - Añada el siguiente parámetro en el campo `Opciones de VM`:
          ```text
          -Dspring.profiles.active=local
          ```

    4. **Guarde y ejecute la configuración:**
        - Haga clic en **OK** para guardar los cambios.
        - Ejecute la aplicación con el botón de inicio (▶️).

  Con esta configuración, la aplicación usará el perfil `local` al ejecutarse en IntelliJ IDEA con `AplicaciónEnLocal`.


- Desde `application.properties`:
  ```properties
  spring.profiles.active=local
  ```
- Desde `application.yml`:
  ```yaml
  spring:
    profiles:
      active: local
  ```
- O manualmente al ejecutar la aplicación:
  ```sh
  mvn spring-boot:run -Dspring-boot.run.profiles=local
  ```

---

##  **3️⃣ Implementación del Data Loader en `produccionDATALOAD`**

📌 **Este perfil permite cargar datos en producción bajo un modo especial controlado.**  
⚠️ **Este Data Loader SE ejecuta automáticamente cuando se mergea en producción una rama de tipo `release` con la
etiqueta `data`.**

```java
package com.eoi.leccionesgit.loaders;

import com.eoi.leccionesgit.entities.ParametroSistema;
import com.eoi.leccionesgit.repositories.ParametroSistemaRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

/**
 * Carga de datos en entorno de producción bajo control manual.
 */
@Configuration
@Log4j2
@Profile("produccionDATALOAD") // Solo se ejecuta en producción con activación manual
public class ProduccionDataLoader {

    private final ParametroSistemaRepository parametroSistemaRepository;

    public ProduccionDataLoader(ParametroSistemaRepository parametroSistemaRepository) {
        this.parametroSistemaRepository = parametroSistemaRepository;
    }

    /**
     * Inserta parámetros de sistema en producción solo cuando el perfil está activo.
     */
    @PostConstruct
    public void loadData() {
        log.info("🚀 Iniciando carga de datos en producción...");

        List<ParametroSistema> parametros = List.of(
            new ParametroSistema("MAX_CONEXIONES", "100"),
            new ParametroSistema("MODO_OPERACION", "PRODUCCION"),
            new ParametroSistema("HABILITAR_LOGS", "true")
        );

        parametroSistemaRepository.saveAll(parametros);

        log.info("✅ Parámetros del sistema cargados correctamente.");
    }
}
```

📌 **Cómo ejecutar este Data Loader en producción:**
```sh
mvn spring-boot:run -Dspring-boot.run.profiles=produccionDATALOAD
```
⚠️ **Esto se ejecuta manualmente solo cuando es necesario.**

---

## 📌 **4️⃣ Consideraciones y Buenas Prácticas**

✅ **Cargar datos en producción solo cuando sea necesario**:  
✔️ No activar `produccionDATALOAD` en cada despliegue.  
✔️ Solo ejecutarlo bajo supervisión y después de validaciones.

✅ **Evitar sobrescribir datos existentes**:  
✔️ Diseñar los Data Loaders para **no eliminar registros previos**.  
✔️ Validar antes de insertar nuevos registros.

✅ **Hacer pruebas antes de cargar datos en producción**:  
✔️ Ejecutar el Data Loader primero en **entornos de desarrollo o staging**.  
✔️ Asegurar que la carga no genera errores antes de aplicarla en producción.

✅ **Revisar los logs tras ejecutar `produccionDATALOAD`**:  
✔️ Verificar que los registros se han insertado correctamente.  
✔️ Consultar los logs de Spring Boot para confirmar el estado de la carga.


---

## 🎯 **Conclusión**

📌 **El sistema de carga de datos permite inicializar registros en la base de datos de forma segura y controlada.**  
📌 **Existen tres perfiles para la carga de datos: `local` y `desarrollo` (automáticos) y `produccionDATALOAD` (manual).**  
📌 **Siguiendo buenas prácticas, evitamos errores y mantenemos la integridad del entorno de producción.** 🚀

