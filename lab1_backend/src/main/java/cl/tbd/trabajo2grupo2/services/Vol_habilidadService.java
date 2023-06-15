package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Vol_habilidad;
import cl.tbd.trabajo2grupo2.repositories.Vol_habilidadRepository;


@RestController
@RequestMapping("/vol_habilidad")
public class Vol_habilidadService {
    
    private final Vol_habilidadRepository vol_habilidadRepository;
    Vol_habilidadService(Vol_habilidadRepository vol_habilidadRepository)
    {
        this.vol_habilidadRepository = vol_habilidadRepository;
    }

    //Obtener todos los vol_habilidad
    @GetMapping("")
    public List<Vol_habilidad> getAllVol_habilidades(){
        return vol_habilidadRepository.getAllVol_habilidades();
    }

    //Registrar un Vol_habilidad a la base de datos
    @PostMapping("")
    public void createVol_habilidad(Vol_habilidad vol_habilidad){
        vol_habilidadRepository.createVol_habilidad(vol_habilidad);
    }

    //Obtener un vol_habilidad por su id
    @RequestMapping(value = "/{id_vol_habilidad}", method = RequestMethod.GET)
    public Vol_habilidad getVol_habilidadById(long id_vol_habilidad){
        return vol_habilidadRepository.findByIdVol_habilidad(id_vol_habilidad);
    }

    //Actualizar un vol_habilidad
    @RequestMapping(value = "/{id_vol_habilidad}", method = RequestMethod.PUT)
    public void updateVol_habilidad (long id_vol_habilidad, @RequestBody Vol_habilidad vol_habilidad){
        vol_habilidadRepository.updateVol_habilidad(id_vol_habilidad, vol_habilidad);
    }

    //Eliminar un vol_habilidad
    @RequestMapping(value = "/{id_vol_habilidad}", method = RequestMethod.DELETE)
    public void deleteVol_habilidadById(@PathVariable Long id_vol_habilidad){
        vol_habilidadRepository.deleteVol_habilidadById(id_vol_habilidad);
    }
}
