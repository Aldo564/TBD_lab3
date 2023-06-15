package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;
import cl.tbd.trabajo2grupo2.models.Tarea;

public interface TareaRepository {
    public long getIdNuevaTarea();
    public List<Tarea> getAllTareas();
    public void createTarea(Tarea tarea);
    public Tarea findByIdTarea(long id_tarea);
    public void updateTarea(long id_tarea, Tarea tarea);
    public void deleteTareaById(long id_tarea);
    public List<Tarea> getTareasByIdEmergencia(Long id_emergencia);
}
