/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.sql.DataSource;

/**
 *
 * @author rae
 */
public class ProfesorDAOImpl implements ProfesorDAO{

    private DataSource dataSource;

    public ProfesorDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public LinkedList<String> getGrupos(int id_profesor) {
    
        Connection conexion;
        LinkedList grupos = new LinkedList<String>();
        String sql="select nombreGrupo from grupo where idProfesor= ?";
      
        try{
            conexion = dataSource.getConnection();
            PreparedStatement enunciado = conexion.prepareStatement(sql);
            enunciado.setInt(1, id_profesor);
            ResultSet resultado = enunciado.executeQuery();

            while(resultado.next()){
                grupos.add(resultado.getString("nombreGrupo"));
            }
        }catch(SQLException e){
            System.out.println("Error al obtener los grupos" + "Modelo.ProfesorDAOImpl");
        }
        
        return grupos;
        
    }
    
}