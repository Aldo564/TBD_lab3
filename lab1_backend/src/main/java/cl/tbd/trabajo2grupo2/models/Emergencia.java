package cl.tbd.trabajo2grupo2.models;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("emergencia")
public class Emergencia {
    @Id
    private String id;
    private Long id_emergencia;
    private String asunto;
    private String descripcion;
    private String direccion;
    private String fecha;
    private Boolean activa;
    private Institucion institucion;
    private Float latitud;
    private Float longitud;
    private String ubicacion;
    private ArrayList<Habilidad> habilidades;

    public Emergencia(String id, Long id_emergencia, String asunto, String descripcion, String direccion, String fecha,
            Boolean activa, Institucion institucion, Float latitud, Float longitud, String ubicacion,
            ArrayList<Habilidad> habilidades) {
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.fecha = fecha;
        this.activa = activa;
        this.institucion = institucion;
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
    public Long getId_emergencia() {
        return id_emergencia;
    }
    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Boolean getActiva() {
        return activa;
    }
    public void setActiva(Boolean activa) {
        this.activa = activa;
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
    public Institucion getInstitucion() {
        return institucion;
    }
    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return "Emergencia [id=" + id + ", id_emergencia=" + id_emergencia + ", asunto=" + asunto + ", descripcion="
                + descripcion + ", direccion=" + direccion + ", fecha=" + fecha + ", activa=" + activa
                + ", institucion=" + institucion + ", latitud=" + latitud + ", longitud=" + longitud + ", ubicacion="
                + ubicacion + ", habilidades=" + habilidades + "]";
    }
}