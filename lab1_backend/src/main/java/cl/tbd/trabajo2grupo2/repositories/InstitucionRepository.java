package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import cl.tbd.trabajo2grupo2.models.Institucion;

public interface InstitucionRepository {
    public long getIdNuevaInstitucion();
    public List<Institucion> getAllInstituciones();
    public void createInstitucion(Institucion institucion);
    public Institucion findByIdInstitucion(long id_institucion);
    public void updateInstitucion(long id_institucion, Institucion institucion);
    public void deleteInstitucionById(Long id_institucion);
    
}
