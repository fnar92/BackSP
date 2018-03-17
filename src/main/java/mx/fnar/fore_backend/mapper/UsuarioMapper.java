/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fnar.fore_backend.mapper;

import mx.fnar.fore_backend.model.Usuario;

/**
 *
 * @author Cliente
 */
public interface UsuarioMapper {
    Usuario getUsuarioByUserName(String username);
}
