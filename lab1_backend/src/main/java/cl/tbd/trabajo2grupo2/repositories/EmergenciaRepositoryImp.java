package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import cl.tbd.trabajo2grupo2.models.Emergencia;

import java.util.Arrays;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    @Autowired
    private MongoTemplate mongo;

    @Override
    public Long getIdNuevaEmergencia() { // Propenso a ser eliminado
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://mongo:mongo@localhost:27017/?authMechanism=DEFAULT&authSource=admin"));
        MongoDatabase database = mongoClient.getDatabase("lab3");
        MongoCollection<Document> collection = database.getCollection("emergencia");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$sort",
                new Document("id_emergencia", -1L)),
                new Document("$limit", 1L)));

        return result.first().get("id_emergencia", Emergencia.class).getId_emergencia();
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        return mongo.findAll(Emergencia.class);
    }

    @Override
    public void createEmergencia(Emergencia emergencia) {
        /* 
        Long id = getIdNuevaEmergencia();
        emergencia.setId_emergencia(id);
        System.out.println(id);*/
        mongo.insert(emergencia, "emergencia");
    }

    @Override
    public Emergencia findByIdEmergencia(Long id_emergencia) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_emergencia").is(id_emergencia));
        return mongo.findOne(query, Emergencia.class);
    }

    @Override
    public void updateEmergencia(Long id_emergencia, Emergencia emergencia) {
        Query query = new Query(Criteria.where("id_emergencia").is(id_emergencia));
        Update update = new Update();
        update.set("asunto", emergencia.getAsunto());
        update.set("descripcion", emergencia.getDescripcion());
        update.set("direccion", emergencia.getDireccion());
        update.set("fecha", emergencia.getFecha());
        update.set("activa", emergencia.getActiva());
        update.set("institucion", emergencia.getInstitucion());
        update.set("longitud", emergencia.getLongitud());
        update.set("latitud", emergencia.getLatitud());
        update.set("ubicacion", emergencia.getUbicacion());
        update.set("habilidades", emergencia.getHabilidades());

        mongo.updateFirst(query, update, Emergencia.class);
    }

    @Override
    public void deleteEmergenciaById(Long id_emergencia) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_emergencia").is(id_emergencia));
        mongo.findAndRemove(query, Emergencia.class);
    }

    @Override
    public AggregateIterable<Document> obtenerVoluntariosEmergenciasEnRadioR(Double R) {

        MongoClient mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://mongo:mongo@localhost:27017/?authMechanism=DEFAULT&authSource=admin"));
        MongoDatabase database = mongoClient.getDatabase("lab3");
        MongoCollection<Document> collection = database.getCollection("emergencia");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$lookup",
                new Document("from", "voluntario")
                        .append("let",
                                new Document("ub", "$ubicacion.coordinates"))
                        .append("pipeline", Arrays.asList(new Document("$geoNear",
                                new Document("near", "$$ub")
                                        .append("distanceField", "distancia")
                                        .append("minDistance", 0L)
                                        .append("maxDistance", R / (6371L * 1000L))
                                        .append("distanceMultiplier", 6371L * 1000L)
                                        .append("spherical", true))))
                        .append("as", "vol_emergencia")),
                new Document("$unwind",
                        new Document("path", "$vol_emergencia"))));
        return result;
    }

    

    /*
     * @Autowired
     * private Sql2o sql2o;
     * 
     * @Override
     * public Long getIdNuevaEmergencia() {
     * Long id_emergencia_nueva;
     * String sqlQuery = "SELECT MAX(id_emergencia) FROM emergencia";
     * try (Connection con = sql2o.open()){
     * id_emergencia_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
     * } catch (Exception e) {
     * // Conexion a sql ha fallado
     * id_emergencia_nueva = (long) -1;
     * }
     * return id_emergencia_nueva;
     * }
     * 
     * @Override
     * public List<Emergencia> getAllEmergencias() {
     * List<Emergencia> emergencias = new ArrayList<>();
     * String sqlQuery =
     * "SELECT * FROM public.emergencia ORDER BY id_emergencia ASC";
     * try (Connection con = sql2o.open()){
     * emergencias = con.createQuery(sqlQuery).executeAndFetch(Emergencia.class);
     * } catch (Exception e) {
     * // Conexion a sql ha fallado
     * 
     * }
     * return emergencias;
     * }
     * 
     * @Override
     * public void createEmergencia(Emergencia emergencia) {
     * String sqlQuery =
     * "INSERT INTO emergencia (id_emergencia, asunto, fecha, descripcion, direccion, activa, id_institucion, latitud, longitud, ubicacion) VALUES (:id_emergencia, :asunto, :fecha, :descripcion, :direccion, :activa, :id_institucion, :latitud, :longitud, ST_SetSRID(ST_MakePoint(:longitud, :latitud), 4326))"
     * ;
     * Long id = getIdNuevaEmergencia()+1;
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery)
     * .addParameter("id_emergencia", id)
     * .addParameter("asunto", emergencia.getasunto())
     * .addParameter("fecha", emergencia.getfecha())
     * .addParameter("descripcion", emergencia.getdescripcion())
     * .addParameter("direccion", emergencia.getdireccion())
     * .addParameter("activa", emergencia.getactiva())
     * .addParameter("id_institucion", emergencia.getId_institucion())
     * .addParameter("latitud", emergencia.getLatitud())
     * .addParameter("longitud", emergencia.getLongitud())
     * .executeUpdate();
     * con.commit();
     * }
     * }
     * 
     * @Override
     * public Emergencia findByIdEmergencia(Long entrada) {
     * List<Emergencia> emergencias = null;
     * Emergencia emergencia = null;
     * String sqlQuery = "SELECT * FROM emergencia WHERE id_emergencia = :entrada";
     * try (Connection con = sql2o.open()){
     * emergencias = con.createQuery(sqlQuery).addParameter("entrada",
     * entrada).executeAndFetch(Emergencia.class);
     * emergencia = emergencias.get(0);
     * } catch (Exception e) {
     * System.out.println("Error: " + e);
     * }
     * return emergencia;
     * }
     * 
     * @Override
     * public void updateEmergencia(Long id_emergencia, String asunto, String
     * descripcion, String direccion, Date fecha, Boolean activa, Long
     * id_institucion, Long latitud, Long longitud, Point ubicacion) {
     * Emergencia emergencia = findByIdEmergencia(id_emergencia);
     * String sqlQuery =
     * "UPDATE emergencia SET asunto = :asunto, descripcion = :descripcion, direccion = :direccion, fecha =:fecha, activa = :activa, id_institucion = :id_institucion WHERE id_emergencia = :id_emergencia"
     * ;
     * try (Connection con = sql2o.beginTransaction()){
     * if(activa != null)
     * {
     * con.createQuery(sqlQuery)
     * .addParameter("id_emergencia", id_emergencia)
     * .addParameter("asunto", asunto)
     * .addParameter("fecha", emergencia.getfecha())
     * .addParameter("descripcion", descripcion)
     * .addParameter("direccion", direccion)
     * .addParameter("activa", activa)
     * .addParameter("id_institucion", emergencia.getId_institucion())
     * .addParameter("latitud", latitud)
     * .addParameter("longitud", longitud)
     * .addParameter("ubicacion", ubicacion)
     * .executeUpdate();
     * con.commit();
     * }
     * else
     * {
     * con.createQuery(sqlQuery)
     * .addParameter("id_emergencia", id_emergencia)
     * .addParameter("asunto", asunto)
     * .addParameter("fecha", emergencia.getfecha())
     * .addParameter("descripcion", descripcion)
     * .addParameter("direccion", direccion)
     * .addParameter("activa", emergencia.getactiva())
     * .addParameter("id_institucion", emergencia.getId_institucion())
     * .executeUpdate();
     * con.commit();
     * }
     * 
     * }
     * catch(Exception e)
     * {
     * System.out.println("Error: " + e);
     * }
     * }
     * 
     * @Override
     * public void cambiarEstado(Long id_emergencia) {
     * System.out.println("id_emergencia: " + id_emergencia);
     * Emergencia emergencia = findByIdEmergencia(id_emergencia);
     * String sqlQuery = "";
     * if(emergencia.activa)
     * {
     * sqlQuery =
     * "UPDATE emergencia SET activa = FALSE WHERE id_emergencia = :id_emergencia";
     * }
     * else
     * {
     * sqlQuery =
     * "UPDATE emergencia SET activa = TRUE WHERE id_emergencia = :id_emergencia";
     * 
     * }
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery)
     * .addParameter("id_emergencia", id_emergencia)
     * .executeUpdate();
     * con.commit();
     * }
     * }
     * 
     * @Override
     * public void deleteEmergenciaById(Long id_emergencia) {
     * String sqlQuery =
     * "DELETE FROM emergencia WHERE id_emergencia = :id_emergencia";
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery)
     * .addParameter("id_emergencia", id_emergencia)
     * .executeUpdate();
     * con.commit();
     * }
     * }
     * 
     * @Override
     * public void obtenerVoluntariosEmergenciaEnRadioR(Long id_emergencia, Double
     * R) {
     * 
     * //Sentencia SQL para crear una tabla que separe la emergencia seleccionada
     * del resto
     * String sqlQuery1 = "DROP TABLE IF EXISTS emergencia_seleccionada;"
     * +"CREATE TABLE emergencia_seleccionada AS (SELECT * FROM emergencia WHERE id_emergencia = :id_emergencia AND emergencia.activa = true)"
     * ;
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery1)
     * .addParameter("id_emergencia", id_emergencia)
     * .executeUpdate();
     * con.commit();
     * } catch (Exception e) {
     * System.out.println("Error en sentencia 1: " + e);
     * }
     * 
     * //Sentencia SQL para crear una tabla que encuentre los voluntarios, dentro
     * del radio R, que cumplan con al menos 1 de las habilidades que la emergencia
     * exige
     * String sqlQuery2 =
     * "DROP TABLE IF EXISTS voluntario_inscrito;"+
     * "CREATE TABLE voluntario_inscrito AS ("+
     * "SELECT voluntario.id_voluntario, voluntario.nombre, habilidad.caracteristica, st_distance(emergencia_seleccionada.ubicacion::geography, voluntario.ubicacion::geography) as distancia_emergencia "
     * +
     * "FROM emergencia_seleccionada, eme_habilidad, habilidad, vol_habilidad, voluntario "
     * +
     * "WHERE emergencia_seleccionada.id_emergencia = :id_emergencia "+
     * "AND eme_habilidad.id_emergencia = emergencia_seleccionada.id_emergencia "+
     * "AND habilidad.id_habilidad = eme_habilidad.id_habilidad "+
     * "AND vol_habilidad.id_habilidad = habilidad.id_habilidad "+
     * "AND voluntario.id_voluntario = vol_habilidad.id_voluntario "+
     * "AND st_distance(emergencia_seleccionada.ubicacion::geography, voluntario.ubicacion::geography) < :R"
     * +
     * ")";
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery2)
     * .addParameter("id_emergencia", id_emergencia)
     * .addParameter("R", R)
     * .executeUpdate();
     * con.commit();
     * } catch (Exception e) {
     * System.out.println("Error en sentencia 2: " + e);
     * }
     * 
     * //Sentencia SQL para crear una tabla que recupere los voluntarios del
     * criterio anterior y adjunte la ubicación (a ver en QGIS)
     * String sqlQuery3 =
     * "DROP TABLE IF EXISTS ubicacion_inscrito;"+
     * "CREATE TABLE ubicacion_inscrito AS ("+
     * "SELECT DISTINCT voluntario_inscrito.id_voluntario, voluntario_inscrito.nombre, voluntario_inscrito.distancia_emergencia, voluntario.ubicacion "
     * +
     * "FROM voluntario_inscrito, voluntario "+
     * "WHERE voluntario_inscrito.id_voluntario = voluntario.id_voluntario"+
     * ")";
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery3)
     * .executeUpdate();
     * con.commit();
     * } catch (Exception e) {
     * System.out.println("Error en sentencia 3: " + e);
     * }
     * 
     * System.out.println("Terminado!");
     * }
     */
}
