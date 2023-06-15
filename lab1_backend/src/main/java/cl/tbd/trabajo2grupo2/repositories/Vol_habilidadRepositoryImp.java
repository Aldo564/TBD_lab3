package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import cl.tbd.trabajo2grupo2.models.Vol_habilidad;

@Repository
public class Vol_habilidadRepositoryImp implements Vol_habilidadRepository{
    @Autowired
	private MongoTemplate mongo;

    @Override
    public long getIdNuevoVol_habilidad() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Vol_habilidad> getAllVol_habilidades() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createVol_habilidad(Vol_habilidad voluntario) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Vol_habilidad findByIdVol_habilidad(long id_vol_habilidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateVol_habilidad(long id_vol_habilidad, Vol_habilidad vol_habilidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteVol_habilidadById(Long id_vol_habilidad) {
        // TODO Auto-generated method stub
        
    }

    /* 
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public long getIdNuevoVol_habilidad() {
        long id_nuevoVol_habilidad;
        String sqlQuery = "SELECT MAX(id_vol_habilidad) FROM vol_habilidad";
        try (Connection con = sql2o.open()){
            id_nuevoVol_habilidad = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_nuevoVol_habilidad = -1;
        }
        return id_nuevoVol_habilidad;
    }

    @Override
    public List<Vol_habilidad> getAllVol_habilidades() {
        List<Vol_habilidad> vol_habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.vol_habilidad ORDER BY id_vol_habilidad ASC";
        try (Connection con = sql2o.open()){
            vol_habilidades = con.createQuery(sqlQuery).executeAndFetch(Vol_habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return vol_habilidades;
    }

    @Override
    public void createVol_habilidad(Vol_habilidad vol_habilidad) {
        String sqlQuery = "INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (:id_vol_habilidad, :id_voluntario, :id_habilidad)";
        long id = getIdNuevoVol_habilidad();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_vol_habilidad", id)
            .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
            .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Vol_habilidad findByIdVol_habilidad(long id_vol_habilidad){
        Vol_habilidad vol_habilidad = null;
        String sqlQuery = "SELECT * FROM vol_habilidad WHERE id_vol_habilidad = :id_vol_habilidad";
        try (Connection con = sql2o.open()){
            vol_habilidad = (Vol_habilidad)con.createQuery(sqlQuery).addParameter("id_vol_habilidad", id_vol_habilidad).executeAndFetch(Vol_habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
        }
        return vol_habilidad;
    }

    @Override
    public void updateVol_habilidad(long id_vol_habilidad, Vol_habilidad vol_habilidad) {
        String sqlQuery = "UPDATE vol_habilidad SET id_voluntario = :id_voluntario, id_habilidad = :id_habilidad WHERE id_vol_habilidad = :id_vol_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_vol_habilidad", id_vol_habilidad)
            .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
            .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteVol_habilidadById(Long id_vol_habilidad) {
        String sqlQuery = "DELETE FROM vol_habilidad WHERE id_vol_habilidad = :id_vol_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_vol_habilidad", id_vol_habilidad)
            .executeUpdate();
            con.commit();
        }
    }*/
}