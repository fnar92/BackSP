/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fnar.fore_backend.service;


import mx.fnar.fore_backend.model.Usuario;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface UsuarioService {
    Usuario getUsuarioByUserName(String username);
    List<Usuario>getUsuarioAll();
    Usuario getUsuarioById(Integer idUsuario);
}
