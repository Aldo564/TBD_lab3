# Laboratorio 3 Taller de Base de Datos
## Contexto
> En nuestro país, con la ocurrencia de desastres naturales, se da con frecuencia que voluntarios concurren espontáneamente al sitio del suceso. Si bien su presencia es de gran ayuda, puede resultar difícil coordinar sus esfuerzos para la realización de tareas. Para este fin, se propone crear un sistema para la gestión del voluntariado espontáneo.
El sistema de voluntariado debe estar asociado a una institución de voluntariado. En cada institución hay coordinadores que decretan emergencias para iniciar el reclutamiento de voluntarios. En estas emergencias se definen requisitos para los voluntarios (por ejemplo: los voluntarios deben tener determinado equipamiento, salud compatible, etc).
Posteriormente los voluntarios seleccionados serán rankeados según estos requisitos, voluntarios con mayor número de requisitos tienen mayor ranking. Los voluntarios declaran su disponibilidad para ser reclutados a una emergencia. Una vez que son contactados, el coordinador les asigna tareas. Los voluntarios finalmente actualizan el estado de las tareas, para ser consultados por el coordinador.


## Equipo de trabajo
- Integrantes:
    - Luis Mellado (Backend/Frontend)
    - Karen Garrido (Backend)
    - Aldo Castillo (Frontend)
    - Eduardo Abarca (Backend)
 - Semestre: 2-2022
 - Fecha de entrega: 12/12/2022


## Manual de instalación
Las siguientes subsecciones tienen por objetivo presentar el conjunto de instrucciones necesario para instalar los programas requeridos por el proyecto contenido en este repositorio. Es necesario seguir el orden en el cuál se presentan, pues cada paso requiere que los anteriores se hayan completado satisfactoriamente. Como observación, este conjunto de instrucciones estará limitado a S.O. Windows, y no se garantiza que funcione en otros S.O..


### Programas necesarios a instalar
 - Visual Studio Code con extensión "Gradle for Java"
 - Python3, versión 3.11.1
 - Pymongo, versión 4.3.3
 - Npm, versión 8.12.1
 - Node.js, versión 16.14.2
 - MongoDB Compass, versión 6.0.3 (msi)


### Instalar Visual Studio Code y extensión "Gradle for Java"
1. Descargar Visual Studio Code de https://code.visualstudio.com/download
2. Ejecutar el archivo descargado como administrador
3. En la primera ventana, click en 'I accept the agreement', para las siguientes ventanas hacer click en 'siguiente'
4. Ya instalado, ejecutar Visual Studio Code
5. Para acceder a las extensiones, realizar la siguiente combinación de teclas: Ctrl+Shift+x
6. Ingresar en la barra de búsqueda e instalar: 
    - 'Gradle for Java' (Microsoft)
    - 'Python' (Microsoft)
    - 'Code Runner' (Jun Han)


### Instalar npm (v 8.12.1)
```bash
# Abrir cmd o Powershell y ejecutar el siguiente comando
$ npm install -g npm@8.12.1
```


### Instalar node.js (v 16.14.2)
```bash
# Abrir cmd o Powershell y ejecutar el siguiente comando
$ npm install -g nodejs@16.14.2
```


### Instalar Python3 (v 3.11.1)
1. Descargar de https://www.python.org/ (Downloads -> Python 3.11.1) 
2. Instalar (Clickear en "Add Python 3.11.1 to PATH" y elegir opción "Install now").
3. Asegurar instalación de módulo pip: 
```bash
# Abrir cmd o Powershell y ejecutar el siguiente comando
$ python -m ensurepip --upgrade
```


### Instalar Pymongo (v 4.3.3)
```bash
# Abrir cmd o Powershell y ejecutar el siguiente comando
$ pip install pymongo
```


### Instalar MongoDB Compass (v 6.0.3, msi)
1. Descargar de https://www.mongodb.com/try/download/community-edition
2. Ejecutar el archivo descargado como administrador
3. En la primera ventana, click en 'I accept the agreement', para las siguientes ventanas hacer click en 'siguiente'


### Configurar MongoDB Compass para conexión con credenciales
Dadas las exigencias del laboratorio, la API REST que se conecta a MongoDB debe usar autenticación mediante el uso de credenciales. Al abrir MongoDB Compass:
1. Click en 'New Connection'
2. Click en 'Advanced Connection Options'
3. Click en 'Authentication'
4. Rellenar los campos:
    - Authentication Method: Username/Password
    - Username: mongo
    - Password: mongo
    - Authentication Database: admin
    - Authentication Mechanism: Default
5. Click en 'Save'
6. Click en 'Connect' (Para así poder cumplir el paso a continuación)


### Configurar usuario de MongoDB 'mongo' para bases de datos 'admin' y 'lab3'
```bash
# Hacer click en >_Mongosh (Ubicado en el sector inferior de la ventana), desplegará una consola con el siguiente texto:
test>

# Conectarse a base de datos 'admin'
test> use admin

# Crear superusuario 'mongo' con contraseña 'mongo'
admin> db.createUser({user: "mongo", pwd: "mongo", roles: [ { role: "root", db: "admin" } ]})

# Conectarse a base de datos 'lab3'
admin> use lab3

# Crear usuario 'mongo' con contraseña 'mongo' asociado a la base de datos 'lab3', con permisos de lectura y escritura
lab3> db.createUser({user: "mongo", pwd: "mongo", roles: [ { role: "readWrite", db: "lab3" } ]})

#Cerrar consola, haciendo click en >_Mongosh
```


### Cargar datos de archivos .json a base de datos 'lab3'
```bash
# Abrir cmd o Powershell y dirigirse a directorio de aplicación back-end
$ cd C:\Users\ASUS\Desktop\Grupo2_Lab3_TBD\lab1_backend

# Ejecutar el script con el siguient comando
$ & C:/Users/ASUS/AppData/Local/Programs/Python/Python39/python.exe c:/Users/ASUS/Desktop/Grupo2_Lab3_TBD/script.py
```


## Manual de ejecución
### Ejecutar back-end
```bash
# Abrir cmd o Powershell y dirigirse a directorio de aplicación back-end
$ cd C:\Users\ASUS\Desktop\Grupo2_Lab3_TBD\lab1_backend

# Ejecutar el proyecto (URL: http://localhost:3000)
$ ./gradlew bootRun
```


### Ejecutar front-end
```bash
# Abrir cmd o Powershell y dirigirse a directorio de aplicación front-end
$ cd C:\Users\ASUS\Desktop\Grupo2_Lab3_TBD\lab1_frontend

# Instalar dependencias para hacer posible la ejecución
$ npm install

# Ejecutar el proyecto, cuyo acceso será ingresando la siguiente URL en su navegador de preferencia: http://localhost:8080
$ npm run dev
```
