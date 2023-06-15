package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import cl.tbd.trabajo2grupo2.models.Ranking;

public interface RankingRepository {
    public long getIdNuevoRanking();
    public List<Ranking> getAllRankings();
    public void createRanking(Ranking ranking);
    public Ranking findByIdRanking(long id_ranking);
    public void updateRanking(long id_ranking, Ranking ranking);
    public void deleteRankingById(Long id_ranking);
    
}
