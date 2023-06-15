import json
import pymongo 

# Datos de conexión
user = "mongo"
password = "mongo"
host = "localhost"
port = "27017"
main_database = "admin"
database = "lab3"

# Conexion a mongoDB
client = pymongo.MongoClient(f"mongodb://{user}:{password}@{host}:{port}/{main_database}")

# Base de datos a usar
db = client.get_database(database)

# Colecciones a cargar
colecciones = ['emergencia', 'voluntario', 'division_regional', 'institucion', 'habilidad']

# Formato de archivos a cargar
formato = '.json'

# Iterar entre colecciones a agregar
for c in colecciones:

    # Se accede a coleccion 
    collection = db.get_collection(c)
    
    # Carga  de .json
    with open(c+formato) as file:
        file_data = json.load(file)
    
    # Insertar los datos cargados a la colecccion
    if isinstance(file_data, list): #Lista -> Multiples documentos a insertar
        collection.insert_many(file_data)

    else: #Caso contrario, es un unico documento a insertar -> insertOne es suficiente
        collection.insert_one(file_data)
