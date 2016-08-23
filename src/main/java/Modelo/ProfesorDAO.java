/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import MapeoBD.Grupo;
import MapeoBD.Profesor;
import java.util.List;

/**
 *
 * @author rae
 */
public interface ProfesorDAO {
    
    public List<Grupo> getGrupos(long id_profesor);

    public void guardarProfesor(Profesor profesor);

    public void eliminarProfesor(String nombre);
    
    public void actualizarNombreGrupo(String grupo, long id_grupo);
    
    public void eliminarProfesor(long id_profesor);
    
    public void actualizarNombreGrupo2(String nombre_grupo, long id_grupo);
    
}
