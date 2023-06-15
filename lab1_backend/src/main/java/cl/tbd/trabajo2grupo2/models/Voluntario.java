package cl.tbd.trabajo2grupo2.models;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("voluntario")
public class Voluntario {
    @Id
    private String id;
    private Long id_voluntario;
    private String nombre;
    private String fecha_registro;
    private Float longitud;
    private Float latitud;
    private String ubicacion;
    private ArrayList<Habilidad> habilidades;

    public Voluntario(String id, Long id_voluntario, String nombre, String fecha_registro, Float latitud, Float longitud,
            String ubicacion, ArrayList<Habilidad> habilidades) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.nombre = nombre;
        this.fecha_registro = fecha_registro;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ubicacion = ubicacion;
        this.habilidades = habilidades;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Long getId_voluntario() {
        return id_voluntario;
    }
    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    public Float getLatitud() {
        return latitud;
    }
    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }
    public Float getLongitud() {
        return longitud;
    }
    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
    
    @Override
    public String toString() {
        return "Voluntario [id=" + id + ", id_voluntario=" + id_voluntario + ", nombre=" + nombre + ", fecha_registro="
                + fecha_registro + ", latitud=" + latitud + ", longitud=" + longitud + ", ubicacion=" + ubicacion + ", habilidades=" + habilidades + "]";
    }
}
