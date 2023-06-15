package cl.tbd.trabajo2grupo2.repositories;
import java.util.List;

import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import cl.tbd.trabajo2grupo2.models.Emergencia;

public interface EmergenciaRepository
{
    public Long getIdNuevaEmergencia();
    public List<Emergencia> getAllEmergencias();
    public void createEmergencia(Emergencia emergencia);
    public Emergencia findByIdEmergencia(Long id_emergencia);
    public void updateEmergencia(Long id_emergencia, Emergencia emergencia);
    public void deleteEmergenciaById(Long id_emergencia);
    public AggregateIterable<Document> obtenerVoluntariosEmergenciasEnRadioR(Double R);
}
