package cl.tbd.trabajo2grupo2.repositories;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import cl.tbd.trabajo2grupo2.models.Ranking;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
	private MongoTemplate mongo;

    @Override
    public long getIdNuevoRanking() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Ranking> getAllRankings() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createRanking(Ranking ranking) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Ranking findByIdRanking(long id_ranking) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateRanking(long id_ranking, Ranking ranking) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteRankingById(Long id_ranking) {
        // TODO Auto-generated method stub
        
    }

    

    /* 
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevoRanking() {
        long id_ranking_nuevo;
        String sqlQuery = "SELECT MAX(id_ranking) FROM ranking";
        try (Connection con = sql2o.open()){
            id_ranking_nuevo = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_ranking_nuevo = -1;
        }
        return id_ranking_nuevo;
    }

    @Override
    public List<Ranking> getAllRankings() {
        List<Ranking> rankings = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.ranking ORDER BY id_ranking ASC";
        try (Connection con = sql2o.open()){
            rankings = con.createQuery(sqlQuery).executeAndFetch(Ranking.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return rankings;
    }

    @Override
    public void createRanking(Ranking ranking) {
        String sqlQuery = "INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntaje_ranking) VALUES (:id_ranking, :id_voluntario, :id_tarea, :puntaje_ranking)";
        long id = getIdNuevoRanking();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_ranking", id)
            .addParameter("id_voluntario", ranking.getId_voluntario())
            .addParameter("id_tarea", ranking.getId_tarea())
            .addParameter("puntaje_ranking", ranking.getPuntaje())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Ranking findByIdRanking(long id_ranking) {
        Ranking ranking = null;
        String sqlQuery = "SELECT * FROM ranking WHERE id_ranking = :id_ranking";
        try (Connection con = sql2o.open()){
            ranking = (Ranking)con.createQuery(sqlQuery).addParameter("id_ranking", id_ranking).executeAndFetch(Ranking.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado//
        }
        return ranking;
    }

    @Override
    public void updateRanking(long id_ranking, Ranking ranking) {
        String sqlQuery = "UPDATE ranking SET id_voluntario = :id_voluntario, id_tarea = :id_tarea, puntaje_ranking = :puntaje_ranking WHERE id_ranking = :id_ranking";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_ranking", id_ranking)
            .addParameter("id_voluntario", ranking.getId_voluntario())
            .addParameter("id_tarea", ranking.getId_tarea())
            .addParameter("puntaje_ranking", ranking.getPuntaje())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteRankingById(Long id_ranking) {
        String sqlQuery = "DELETE FROM ranking WHERE id_ranking = :id_ranking";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_ranking", id_ranking)
            .executeUpdate();
            con.commit();
        }
    }
    */
}
