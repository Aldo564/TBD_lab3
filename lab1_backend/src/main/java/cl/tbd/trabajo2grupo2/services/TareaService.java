package cl.tbd.trabajo2grupo2.services;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Tarea;
import cl.tbd.trabajo2grupo2.repositories.TareaRepository;

@RestController
@RequestMapping("/tarea")
public class TareaService {

    private final TareaRepository tareaRepository;
    TareaService(TareaRepository tareaRepository)
    {
        this.tareaRepository = tareaRepository;
    }

    //Obtener todas las tareas
    @GetMapping("")
    public List<Tarea> getAllTareas(){
        return tareaRepository.getAllTareas();
    }

    //Registrar una tarea en la base de datos
    @PostMapping("")
    public void createTarea(Tarea tarea){
        tareaRepository.createTarea(tarea);
    }

    //Obtener una tarea por su id
    @RequestMapping(value = "/{id_tarea}", method = RequestMethod.GET)
    public Tarea getTareaById(long id_tarea){
        return tareaRepository.findByIdTarea(id_tarea);
    }

    //Obtener todas las tareas dadas un id_emergencia
    @RequestMapping(value = "/getTareasByIdEmergencia/{id_emergencia}", method = RequestMethod.GET)
    public List<Tarea> getTareasByIdEmergencia(long id_emergencia){
        return tareaRepository.getTareasByIdEmergencia(id_emergencia);
    }

    //Actualizar una tarea
    @RequestMapping(value = "/{id_tarea}", method = RequestMethod.PUT)
    public void updateTarea(long id_tarea, @RequestBody Tarea tarea){
        tareaRepository.updateTarea(id_tarea, tarea);
    }

    //Eliminar una tarea
    @RequestMapping(value = "/{id_tarea}", method = RequestMethod.DELETE)
    public void deleteTareaById(@PathVariable Long id_tarea){
        tareaRepository.deleteTareaById(id_tarea);
    }
}