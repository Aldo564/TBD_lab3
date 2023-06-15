package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Habilidad;
import cl.tbd.trabajo2grupo2.repositories.HabilidadRepository;

@RestController
@RequestMapping("/habilidad")
public class HabilidadService {
        
    private final HabilidadRepository habilidadRepository;
    HabilidadService(HabilidadRepository habilidadRepository)
    {
        this.habilidadRepository = habilidadRepository;
    }

    //Obtener todas las Habilidades
    @GetMapping("")
    public List<Habilidad> getAllHabilidades(){
        return habilidadRepository.getAllHabilidades();
    }

    //Registrar una Habilidad en la base de datos
    @PostMapping("")
    public void createHabilidad(Habilidad habilidad){
        habilidadRepository.createHabilidad(habilidad);
    }

    //Obtener una Habilidad por su id
    @RequestMapping(value = "/{id_habilidad}", method = RequestMethod.GET)
    public Habilidad getHabilidadById(long id_habilidad){
        return habilidadRepository.findByIdHabilidad(id_habilidad);
    }

    //Actualizar una Habilidad
    @RequestMapping(value = "/{id_habilidad}", method = RequestMethod.PUT)
    public void updateHabilidad (long id_habilidad, @RequestBody Habilidad habilidad){
        habilidadRepository.updateHabilidad(id_habilidad, habilidad);
    }

    //Eliminar una Habilidad
    @RequestMapping(value = "/{id_habilidad}", method = RequestMethod.DELETE)
    public void deleteHabilidadById(@PathVariable Long id_habilidad){
        habilidadRepository.deleteHabilidadById(id_habilidad);
    }
}
