package com.tienda.service.impl;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import com.tienda.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl
        implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        //Se busca en la tabla de usuario si existe un usuario con el username
        Usuario usuario = usuarioDao.findByUsername(username);

        //Se valida si existe un usuario con ese username
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        //Si se ejecuta lo siguiente es porque SI existe el usuario con ese username...

        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());
        
        //Se recuperan los roles que tiene el usuario...
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        //Se retorna un User con la información para el sistema de seguridad SPRING
        return new User(usuario.getUsername(),
                usuario.getPassword(),
                roles);
    }

}
