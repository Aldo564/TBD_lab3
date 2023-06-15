package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Estado_tarea;
import cl.tbd.trabajo2grupo2.models.Tarea;
import cl.tbd.trabajo2grupo2.repositories.Estado_tareaRepository;

@RestController
@RequestMapping("/estado_tarea")
public class Estado_tareaService {
    
    private final Estado_tareaRepository estado_tareaRepository;
    Estado_tareaService(Estado_tareaRepository estado_tareaRepository)
    {
        this.estado_tareaRepository = estado_tareaRepository;
    }

    //Obtener todas las Estado_tareas
    @GetMapping("")
    public List<Estado_tarea> getAllEstado_tareas(){
        return estado_tareaRepository.getAllEstado_tareas();
    }

    //Registrar una Estado_tarea en la base de datos
    @PostMapping("")
    public void createEstado_tarea(Estado_tarea estado_tarea){
        estado_tareaRepository.createEstado_tarea(estado_tarea);
    }

    //Obtener una Estado_tarea por su id
    @RequestMapping(value = "/{id_estado_tarea}", method = RequestMethod.GET)
    public Estado_tarea getEstado_tareaById(long id_estado_tarea){
        return estado_tareaRepository.findByIdEstado_tarea(id_estado_tarea);
    }

    //Obtener lista de estado_tarea segun las tareas entregadas
    @RequestMapping(value = "/getEstadoBytarea", method = RequestMethod.GET)
    public List<Boolean> getEstadoBytarea(@RequestBody List<Tarea> tareas){
        return estado_tareaRepository.getEstadoBytarea(tareas);
    }

    //Actualizar un Estado_tarea
    @RequestMapping(value = "/{id_estado_tarea}", method = RequestMethod.PUT)
    public void updateEstado_tarea (long id_estado_tarea, Estado_tarea estado_tarea){
        estado_tareaRepository.updateEstado_tarea(id_estado_tarea, estado_tarea);
    }

    //Eliminar una Estado_tarea
    @RequestMapping(value = "/{id_estado_tarea}", method = RequestMethod.DELETE)
    public void deleteEstado_tareaById(@PathVariable Long id_estado_tarea){
        estado_tareaRepository.deleteEstado_tareaById(id_estado_tarea);
    }


}
