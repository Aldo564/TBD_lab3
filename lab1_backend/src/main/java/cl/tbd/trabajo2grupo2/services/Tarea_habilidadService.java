package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Tarea_habilidad;
import cl.tbd.trabajo2grupo2.repositories.Tarea_habilidadRepository;

@RestController
@RequestMapping("/tarea_habilidad")
public class Tarea_habilidadService {
            
    private final Tarea_habilidadRepository tarea_habilidadRepository;
    Tarea_habilidadService(Tarea_habilidadRepository tarea_habilidadRepository)
    {
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    //Obtener todas las Tarea_habilidades
    @GetMapping("")
    public List<Tarea_habilidad> getAllTarea_habilidades(){
        return tarea_habilidadRepository.getAllTarea_habilidades();
    }

    //Registrar una Tarea_habilidad en la base de datos
    @PostMapping("")
    public void createTarea_habilidad(Tarea_habilidad tarea_habilidad){
        tarea_habilidadRepository.createTarea_habilidad(tarea_habilidad);
    }

    //Obtener una Tarea_habilidad por su id
    @RequestMapping(value = "/{id_tarea_habilidad}", method = RequestMethod.GET)
    public Tarea_habilidad getTarea_habilidadById(long id_tarea_habilidad){
        return tarea_habilidadRepository.findByIdTarea_habilidad(id_tarea_habilidad);
    }

    //Actualizar una Tarea_habilidad
    @RequestMapping(value = "/{id_tarea_habilidad}", method = RequestMethod.PUT)
    public void updateTarea_habilidad (long id_tarea_habilidad, @RequestBody Tarea_habilidad tarea_habilidad){
        tarea_habilidadRepository.updateTarea_habilidad(id_tarea_habilidad, tarea_habilidad);
    }

    //Eliminar una Tarea_habilidad
    @RequestMapping(value = "/{id_tarea_habilidad}", method = RequestMethod.DELETE)
    public void deleteTarea_habilidadById(@PathVariable Long id_tarea_habilidad){
        tarea_habilidadRepository.deleteTarea_habilidadById(id_tarea_habilidad);
    }    
}
