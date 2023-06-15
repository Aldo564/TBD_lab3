package cl.tbd.trabajo2grupo2.models;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("habilidad")
public class Habilidad {
    private Long id_habilidad;
    private String descripcion;
    private String codigo;

    public Habilidad(Long id_habilidad, String descripcion, String codigo) {
        this.id_habilidad = id_habilidad;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public Long getId_habilidad() {
        return id_habilidad;
    }
    public void setId_habilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString(){
        return "Habilidad [id_habilidad=" + id_habilidad + ", descripcion=" + descripcion + ", codigo="+ codigo + "]";
    }
}
