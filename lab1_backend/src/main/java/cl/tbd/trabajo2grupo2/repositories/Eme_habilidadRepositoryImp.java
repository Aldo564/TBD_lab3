package cl.tbd.trabajo2grupo2.repositories;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import cl.tbd.trabajo2grupo2.models.Eme_habilidad;

@Repository
public class Eme_habilidadRepositoryImp implements Eme_habilidadRepository{
    @Autowired
	private MongoTemplate mongo;

    @Override
    public Long getIdNuevaEme_habilidad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Eme_habilidad> getAllEme_habilidades() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createEme_habilidad(Eme_habilidad eme_habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Eme_habilidad findByIdEme_habilidad(Long id_eme_habilidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateEme_habilidad(Long id_eme_habilidad, Eme_habilidad eme_habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEme_habilidadById(Long id_eme_habilidad) {
        // TODO Auto-generated method stub
        
    }
    /* 
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long getIdNuevaEme_habilidad() {
        Long id_eme_habilidad_nueva;
        String sqlQuery = "SELECT MAX(id_eme_habilidad) FROM eme_habilidad";
        try (Connection con = sql2o.open()){
            id_eme_habilidad_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_eme_habilidad_nueva = (long) -1;
        }
        return id_eme_habilidad_nueva;
    }

    @Override
    public List<Eme_habilidad> getAllEme_habilidades() {
        List<Eme_habilidad> eme_habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.eme_habilidad ORDER BY id_eme_habilidad ASC";
        try (Connection con = sql2o.open()){
            eme_habilidades = con.createQuery(sqlQuery).executeAndFetch(Eme_habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return eme_habilidades;
    }

    @Override
    public void createEme_habilidad(Eme_habilidad eme_habilidad) {
        String sqlQuery = "INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (:id_eme_habilidad, :id_emergencia, :id_habilidad)";
        Long id = getIdNuevaEme_habilidad();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_eme_habilidad", id)
            .addParameter("id_emergencia", eme_habilidad.getId_emergencia())
            .addParameter("id_habilidad", eme_habilidad.getId_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Eme_habilidad findByIdEme_habilidad(Long id_eme_habilidad) {
        Eme_habilidad eme_habilidad = null;
        String sqlQuery = "SELECT * FROM eme_habilidad WHERE id_eme_habilidad = :id_eme_habilidad";
        try (Connection con = sql2o.open()){
            eme_habilidad = (Eme_habilidad)con.createQuery(sqlQuery).addParameter("id_eme_habilidad", id_eme_habilidad).executeAndFetch(Eme_habilidad.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return eme_habilidad;
    }

    @Override
    public void updateEme_habilidad(Long id_eme_habilidad, Eme_habilidad eme_habilidad) {
        String sqlQuery = "UPDATE eme_habilidad SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad WHERE id_eme_habilidad = :id_eme_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_eme_habilidad", id_eme_habilidad)
            .addParameter("id_emergencia", eme_habilidad.getId_emergencia())
            .addParameter("id_habilidad", eme_habilidad.getId_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteEme_habilidadById(Long id_eme_habilidad) {
        String sqlQuery = "DELETE FROM eme_habilidad WHERE id_eme_habilidad = :id_eme_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_eme_habilildad", id_eme_habilidad)
            .executeUpdate();
            con.commit();
        }
    }*/
}
