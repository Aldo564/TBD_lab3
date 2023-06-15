package cl.tbd.trabajo2grupo2.models;

import javax.persistence.*;

@Entity
@Table(name ="ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ranking;
    private Integer id_voluntario;
    private Integer id_tarea;
    private Integer puntaje;

    //Constructor
    public Ranking(Long id_ranking, Integer id_voluntario, Integer id_tarea, Integer puntaje){
        this.id_ranking = id_ranking;
        this.id_voluntario = id_voluntario;
        this.id_tarea = id_tarea;
        this.puntaje = puntaje;
    }

    //Getters
    public Long getId_ranking(){
        return id_ranking;
    }

    public Integer getId_voluntario(){
        return id_voluntario;
    }

    public Integer getId_tarea(){
        return id_tarea;
    }

    public Integer getPuntaje() {
        return puntaje;
    }
    //Setters
    public void setId_ranking(Long id_ranking){
        this.id_ranking = id_ranking;
    }

    public void setId_voluntario(Integer id_voluntario){
        this.id_voluntario = id_voluntario;
    }

    public void setId_tarea(Integer id_tarea){
        this.id_tarea = id_tarea;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    //TOSTRING
    @Override
    public String toString() {
        return "Ranking [id_ranking=" + id_ranking + ", id_voluntario=" + id_voluntario
                + ", id_tarea=" + id_tarea + ", puntaje=" + puntaje + "]";
    }
}
