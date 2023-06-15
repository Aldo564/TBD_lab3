package cl.tbd.trabajo2grupo2.models;

import javax.persistence.*;

@Entity
@Table(name ="vol_habilidad")
public class Vol_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vol_habilidad;
    private Integer id_voluntario;
    private Integer id_habilidad;

    //Constructor
    public Vol_habilidad(Long id_vol_habilidad, Integer id_voluntario, Integer id_habilidad){
        this.id_vol_habilidad = id_vol_habilidad;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    //Getters
    public Long getId_vol_habilidad(){
        return id_vol_habilidad;
    }

    public Integer getId_voluntario(){
        return id_voluntario;
    }

    public Integer getId_habilidad(){
        return id_habilidad;
    }

    //Setters
    public void setId_vol_habilidad(Long id_vol_habilidad){
        this.id_vol_habilidad = id_vol_habilidad;
    }

    public void setId_voluntario(Integer id_voluntario){
        this.id_voluntario = id_voluntario;
    }

    public void setId_vol_habilidad(Integer id_habilidad){
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING extension
    @Override
    public String toString() {
        return "Vol_habilidad [id_vol_habilidad=" + id_vol_habilidad + ", id_voluntario=" + id_voluntario
                + ", id_habilidad=" + id_habilidad + "]";
    }

    

}
