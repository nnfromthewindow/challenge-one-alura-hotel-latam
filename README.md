# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/101413385/173164615-192ca98a-1a44-480e-9229-9f82f456eec8.png">
</p>

---
El sistema contiene un login que se conecta a la base de datos de mySQL para checkear si el usuario y la contraseña es valido

![image](https://user-images.githubusercontent.com/97917996/176555322-fac30fda-6b25-4338-8f25-570b396ec255.png)

A la pantalla principal de usuario se le agrego un boton de configuracion desde donde se puede editar el valor diario de las reservas

![image](https://user-images.githubusercontent.com/97917996/176555460-d7977184-a9f1-44a9-8a37-a9e05fa93997.png)

![image](https://user-images.githubusercontent.com/97917996/176555640-bb5d9255-7e3c-4c37-b794-1dcf6c80915f.png)

A la seccion para agregar reservas se le agrego restricciones a los calendarios para que fechas anteriores al dia actual queden bloqueadas y la fecha de salida no pueda ser anterior a la fecha de entrada, ademas tienen listeners que detectan en cuanto hay un cambio de fecha calcula la diferencia de dias y nos muestra el valor total de la estadia en color azul. Por ultimo se agrego un boton para poder volver al menu de usuario.

![image](https://user-images.githubusercontent.com/97917996/176556093-3150b817-756b-44bf-8c5c-25ed02ae2922.png)

A la seccion para agregar al huesped que realizo la reserva se le incorporaron todas las validaciones a los campos y a su vez se incluyo un filtro de edad (editable dentro del codigo) para restringir la reserva a menores de 16 años. Tambien se modifico el campo de numero de reserva para que se muestre en color rojo.

![image](https://user-images.githubusercontent.com/97917996/176556727-4a4cf4de-1f45-420d-9fb1-54645d644c8f.png)

El sistema de busqueda filtra por numero de id de reserva y apellido, ademas en esta seccion se puede editar y borrar reservas y huespedes, asi como cancelar los registros eliminados haciendo rollback para devolver nuestros registros iniciales a la sesion que nos pregunta si queremos guardar los cambios, recien ahi commitea los cambios
![image](https://user-images.githubusercontent.com/97917996/176770669-62e1d5e9-ef49-4399-af96-4af9956992ae.png)

![image](https://user-images.githubusercontent.com/97917996/176770767-fb2b9dbb-7438-4239-85f2-f9757359370e.png)


El esquema de la base de datos MySQL es el siguiente:

![image](https://user-images.githubusercontent.com/97917996/176768619-9236df83-df63-4323-95a5-ae5aa63366d0.png)

Video con el funcionamiento del programa:

https://user-images.githubusercontent.com/97917996/176768746-f80c06ad-ac00-4464-97b4-9ac8b570cac4.mp4


---
##  Primeros Pasos:

#### 🔹 Marca este proyecto con una ⭐
#### 🔹 Sigue las orientaciones que tenemos en este repositorio. 📚
#### 🔹 ¡Visita la página del desafío haciendo clic aquí! [Link do Challenge](https://www.aluracursos.com/challenges/oracle-one-java) 📃
</br>

## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- MySql
- Biblioteca JCalendar
- Plugin WindowBuilder </br>

---
## ⚠️ Importante! ⚠️

☕ Use Java versión 8 para compatibilidad. </br></br>
📝 Recomendamos usar el editor de Eclipse para compatibilidad con la Interfaz Gráfica. </br></br>
🎨 La interfaz contiene dos métodos importantes:
- setResizable(false): determina el tamaño de la ventana, y a través del parámetro <strong>false</strong>, la pantalla no se puede maximizar;
- setLocationRelativeTo(null): determina la ubicación de la ventana, y a través del parámetro <strong>null</strong> la mantiene centrada en la pantalla.

#### Para este desafío, concéntrate en la parte lógica y la conexión con la base de datos, después de completar el desafío, siéntate libre de agregar nuevas funciones y modificar la interfaz gráfica.
---

## 🔍 ¡Analizando nuestro repositorio!

### Este es el repositorio base de nuestro proyecto, en el encontrarás:
#### 🔹 src/views: carpeta con toda la interfaz gráfica de las pantallas necesarias para desarrollar el programa;
#### 🔹 src/imagenes: carpeta con imágenes que puedes usar en tu proyecto. Siéntete libre de usar otros, si lo deseas;
</br>

## ⬇️ Download

### Cómo descargar:

#### 🔹 Fork

1 - Haz el <strong>fork</strong> del proyecto. En la parte superior derecha, al hacer clic en el icono se creará un repositorio del proyecto en tu cuenta personal de GitHub. </br>

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/169404781-7df6355b-3a15-472a-8d8e-fdb84d91a7bd.png">
</p>

2 - Una vez que tengas el repositorio "forkado" en tu cuenta, comprueba si la URL de la página es la del repositorio de tu cuenta.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173256272-6dd3eaba-b52e-42ec-b307-17ed785f9110.png">
</p>

3 - Haz clic en la opción <strong>Code</strong>. Se mostrarán tres formas de instalar el repositorio en su máquina, y destacamos dos:

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173166461-e62d9704-98d5-4773-a60e-57d5729575ae.png">
</p></br>

#### 🔹 Clonar o descargar el ZIP

1 - Para clonar, simplemente copia el <em>url</em> resaltado en la imagen y ubicado justo debajo del HTTPS, crea una carpeta en tu computadora, abre el <em>cmd</em> o el <em>git bash</em> dentro de esa carpeta y luego ingresa el comando <strong>git clone</strong> y con el botón derecho del mouse dentro del terminal haz click en la opcion <strong>Paste</strong> para pegar el <em>url</em> y presiona <em>Enter</em>. 

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173256523-79d38ee2-8668-435c-b31a-ac6ba78bb813.png">
</p>

2 - La segunda opción es descargar el código en un paquete <strong>"zipado"</strong> y extraer la carpeta a tu computadora.
</br></br>

## 📝 Eclipse

### ¿Cómo importar mi proyecto a Eclipse?

1 - Una vez dentro del Editor al lado izquierdo, haz clic en el <em>Files</em> que está en el menú en la parte superior, elige la opción <em>Open Projects from File System</em>.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173164237-1db32d79-2b35-433f-817c-ec3fa30899fc.png">
</p>

Luego haz click en <em>Directory</em> y ubica el directorio del proyecto "clonado" o "extraído" en tu computadora. Haz click en <em>Finish</em> para completar la importación.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173110215-f9451a5e-a9eb-4056-aec8-6eb3e3601e53.png">
</p>

2 - La segunda forma de importar es en <em>File</em> en la opción <em>Import</em>. O a través del <strong>Project Explorer</strong> haz clic en el campo vacío con el botón derecho del mouse y elijas la opción <strong>Import</strong>.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173111357-2ec928ac-5a3d-4f7c-ba84-8906d84bfd08.png">
</p>

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/169431325-23a2e3cb-85a3-4298-8e60-64dfa58e2e6f.png">
</p>

Si te decides por el <strong>Import</strong>, se abrirá la ventana correspondiente. Haz clic en la opción <em>Existing Projects Into Workspace</em> y en el botón <em>Next</em>.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/169431890-27f40955-27d8-4b4d-82df-d3507f85de6c.png">
</p>

Luego haz clic en el botón <em>Browse</em> y busca el proyecto en el directorio local.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/169432246-a769555c-daf9-490e-a0c7-908f7e5de967.png">
</p>

## 📅 JCalendar

Tras realizar la importación a tu editor, es necesario instalar la librería <strong>JCalendar</strong>, de lo contrário, el proyecto presentará un error y no será posible abrir la ventana de <strong>Reservas</strong>. </br>

Para instalar, se necesita descargar el paquete a través de ese enlace: 
🔹 [Link para el JCalendar](https://toedter.com/jcalendar/)

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/169592420-7ea798d4-b7d2-4fd6-a03c-75f0fbc2e4bc.png">
</p>

El siguiente paso es extraer los archivos a una carpeta e importar los archivos desde la carpeta <strong>lib</strong> a una carpeta local e importar los archivos a Eclipse.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173167366-664a8876-a5c9-45d1-880d-650fbd6f8b07.png">     
</p>

Archivos de carpeta <strong>lib</strong>:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173167517-ed6edd9e-7d56-486f-8d47-f50e7ee2c786.png">
</p>

Haz click con el botón derecho encima del proyecto ubicado en el <strong>Package Explorer</strong>, elijas la opción <em>Build Path</em> y <em>Configure Build Path</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173167991-44b111ca-c2d6-4d83-b225-33eb2657448f.png">
</p>

El proyecto tendrá un mensaje de error que indica que la ruta de la biblioteca no existe en tu computadora. Haz click en <em>Libraries</em>, luego en <em>Classpath</em> seleccione el archivo JCalendar, elije la opción <em>Remove</em> y <em>Apply and Close</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173167817-ddbdedc5-c4a6-4f6d-bd86-f86a153d6b88.png">
</p>

Para importar el <strong>Jcalendar</strong> desde tu computadora, después de haber "extraído" los archivos de la descarga, pulsa en <em>ClassPath</em> y luego en <em>Add External JARS</em> agrega uno por uno y haz click en <em>Apply and Close</em>.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/169596029-a9fa21ef-8d90-45a6-8aa2-be2d911d4074.png">
</p>

Por lo tanto, el proyecto debe contener los siguientes archivos después de las importaciones:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173168583-f6352510-d639-40ef-8339-c161688e78a3.png">
</p>

## 🚧 Proyecto

#### Al clonar o descargar el proyecto base y tener instalado el JCalendar, tendrás esta presentación al ejecutar el proyecto en Eclipse:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/169432388-35fdcea3-98ba-4e6c-9f0f-9b3f577b4011.png">
</p>

## 📊 Banco de Dados

### ¿Cómo importar MySqlConnector al proyecto?

Es la misma ruta descrita para importar el <strong>JCalendar</strong>, haga clic con el botón derecho en el proyecto, <em>Build Path</em>, <em>Configure Build Path</em>, <em>Libraries</em>, <em>Add External JARs</em>. Para encontrar la ruta de este archivo <strong>.jar</strong>, ve al disco duro de tu computadora e ingresa a la carpeta  <em>Archivos de Programas (x86)</em>.

- Archivos de Programas (x86):
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169394-a67b528a-c8b7-4f7a-b374-a1da81b1cc5d.png">
</p>

- MySQL
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169551-b32a9978-3a05-4b6e-b077-f586d0c41e31.png">
</p>

- Connector J 8.0:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169584-48e21a03-e70f-4a65-9197-448a3645f526.png">
</p>

- My SQL Connector Java:
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169737-5f93868e-df8f-4177-90ba-faf9570758ac.png">
</p>

### Modelado de tablas:

Para este reto te proponemos dos tablas: <strong>Reservas</strong> y <strong>Huéspedes</strong>. La tabla de huéspedes debe contener la clave externa <em>(foreign key)</em> <strong>idReserva</strong>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/169529338-09a4d4c2-1b5a-41dc-b305-38498ebc29a8.png">
</p>
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/91544872/173358015-a252c5cf-48a2-4285-907d-a69239e7c5a5.png">
</p>

## 🗔 Plugin WindowBuilder

En el menú de <strong>Eclipse</strong>, ir a la pestaña <em>Help</em> y seleccione la opción <em>Eclipse Marketplace</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173254683-a4d27b04-3994-4c7b-bf70-6e1b665a5452.png">
</p>

En la barra de búsqueda, ingresa <strong>window builder</strong> y haz click en <em>Go</em>. Después de la búsqueda, selecciona la primera opción y haz click en <em>Install</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173254936-b1ed41ba-af1b-47ae-bf75-00de4a22ff19.png">
</p>

En la siguiente ventana, selecciona el botón <em>Confirm</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173255237-94789460-0544-4dd3-b00d-2738b83bd575.png">
</p>

Haz click en la opción para aceptar los Términos de Uso, y para finalizar haz clic en <em>Finish</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173255298-05ac80f1-3e93-4097-90af-7fc8a4fa1611.png">
</p>

## 📬 Entrega

### ¿Cómo incluir mi proyecto con el "#" del desafío?

1) Ten el <strong>Fork</strong> del proyecto en tu repositorio en Github.
2) Utilize el topico **#challengeonehotelaluralatam** </br>
3) Ve a la pestaña derecha de tu proyecto y haz clic en el engranaje de configuración en la sección <em>About</em>, seleccione el campo **topics** e inserte la etiqueta **challengeonehotelaluralatam**


### ¿Cómo hago la entrega final de mi Proyecto?

4) Rellena el siguiente formulario con tus datos personales, junto con el enlace de tu repositorio. 🔹 [Link para o formulário](https://lp.alura.com.br/alura-latam-lp-entrega-de-challenge-one-esp)

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/101413385/169529176-ebe296b9-aa12-4790-b873-d534efd8d057.png">
</p>

5) Ve a tu correo electrónico y canjea tu insignia obtenida al completar otro desafío del Proyecto ONE! 🏆

6) ¡No olvides poner un enlace o video de tu proyecto en Linkedin! Etiqueta a #Oracle y #AluraLatam 🏁

🧡 <strong>Oracle</strong></br>
<a href="https://www.linkedin.com/company/oracle/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

💙 <strong>Alura Latam</strong></br>
<a href="https://www.linkedin.com/company/alura-latam/mycompany/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
