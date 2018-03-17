/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fnar.fore_backend.mapper;

import java.util.List;
import mx.fnar.fore_backend.model.Perfil;

/**
 *
 * @author Cliente
 */
public interface PerfilMapper {
    List<Perfil> getPerfilByIdPersona(Integer idPersona);
}
