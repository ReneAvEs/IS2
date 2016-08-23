/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.LinkedList;

/**
 *
 * @author rae
 */
public interface ProfesorDAO {
    
    public LinkedList<String> getGrupos(int id_profesor);
    
    
}
