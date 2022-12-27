  package com.portfolio.proyecto_integrador.Repositorio;

import com.portfolio.proyecto_integrador.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona, Long> {
    
}
