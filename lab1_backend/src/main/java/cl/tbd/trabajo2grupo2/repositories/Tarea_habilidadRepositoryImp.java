package cl.tbd.trabajo2grupo2.repositories;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import cl.tbd.trabajo2grupo2.models.Tarea_habilidad;

@Repository
public class Tarea_habilidadRepositoryImp implements Tarea_habilidadRepository{
    @Autowired
	private MongoTemplate mongo;

    @Override
    public long getIdNuevaTarea_habilidad() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Tarea_habilidad> getAllTarea_habilidades() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createTarea_habilidad(Tarea_habilidad tarea_habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Tarea_habilidad findByIdTarea_habilidad(long id_tarea_habilidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTarea_habilidad(long id_tarea_habilidad, Tarea_habilidad tarea_habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteTarea_habilidadById(Long id_tarea_habilidad) {
        // TODO Auto-generated method stub
        
    }

    
    /* 
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevaTarea_habilidad() {
        long id_tarea_habilidad_nueva;
        String sqlQuery = "SELECT MAX(id_tarea_habilidad) FROM tarea_habilidad";
        try (Connection con = sql2o.open()){
            id_tarea_habilidad_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_tarea_habilidad_nueva = -1;
        }
        return id_tarea_habilidad_nueva;
    }

    @Override
    public List<Tarea_habilidad> getAllTarea_habilidades() {
        List<Tarea_habilidad> tarea_habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.tarea_habilidad ORDER BY id_tarea_habilidad ASC";
        try (Connection con = sql2o.open()){
            tarea_habilidades = con.createQuery(sqlQuery).executeAndFetch(Tarea_habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return tarea_habilidades;
    }

    @Override
    public void createTarea_habilidad(Tarea_habilidad tarea_habilidad) {
        String sqlQuery = "INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_eme_habilidad) VALUES (:id_tarea_habilidad, :id_tarea, :id_eme_habilidad)";
        long id = getIdNuevaTarea_habilidad();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_tarea_habilidad", id)
            .addParameter("id_tarea", tarea_habilidad.getId_tarea())
            .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Tarea_habilidad findByIdTarea_habilidad(long id_tarea_habilidad) {
        Tarea_habilidad tarea_habilidad = null;
        String sqlQuery = "SELECT * FROM tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";
        try (Connection con = sql2o.open()){
            tarea_habilidad = (Tarea_habilidad)con.createQuery(sqlQuery).addParameter("id_tarea_habilidad", id_tarea_habilidad).executeAndFetch(Tarea_habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado//
        }
        return tarea_habilidad;
    }

    @Override
    public void updateTarea_habilidad(long id_tarea_habilidad, Tarea_habilidad tarea_habilidad) {
        String sqlQuery = "UPDATE tarea_habilidad SET id_tarea = :id_tarea, id_eme_habilidad = :id_eme_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_tarea_habilidad", id_tarea_habilidad)
            .addParameter("id_tarea", tarea_habilidad.getId_tarea())
            .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteTarea_habilidadById(Long id_tarea_habilidad) {
        String sqlQuery = "DELETE FROM tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_tarea_habilidad", id_tarea_habilidad)
            .executeUpdate();
            con.commit();
        }
    }
        */
}
