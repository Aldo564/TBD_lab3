package cl.tbd.trabajo2grupo2.models;

import javax.persistence.*;

@Entity
@Table(name ="eme_habilidad")
public class Eme_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_eme_habilidad;
    private Integer id_emergencia;
    private Integer id_habilidad;

    //Constructor
    public Eme_habilidad(Long id_eme_habilidad, Integer id_emergencia, Integer id_habilidad){
        this.id_eme_habilidad = id_eme_habilidad;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    //Getter
    public Long getId_eme_habilidad(){
        return id_eme_habilidad;
    }

    public Integer getId_emergencia(){
        return id_emergencia;
    }
    
    public Integer getId_habilidad(){
        return id_habilidad;
    }

    //Setter
    public void setId_eme_habilidad(Long id_eme_habilidad){
        this.id_eme_habilidad = id_eme_habilidad;
    }

    public void  setId_emergencia(Integer id_emergencia){
        this.id_emergencia = id_emergencia;
    }

    public void setId_habilidad(Integer id_habilidad){
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Eme_habilidad [id_eme_habilidad=" + id_eme_habilidad + ", id_emergencia=" + id_emergencia
                + ", id_habilidad=" + id_habilidad + "]";
    }

    
}
