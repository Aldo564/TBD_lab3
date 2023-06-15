package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import cl.tbd.trabajo2grupo2.models.Tarea_habilidad;

public interface Tarea_habilidadRepository {
    public long getIdNuevaTarea_habilidad();
    public List<Tarea_habilidad> getAllTarea_habilidades();
    public void createTarea_habilidad(Tarea_habilidad tarea_habilidad);
    public Tarea_habilidad findByIdTarea_habilidad(long id_tarea_habilidad);
    public void updateTarea_habilidad(long id_tarea_habilidad, Tarea_habilidad tarea_habilidad);
    public void deleteTarea_habilidadById(Long id_tarea_habilidad);
    
}
