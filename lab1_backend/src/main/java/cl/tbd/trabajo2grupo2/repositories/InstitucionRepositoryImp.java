package cl.tbd.trabajo2grupo2.repositories;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import cl.tbd.trabajo2grupo2.models.Institucion;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{
    @Autowired
	private MongoTemplate mongo;

    @Override
    public long getIdNuevaInstitucion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Institucion> getAllInstituciones() {
        return mongo.findAll(Institucion.class);
    }

    @Override
    public void createInstitucion(Institucion institucion) {
        mongo.insert(institucion,"institucion");
    }

    @Override
    public Institucion findByIdInstitucion(long id_institucion) {
        Query query = new Query();
		query.addCriteria(Criteria.where("id_institucion").is(id_institucion));
		return mongo.findOne(query, Institucion.class);
    }

    @Override
    public void updateInstitucion(long id_institucion, Institucion institucion) {
        Query query = new Query(Criteria.where("id_institucion").is(id_institucion));
        Update update = new Update();
        update.set("nombre", institucion.getNombre());
        update.set("direccion", institucion.getDireccion());
        
        mongo.updateFirst(query, update, Institucion.class);
    }

    @Override
    public void deleteInstitucionById(Long id_institucion) {
        Query query= new Query();
        query.addCriteria(Criteria.where("id_institucion").is(id_institucion));
        mongo.findAndRemove(query, Institucion.class);
    }

    
    /* 
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevaInstitucion() {
        long id_institucion_nueva;
        String sqlQuery = "SELECT MAX(id_institucion) FROM institucion";
        try (Connection con = sql2o.open()){
            id_institucion_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_institucion_nueva = -1;
        }
        return id_institucion_nueva;
    }

    @Override
    public List<Institucion> getAllInstituciones() {
        List<Institucion> instituciones = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.institucion ORDER BY id_institucion ASC";
        try (Connection con = sql2o.open()){
            instituciones = con.createQuery(sqlQuery).executeAndFetch(Institucion.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return instituciones;
    }

    @Override
    public void createInstitucion(Institucion institucion) {
        String sqlQuery = "INSERT INTO institucion (id_institucion, nombre_institucion, direccion) VALUES (:id_institucion, :nombre_institucion, :direccion)";
        long id = getIdNuevaInstitucion();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_institucion", id)
            .addParameter("nombre_institucion", institucion.getNombre())
            .addParameter("direccion", institucion.getDireccion())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Institucion findByIdInstitucion(long id_institucion) {
        Institucion institucion = null;
        String sqlQuery = "SELECT * FROM institucion WHERE id_institucion = :id_institucion";
        try (Connection con = sql2o.open()){
            institucion = (Institucion)con.createQuery(sqlQuery).addParameter("id_institucion", id_institucion).executeAndFetch(Institucion.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado//
        }
        return institucion;
    }

    @Override
    public void updateInstitucion(long id_institucion, Institucion institucion) {
        String sqlQuery = "UPDATE institucion SET nombre_institucion = :nombre_institucion, direccion = :direccion WHERE id_institucion = :id_institucion";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_institucion", id_institucion)
            .addParameter("nombre_institucion", institucion.getNombre())
            .addParameter("direccion", institucion.getDireccion())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteInstitucionById(Long id_institucion) {
        String sqlQuery = "DELETE FROM institucion WHERE id_institucion = :id_institucion";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_institucion", id_institucion)
            .executeUpdate();
            con.commit();
        }
    }
    */
}
