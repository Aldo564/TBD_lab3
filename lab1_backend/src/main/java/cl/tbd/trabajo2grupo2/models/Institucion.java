package cl.tbd.trabajo2grupo2.models;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("institucion")
public class Institucion {
    private Long id_institucion;
    private String nombre;
    private String direccion;

    //Constructor
    public Institucion(Long id_institucion, String nombre, String direccion){
        this.id_institucion = id_institucion;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    //Getters
    public Long getId_institucion(){
        return id_institucion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    //Setters
    public void setId_institucion(Long id_institucion){
        this.id_institucion = id_institucion;
    }

    public void setNnombre(String nombre){
        this.nombre = nombre;
    }

    public void setFecha_registro(String direccion){
        this.direccion = direccion;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Institucion [id_institucion=" + id_institucion + ", nombre_institucion=" + nombre
                + ", direccion=" + direccion + "]";
    }
}
