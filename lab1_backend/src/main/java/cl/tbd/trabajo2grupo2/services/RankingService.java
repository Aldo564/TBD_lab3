package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Ranking;
import cl.tbd.trabajo2grupo2.repositories.RankingRepository;

@RestController
@RequestMapping("/ranking")
public class RankingService {
            
    private final RankingRepository rankingRepository;
    RankingService(RankingRepository rankingRepository)
    {
        this.rankingRepository = rankingRepository;
    }

    //Obtener todos los Rankings
    @GetMapping("")
    public List<Ranking> getAllRankings(){
        return rankingRepository.getAllRankings();
    }

    //Registrar un Ranking en la base de datos
    @PostMapping("")
    public void createRanking(Ranking ranking){
        rankingRepository.createRanking(ranking);
    }

    //Obtener un Ranking por su id
    @RequestMapping(value = "/{id_ranking}", method = RequestMethod.GET)
    public Ranking getRankingById(long id_ranking){
        return rankingRepository.findByIdRanking(id_ranking);
    }

    //Actualizar un Ranking
    @RequestMapping(value = "/{id_ranking}", method = RequestMethod.PUT)
    public void updateRanking (long id_ranking, @RequestBody Ranking ranking){
        rankingRepository.updateRanking(id_ranking, ranking);
    }

    //Eliminar un Ranking
    @RequestMapping(value = "/{id_ranking}", method = RequestMethod.DELETE)
    public void deleteRankingById(@PathVariable Long id_ranking){
        rankingRepository.deleteRankingById(id_ranking);
    }
}
