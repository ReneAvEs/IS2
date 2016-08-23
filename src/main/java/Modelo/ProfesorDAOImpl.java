/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import MapeoBD.Grupo;
import MapeoBD.Profesor;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rae
 */
public class ProfesorDAOImpl implements ProfesorDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Grupo> getGrupos(long id_profesor) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Profesor profesor = null;
        
        
        try {
           tx = session.beginTransaction();
           profesor = (Profesor) session.get(Profesor.class, id_profesor);
           // Fuerza a obtener la lista con los grupos
           if(profesor != null){
               Hibernate.initialize(profesor.getGrupos());
           }  
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        
        // Si no hay resultado se regresa una lista vacia 
        if(profesor == null){
            return new LinkedList();
        }
        
        return profesor.getGrupos();
        
    }

    @Override
    public void guardarProfesor(Profesor profesor) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(profesor);
           
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    
    }

    @Override
    public void eliminarProfesor(String nombre) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           
           // Case Sensitive
           String hql = "DELETE FROM Profesor "  + 
                        "WHERE nombre_profesor = :nombre";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            int result = query.executeUpdate();
            System.out.println("Se han modificado " + result + " numero de filas");
            
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    
    }

    @Override
    public void actualizarNombreGrupo(String nombre_grupo, long id_grupo) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           String hql = "UPDATE Grupo set nombre_grupo = :nombre "  + 
                        "WHERE id_grupo = :id";
           Query query = session.createQuery(hql);
           query.setParameter("nombre", nombre_grupo);
           query.setParameter("id", id_grupo);
           int result = query.executeUpdate();
           System.out.println("Se han modificado " + result + " numero de filas"); 
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    
    }

    @Override
    public void eliminarProfesor(long id_profesor) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Profesor profesor;
        try {
           tx = session.beginTransaction();
           
           profesor = (Profesor) session.get(Profesor.class, id_profesor);
           
           if(profesor != null){
            session.delete(profesor);
           }
           
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    }

    @Override
    public void actualizarNombreGrupo2(String nombre_grupo, long id_grupo) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Grupo grupo;
       
        try {
           tx = session.beginTransaction();
       
           grupo = (Grupo) session.get(Grupo.class, id_grupo);
           
           if(grupo != null){
               grupo.setNombre_grupo(nombre_grupo);
               session.update(grupo);
           }
           
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        
    }
  
    
    
}