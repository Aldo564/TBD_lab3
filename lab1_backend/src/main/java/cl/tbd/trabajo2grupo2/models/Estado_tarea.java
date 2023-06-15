package cl.tbd.trabajo2grupo2.models;
import javax.persistence.*;

@Entity
@Table(name="estado_tarea")
public class Estado_tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado_tarea;
    private int id_tarea;
    private boolean completada;

    //CONSTRUCTOR
    public Estado_tarea(Long id_estado_tarea, int id_tarea, boolean completada) {
        this.id_estado_tarea = id_estado_tarea;
        this.id_tarea = id_tarea;
        this.completada = completada;
    }

    //GETTERS
    public Long getId_estado_tarea() {
        return id_estado_tarea;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public boolean isCompletada() {
        return completada;
    }

    //SETTERS
    public void setId_estado_tarea(Long id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
