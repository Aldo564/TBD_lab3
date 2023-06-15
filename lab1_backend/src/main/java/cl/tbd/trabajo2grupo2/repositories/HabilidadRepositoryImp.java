package cl.tbd.trabajo2grupo2.repositories;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
import cl.tbd.trabajo2grupo2.models.Habilidad;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
	private MongoTemplate mongo;

    @Override
    public long getIdNuevaHabilidad() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Habilidad> getAllHabilidades() {
        return mongo.findAll(Habilidad.class);
    }

    @Override
    public void createHabilidad(Habilidad habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Habilidad findByIdHabilidad(long id_habilidad) {
        Query query = new Query();
		query.addCriteria(Criteria.where("id_habilidad").is(id_habilidad));
		return mongo.findOne(query, Habilidad.class);
    }

    @Override
    public void updateHabilidad(long id_habilidad, Habilidad habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteHabilidadById(Long id_habilidad) {
        // TODO Auto-generated method stub
        
    }
    /* 
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevaHabilidad() {
        long id_habilidad_nueva;
        String sqlQuery = "SELECT MAX(id_habilidad) FROM habilidad";
        try (Connection con = sql2o.open()){
            id_habilidad_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_habilidad_nueva = -1;
        }
        return id_habilidad_nueva;
    }

    @Override
    public List<Habilidad> getAllHabilidades() {
        List<Habilidad> habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.habilidad ORDER BY id_habilidad ASC";
        try (Connection con = sql2o.open()){
            habilidades = con.createQuery(sqlQuery).executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return habilidades;
    }

    @Override
    public void createHabilidad(Habilidad habilidad) {
        String sqlQuery = "INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (:id_habilidad, :nombre_habilidad)";
        long id = getIdNuevaHabilidad();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_habilidad", id)
            .addParameter("nombre_habilidad", habilidad.getCaracteristica())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Habilidad findByIdHabilidad(long id_habilidad) {
        Habilidad habilidad = null;
        String sqlQuery = "SELECT * FROM habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.open()){
            habilidad = (Habilidad)con.createQuery(sqlQuery).addParameter("id_habilidad", id_habilidad).executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado//
        }
        return habilidad;
    }

    @Override
    public void updateHabilidad(long id_habilidad, Habilidad habilidad) {
        String sqlQuery = "UPDATE habilidad SET nombre_habilidad = :nombre_habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_habilidad", id_habilidad)
            .addParameter("nombre_habilidad", habilidad.getCaracteristica())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteHabilidadById(Long id_habilidad) {
        String sqlQuery = "DELETE FROM habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_habilidad", id_habilidad)
            .executeUpdate();
            con.commit();
        }
    }
    */

    
}
