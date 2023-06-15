package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import cl.tbd.trabajo2grupo2.models.Eme_habilidad;

public interface Eme_habilidadRepository {

    public Long getIdNuevaEme_habilidad();
    public List<Eme_habilidad> getAllEme_habilidades();
    public void createEme_habilidad(Eme_habilidad eme_habilidad);
    public Eme_habilidad findByIdEme_habilidad(Long id_eme_habilidad);
    public void updateEme_habilidad(Long id_eme_habilidad, Eme_habilidad eme_habilidad);
    public void deleteEme_habilidadById(Long id_eme_habilidad);
    
}
