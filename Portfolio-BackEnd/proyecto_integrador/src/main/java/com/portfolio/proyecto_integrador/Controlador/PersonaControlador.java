package com.portfolio.proyecto_integrador.Controlador;

import com.portfolio.proyecto_integrador.Entidad.Persona;
import com.portfolio.proyecto_integrador.Interfase.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControlador {
    @Autowired IPersonaServicio ipersonaServicio;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaServicio.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaServicio.savePersona(persona);
        return "La persona se creo correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaServicio.deletePersona(id);
        return "La persona se elimino correctamente";
    }
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String NuevoNombre,
                               @RequestParam("apellido") String NuevoApellido,
                               @RequestParam("img") String NuevoImg){
        Persona persona = ipersonaServicio.findPersona(id);
        
        persona.setNombre(NuevoNombre);
        persona.setApellido(NuevoApellido);
        persona.setImg(NuevoImg);
        
        ipersonaServicio.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaServicio.findPersona((long)1);
    }
}
