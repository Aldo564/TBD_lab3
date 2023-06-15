package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import cl.tbd.trabajo2grupo2.models.Habilidad;

public interface HabilidadRepository {
    public long getIdNuevaHabilidad();
    public List<Habilidad> getAllHabilidades();
    public void createHabilidad(Habilidad habilidad);
    public Habilidad findByIdHabilidad(long id_habilidad);
    public void updateHabilidad(long id_habilidad, Habilidad habilidad);
    public void deleteHabilidadById(Long id_habilidad);
    
}
