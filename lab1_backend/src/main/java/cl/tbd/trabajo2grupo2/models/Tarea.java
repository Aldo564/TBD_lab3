package cl.tbd.trabajo2grupo2.models;
import javax.persistence.*;

@Entity
@Table(name="tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarea;
    private String asunto_tarea;
    private int id_emergencia;
    private int id_estado_tarea;

    //CONSTRUCTOR
    public Tarea(Long id_tarea, String asunto_tarea, int id_emergencia, int id_estado_tarea) {
        this.id_tarea = id_tarea;
        this.asunto_tarea = asunto_tarea;
        this.id_emergencia = id_emergencia;
        this.id_estado_tarea = id_estado_tarea;
    }

    //GETTERS
    public Long getId_tarea() {
        return id_tarea;
    }

    public String getAsunto_tarea() {
        return asunto_tarea;
    }

    public int getId_emergencia() {
        return id_emergencia;
    }

    public int getId_estado_tarea() {
        return id_estado_tarea;
    }
    
    //SETTERS
    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }
    
    public void setAsunto_tarea(String asunto_tarea) {
        this.asunto_tarea = asunto_tarea;
    }
    
    public void setId_emergencia(int id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    
    public void setId_estado_tarea(int id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }
}
