package cl.tbd.trabajo2grupo2.repositories;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;

import cl.tbd.trabajo2grupo2.models.Voluntario;

public interface VoluntarioRepository {
    public long getIdNuevoVoluntario();
    public List<Voluntario> getAllVoluntarios();
    public void createVoluntario(Voluntario voluntario);
    public Voluntario findByIdVoluntario(long id_voluntario);
    public void updateVoluntario(long id_voluntario, Voluntario voluntario);
    public void deleteVoluntarioById(Long id_voluntario);
    public AggregateIterable<Document> getTotalHabilidadesVoluntarioPorComuna();
}
