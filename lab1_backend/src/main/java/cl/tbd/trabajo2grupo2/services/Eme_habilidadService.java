package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Eme_habilidad;
import cl.tbd.trabajo2grupo2.repositories.Eme_habilidadRepository;

@RestController
@RequestMapping("/eme_habilidad")
public class Eme_habilidadService {

    private final Eme_habilidadRepository eme_habilidadRepository;
    Eme_habilidadService(Eme_habilidadRepository eme_habilidadRepository)
    {
        this.eme_habilidadRepository = eme_habilidadRepository;
    }

    //Obtener todos las eme_habilidad
    @GetMapping("")
    public List<Eme_habilidad> getAllEme_habilidades(){
        return eme_habilidadRepository.getAllEme_habilidades();
    }

    //Registrar una eme_habilidad en la base de datos
    @PostMapping("")
    public void createEme_habilidad(Eme_habilidad eme_habilidad){
        eme_habilidadRepository.createEme_habilidad(eme_habilidad);
    }

    //Obtener una eme_habilidad por su id
    @GetMapping("/{id_eme_habilidad}")
    public Eme_habilidad getEme_habilidadById(Long id_eme_habilidad){
        return eme_habilidadRepository.findByIdEme_habilidad(id_eme_habilidad);
    }

    //Actualizar una eme_habilidad
    @PutMapping("/{id_eme_habilidad}")
    public void updateEme_habilidad (Long id_eme_habilidad, @RequestBody Eme_habilidad eme_habilidad){
        eme_habilidadRepository.updateEme_habilidad(id_eme_habilidad, eme_habilidad);
    }

    //Eliminar una eme_habilidad
    @DeleteMapping("/{id_eme_habilidad}")
    public void deleteEme_habilidadById(@PathVariable Long id_eme_habilidad){
        eme_habilidadRepository.deleteEme_habilidadById(id_eme_habilidad);
    }
}
