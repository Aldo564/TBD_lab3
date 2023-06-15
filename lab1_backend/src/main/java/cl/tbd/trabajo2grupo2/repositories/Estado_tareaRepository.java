package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import cl.tbd.trabajo2grupo2.models.Estado_tarea;
import cl.tbd.trabajo2grupo2.models.Tarea;

public interface Estado_tareaRepository {
    public Long getIdNuevoEstado_tarea();
    public List<Estado_tarea> getAllEstado_tareas();
    public void createEstado_tarea(Estado_tarea estado_tarea);
    public Estado_tarea findByIdEstado_tarea(Long id_estado_tarea);
    public void updateEstado_tarea(Long id_estado_tarea, Estado_tarea estado_tarea);
    public void deleteEstado_tareaById(Long id_estado_tarea);
    public List<Boolean> getEstadoBytarea(@RequestBody List<Tarea> tareas);
}
