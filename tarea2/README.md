**Curso:** springboot-kafka

**Instructor:** Alejandro Fiengo

**Institución:** i-Quattro

**Nombre Completo:** Ebert Castillo Cortez

**TAREA 2 · CRUD básico de productos**

**Objetivo**
Construir un CRUD simple para la entidad Product utilizando Spring Data JPA, Docker Compose y pruebas con Postman, consolidando todo lo aprendido en la Clase 2.

**CREACION DEL PROYECTO**

**DOCUMENTOS JAVA**

![Imagen de contenedor descargada](screenshots/prdcontroller.png)

![Imagen de contenedor descargada](screenshots/productent.png)

![Imagen de contenedor descargada](screenshots/productrepository.png)

![Imagen de contenedor descargada](screenshots/applpropierties.png)

![Imagen de contenedor descargada](screenshots/pom.png)


**DOCUMENTOS DOCKER**

![Imagen de contenedor descargada](screenshots/dockercompóse.png)

**EJECUCION DOCKER**

![Imagen de contenedor descargada](screenshots/dockercompose.png)

**EJECUCION PROYECTO-VERIFICACION**

![Imagen de contenedor descargada](screenshots/verificarweb.png)

**Requerimientos funcionales**

**POST /api/products crea un producto con los campos name, description, price, stock.**

![Imagen de contenedor descargada](screenshots/json.png)

**GET /api/products lista todos los productos y permite filtrar por nombre con ?name=.**

![Imagen de contenedor descargada](screenshots/jsonget.png)

**GET /api/products/{id} devuelve un producto por su identificador.**

![Imagen de contenedor descargada](screenshots/jsongetid.png)

**PUT /api/products/{id} actualiza un producto existente (todos los campos).**

![Imagen de contenedor descargada](screenshots/jsonputid.png)

**DELETE /api/products/{id} elimina un producto.**

![Imagen de contenedor descargada](screenshots/jsondeleteid.png)

![Imagen de contenedor descargada](screenshots/jsongetidbeforedelete.png)

**INSERT POR CONSOLA**

![Imagen de contenedor descargada](screenshots/insercmd.png)

![Imagen de contenedor descargada](screenshots/tit1.png)

**LOGS**

![Imagen de contenedor descargada](screenshots/logs.png)


