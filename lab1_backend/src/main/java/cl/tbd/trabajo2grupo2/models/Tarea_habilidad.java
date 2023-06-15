package cl.tbd.trabajo2grupo2.models;

import javax.persistence.*;

@Entity
@Table(name ="tarea_habilidad")
public class Tarea_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarea_habilidad;
    private Integer id_tarea;
    private Integer id_eme_habilidad;

    //Constructor
    public Tarea_habilidad(Long id_tarea_habilidad, Integer id_tarea, Integer id_eme_habilidad){
        this.id_tarea_habilidad = id_tarea_habilidad;
        this.id_tarea = id_tarea;
        this.id_eme_habilidad = id_eme_habilidad;
    }

    //Getters
    public Long getId_tarea_habilidad(){
        return id_tarea_habilidad;
    }

    public Integer getId_tarea(){
        return id_tarea;
    }

    public Integer getId_eme_habilidad(){
        return id_eme_habilidad;
    }

    //Setters
    public void setId_tarea_habilidad(Long id_tarea_habilidad){
        this.id_tarea_habilidad = id_tarea_habilidad;
    }

    public void setId_tarea(Integer id_tarea){
        this.id_tarea = id_tarea;
    }

    public void setId_eme_habilidad(Integer id_eme_habilidad){
        this.id_eme_habilidad = id_eme_habilidad;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Tarea_habilidad [id_tarea_habilidad=" + id_tarea_habilidad + ", id_tarea=" + id_tarea
                + ", id_eme_habilidad=" + id_eme_habilidad + "]";
    }

    

}
