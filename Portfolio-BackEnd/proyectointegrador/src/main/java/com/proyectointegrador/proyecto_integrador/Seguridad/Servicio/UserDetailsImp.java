package com.proyectointegrador.proyecto_integrador.Seguridad.Servicio;

import com.proyectointegrador.proyecto_integrador.Seguridad.Entidad.Usuario;
import com.proyectointegrador.proyecto_integrador.Seguridad.Entidad.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}