package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import cl.tbd.trabajo2grupo2.models.Voluntario;

import java.util.Arrays;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
    @Autowired
    private MongoTemplate mongo;

    @Override
    public List<Voluntario> getAllVoluntarios() {
        return mongo.findAll(Voluntario.class);
    }

    @Override
    public void createVoluntario(Voluntario voluntario) {
        mongo.insert(voluntario, "voluntario");
    }

    @Override
    public Voluntario findByIdVoluntario(long id_voluntario) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_voluntario").is(id_voluntario));
        return mongo.findOne(query, Voluntario.class);
    }

    @Override
    public void updateVoluntario(long id_voluntario, Voluntario voluntario) {
        Query query = new Query(Criteria.where("id_voluntario").is(id_voluntario));
        Update update = new Update();

        update.set("nombre", voluntario.getNombre());
        update.set("fecha_registro", voluntario.getFecha_registro());
        update.set("latitud", voluntario.getLatitud());
        update.set("longitud", voluntario.getLongitud());
        update.set("ubicacion", voluntario.getUbicacion());

        mongo.updateFirst(query, update, Voluntario.class);
    }

    @Override
    public void deleteVoluntarioById(Long id_voluntario) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_voluntario").is(id_voluntario));
        mongo.findAndRemove(query, Voluntario.class);
    }

    @Override
    public long getIdNuevoVoluntario() { // Propenso a ser eliminado
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public AggregateIterable<Document> getTotalHabilidadesVoluntarioPorComuna() {
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://mongo:mongo@localhost:27017/?authMechanism=DEFAULT&authSource=admin"));
        MongoDatabase database = mongoClient.getDatabase("lab3");
        MongoCollection<Document> collection = database.getCollection("division_regional");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$lookup",
                new Document("from", "habilidad")
                        .append("pipeline", Arrays.asList())
                        .append("as", "hab_comuna")),
                new Document("$unwind",
                        new Document("path", "$hab_comuna")),
                new Document("$addFields",
                        new Document("hab_comuna.conteo", 0L))));
        return result;
    }

    /*
     * @Autowired
     * private Sql2o sql2o;
     * 
     * @Override
     * public long getIdNuevoVoluntario() {
     * long id_voluntario_nuevo;
     * String sqlQuery = "SELECT MAX(id_voluntario) FROM voluntario";
     * try (Connection con = sql2o.open()){
     * id_voluntario_nuevo = con.createQuery(sqlQuery).executeScalar(Long.class);
     * } catch (Exception e) {
     * // Conexion a sql ha fallado
     * id_voluntario_nuevo = -1;
     * }
     * return id_voluntario_nuevo;
     * }
     * 
     * @Override
     * public List<Voluntario> getAllVoluntarios() {
     * List<Voluntario> voluntarios = new ArrayList<>();
     * String sqlQuery =
     * "SELECT * FROM public.voluntario ORDER BY id_voluntario ASC";
     * try (Connection con = sql2o.open()){
     * voluntarios = con.createQuery(sqlQuery).executeAndFetch(Voluntario.class);
     * } catch (Exception e) {
     * // Conexion a sql ha fallado
     * 
     * }
     * return voluntarios;
     * }
     * 
     * @Override
     * public void createVoluntario(Voluntario voluntario) {
     * String sqlQuery =
     * "INSERT INTO voluntario (id_voluntario, nombre_voluntario, fecha_registro, latitud, longitud, ubicacion)"
     * +
     * "VALUES (:id_emergencia, :nombre_voluntario, :fecha_registro, :latitud, :longitud, ST_SetSRID(ST_MakePoint(:longitud, :latitud), 4326))"
     * ;
     * long id = getIdNuevoVoluntario();
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery)
     * .addParameter("id_voluntario", id)
     * .addParameter("nombre_voluntario", voluntario.getNombre())
     * .addParameter("fecha_registro", voluntario.getFecha_registro())
     * .addParameter("latitud", voluntario.getLatitud())
     * .addParameter("longitud", voluntario.getLongitud())
     * .addParameter("ubicacion", voluntario.getUbicacion())
     * .executeUpdate();
     * con.commit();
     * }
     * }
     * 
     * @Override
     * public Voluntario findByIdVoluntario(long id_voluntario) {
     * Voluntario voluntario = null;
     * String sqlQuery =
     * "SELECT * FROM voluntario WHERE id_voluntario = :id_voluntario";
     * try (Connection con = sql2o.open()){
     * voluntario =
     * (Voluntario)con.createQuery(sqlQuery).addParameter("id_voluntario",
     * id_voluntario).executeAndFetch(Voluntario.class);
     * } catch (Exception e) {
     * // Conexion a sql ha fallado
     * }
     * return voluntario;
     * }
     * 
     * @Override
     * public void updateVoluntario(long id_voluntario, Voluntario voluntario) {
     * String sqlQuery =
     * "UPDATE voluntario SET nombre_voluntario = :nombre_voluntario, fecha_registro= :fecha_registro WHERE id_voluntario = :id_voluntario"
     * ;
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery)
     * .addParameter("id_voluntario", id_voluntario)
     * .addParameter("nombre_voluntario", voluntario.getNombre())
     * .addParameter("fecha_registro", voluntario.getFecha_registro())
     * .addParameter("latitud", voluntario.getLatitud())
     * .addParameter("longitud", voluntario.getLongitud())
     * .addParameter("ubicacion", voluntario.getUbicacion())
     * .executeUpdate();
     * con.commit();
     * }
     * }
     * 
     * @Override
     * public void deleteVoluntarioById(Long id_voluntario) {
     * String sqlQuery =
     * "DELETE FROM voluntario WHERE id_voluntario = :id_voluntario";
     * try (Connection con = sql2o.beginTransaction()){
     * con.createQuery(sqlQuery)
     * .addParameter("id_voluntario", id_voluntario)
     * .executeUpdate();
     * con.commit();
     * }
     * }
     */
}