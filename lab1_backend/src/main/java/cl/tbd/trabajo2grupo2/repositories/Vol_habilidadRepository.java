package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;
import cl.tbd.trabajo2grupo2.models.Vol_habilidad;

public interface Vol_habilidadRepository {
    public long getIdNuevoVol_habilidad();
    public List<Vol_habilidad> getAllVol_habilidades();
    public void createVol_habilidad(Vol_habilidad voluntario);
    public Vol_habilidad findByIdVol_habilidad(long id_vol_habilidad);
    public void updateVol_habilidad(long id_vol_habilidad, Vol_habilidad vol_habilidad);
    public void deleteVol_habilidadById(Long id_vol_habilidad);
    
}
