/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fnar.fore_backend.service.impl;

import mx.fnar.fore_backend.exception.NoContentException;
import mx.fnar.fore_backend.model.Perfil;
import mx.fnar.fore_backend.model.Role;
import mx.fnar.fore_backend.model.User;
import mx.fnar.fore_backend.model.Usuario;

import mx.fnar.fore_backend.util.Constant;
import java.util.List;
import mx.fnar.fore_backend.mapper.UsuarioMapper;
import mx.fnar.fore_backend.util.GenericService;
import mx.fnar.fore_backend.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.fnar.fore_backend.mapper.PerfilMapper;

/**
 *
 * @author Cliente
 */
@Service("userDetailsServiceImpl")
public class UsuarioServiceImpl extends GenericService implements UserDetailsService, UsuarioService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private PerfilMapper perfilMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsuario(usuarioMapper.getUsuarioByUserName(username));
        List<Perfil> roles = perfilMapper.getPerfilByIdPersona(user.getUsuario().getPersona().getIdPersona());
        roles.stream().forEach(p -> {
            Role r =  new Role();
            r.setName(p.getTarjet());
            user.getAuthorities().add(r);
        });
        return user;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUserName(String username) {
        return usuarioMapper.getUsuarioByUserName(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarioAll() {
       List<Usuario> userList =  null;//this.usuarioMapper.getUsuarioAll();
       if(listaValida(userList)) { return userList;}
       throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioById(Integer idUsuario) {
        Usuario user = null;// this.usuarioMapper.getUsuarioById(idUsuario);
        if(objetoValido(user)){ return user;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
}