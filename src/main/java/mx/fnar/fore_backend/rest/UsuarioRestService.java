/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fnar.fore_backend.rest;


import mx.fnar.fore_backend.model.Usuario;
import mx.fnar.fore_backend.service.UsuarioService;
import java.util.List;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value = "/test",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void getTest()
    {
        this.log.info("#########################Log usuario Service!");
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> getUsuarioAll()
    throws NotFoundException{
        return this.usuarioService.getUsuarioAll();
    }
    
    @RequestMapping(value = "/{idUsuario}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getUsuarioById(
            @PathVariable("idUsuario")Integer idUsuario)
    throws NotFoundException{
        return this.usuarioService.getUsuarioById(idUsuario);
    }
}
