package com.portfolio.proyecto_integrador.Interfase;

import com.portfolio.proyecto_integrador.Entidad.Persona;
import java.util.List;


public interface IPersonaServicio {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar objeto buscado por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
