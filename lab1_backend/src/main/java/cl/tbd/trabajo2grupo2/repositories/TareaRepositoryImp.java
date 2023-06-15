package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import cl.tbd.trabajo2grupo2.models.Tarea;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
	private MongoTemplate mongo;

    @Override
    public long getIdNuevaTarea() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Tarea> getAllTareas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createTarea(Tarea tarea) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Tarea findByIdTarea(long id_tarea) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTarea(long id_tarea, Tarea tarea) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteTareaById(long id_tarea) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Tarea> getTareasByIdEmergencia(Long id_emergencia) {
        // TODO Auto-generated method stub
        return null;
    }

    
    /* 
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevaTarea() {
        long id_tarea_nueva;
        String sqlQuery = "SELECT MAX(id_tarea) FROM tarea";
        try (Connection con = sql2o.open()){
            id_tarea_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_tarea_nueva = -1;
        }
        return id_tarea_nueva;
    }

    @Override
    public List<Tarea> getAllTareas() {
        List<Tarea> tareas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.tarea ORDER BY id_tarea ASC";
        try (Connection con = sql2o.open()){
            tareas = con.createQuery(sqlQuery).executeAndFetch(Tarea.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return tareas;
    }

    
    @Override
    public List<Tarea> getTareasByIdEmergencia(Long id_emergencia) {
        List<Tarea> tareas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM tarea WHERE tarea.id_emergencia = :id_emergencia";
        try (Connection con = sql2o.open()){
            tareas = con.createQuery(sqlQuery).addParameter("id_emergencia", id_emergencia).executeAndFetch(Tarea.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return tareas;
    }
    

    @Override
    public void createTarea(Tarea tarea) {
        String sqlQuery = "INSERT INTO tarea (id_tarea, asunto_tarea, id_tarea, id_estado_tarea) VALUES (:id_tarea, :asunto_tarea, :id_tarea, :id_estado_tarea)";
        long id = getIdNuevaTarea();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_tarea", id)
            .addParameter("asunto_tarea", tarea.getAsunto_tarea())
            .addParameter("id_tarea", tarea.getId_tarea())
            .addParameter("id_estado_tarea", tarea.getId_estado_tarea())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Tarea findByIdTarea(long id_tarea) {
        Tarea tarea = null;
        String sqlQuery = "SELECT * FROM tareas WHERE id_tarea = :id_tarea";
        try (Connection con = sql2o.open()){
            tarea = (Tarea)con.createQuery(sqlQuery).addParameter("id_tarea", id_tarea).executeAndFetch(Tarea.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
        }
        return tarea;
    }

    @Override
    public void updateTarea(long id_tarea, Tarea tarea) {
        String sqlQuery = "UPDATE tarea SET asunto_tarea = :asunto_tarea, id_emergencia= :id_emergencia, id_estado_tarea = :id_estado_tarea WHERE id_tarea = :id_tarea";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_tarea", id_tarea)
            .addParameter("asunto_tarea", tarea.getAsunto_tarea())
            .addParameter("id_emergencia", tarea.getId_emergencia())
            .addParameter("id_estado_tarea", tarea.getId_estado_tarea())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteTareaById(long id_tarea) {
        String sqlQuery = "DELETE FROM tarea WHERE id_tarea = :id_tarea";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_tarea", id_tarea)
            .executeUpdate();
            con.commit();
        }
    }*/
}
