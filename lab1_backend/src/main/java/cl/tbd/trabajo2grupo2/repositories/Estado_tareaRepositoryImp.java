package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import cl.tbd.trabajo2grupo2.models.Estado_tarea;
import cl.tbd.trabajo2grupo2.models.Tarea;

@Repository
public class Estado_tareaRepositoryImp implements Estado_tareaRepository{
    @Autowired
	private MongoTemplate mongo;
    
    @Override
    public Long getIdNuevoEstado_tarea() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Estado_tarea> getAllEstado_tareas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createEstado_tarea(Estado_tarea estado_tarea) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Estado_tarea findByIdEstado_tarea(Long id_estado_tarea) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateEstado_tarea(Long id_estado_tarea, Estado_tarea estado_tarea) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEstado_tareaById(Long id_estado_tarea) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Boolean> getEstadoBytarea(List<Tarea> tareas) {
        // TODO Auto-generated method stub
        return null;
    }
    /* 
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public Long getIdNuevoEstado_tarea() {
        long id_nuevoEstado_tarea;
        String sqlQuery = "SELECT MAX(id_estado_tarea) FROM estado_tarea";
        try (Connection con = sql2o.open()){
            id_nuevoEstado_tarea = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_nuevoEstado_tarea = -1;
        }
        return id_nuevoEstado_tarea;
    }

    @Override
    public List<Estado_tarea> getAllEstado_tareas() {
        List<Estado_tarea> estado_tarea_tuplas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.estado_tarea ORDER BY id_estado_tarea ASC";
        try (Connection con = sql2o.open()){
            estado_tarea_tuplas = con.createQuery(sqlQuery).executeAndFetch(Estado_tarea.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return estado_tarea_tuplas;
    }

    @Override
    public void createEstado_tarea(Estado_tarea estado_tarea) {
        String sqlQuery = "INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) VALUES (:id_estado_tarea, :id_tarea, :completada)";
        long id = getIdNuevoEstado_tarea();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_estado_tarea", id)
            .addParameter("id_tarea", estado_tarea.getId_tarea())
            .addParameter("completada", estado_tarea.isCompletada())
            .executeUpdate();
            con.commit();
        }
        
    }

    @Override
    public Estado_tarea findByIdEstado_tarea(Long id_estado_tarea) {
        Estado_tarea estado_tarea = null;
        String sqlQuery = "SELECT * FROM estado_tarea WHERE id_estado_tarea = :id_estado_tarea";
        try (Connection con = sql2o.open()){
            estado_tarea = (Estado_tarea)con.createQuery(sqlQuery).addParameter("id_estado_tarea", id_estado_tarea).executeAndFetch(Estado_tarea.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
        }
        return estado_tarea;
    }
    
    @Override
    public List<Boolean> getEstadoBytarea(List<Tarea> tareas) {
        System.out.println("Entre");
        List<Boolean> estado_tarea = new ArrayList<>();
        Boolean aux = null;
        for (Tarea tarea : tareas) 
        {
            String sqlQuery = "SELECT estado_tarea.* FROM estado_tarea WHERE estado_tarea.id_tarea = :id_tarea";
            try (Connection con = sql2o.open()){
                aux = con.createQuery(sqlQuery).addParameter("id_tarea", tarea.getId_tarea()).executeAndFetch(Boolean.class).get(0);
            } catch (Exception e) {
                // Conexion a sql ha fallado
            }
            if(aux != null)
            {
                estado_tarea.add(aux);
            }
        }
        
        return estado_tarea;
    }




    @Override
    public void updateEstado_tarea(Long id_estado_tarea, Estado_tarea estado_tarea) {
        String sqlQuery = "UPDATE estado_tarea SET id_tarea = :id_tarea, completada = :completada WHERE id_estado_tarea = :id_estado_tarea";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_estado_tarea", id_estado_tarea)
            .addParameter("id_tarea", estado_tarea.getId_tarea())
            .addParameter("completada", estado_tarea.isCompletada())
            .executeUpdate();
            con.commit();
        }
        
    }

    @Override
    public void deleteEstado_tareaById(Long id_estado_tarea) {
        String sqlQuery = "DELETE FROM estado_tarea WHERE id_estado_tarea = :id_estado_tarea";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_estado_tarea", id_estado_tarea)
            .executeUpdate();
            con.commit();
        }
    }
    */
}
