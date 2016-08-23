
package Controlador;

import MapeoBD.Grupo;
import MapeoBD.Profesor;
import Modelo.ProfesorDAOImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rae
 */
@Controller
public class EjemploController{
    
    @Autowired
    private ProfesorDAOImpl profesor_bd;
    
    @RequestMapping(value = "/")
    public ModelAndView index(ModelMap model){
     
        model.addAttribute("command",new Profesor());
        
        return new ModelAndView("index",model);
    }

    @RequestMapping(value = "/muestraGrupos", method = RequestMethod.POST)
    public ModelAndView muestraGrupos(ModelMap model,HttpServletRequest request){

       String id_profesor = request.getParameter("id_profesor"); 
       List<Grupo> grupos= profesor_bd.getGrupos(Long.valueOf(id_profesor));
     
       model.addAttribute("id_profesor", id_profesor);
       model.addAttribute("grupos", grupos);
   
       return new ModelAndView("datos",model);   
   }
   
    @RequestMapping(value= "/registroProfesor", method = RequestMethod.POST)
    public String registroProfesor(Profesor profesor){
  
       profesor_bd.guardarProfesor(profesor);
  
       return "modificacionExitosa";
   }
   
   @RequestMapping(value= "/eliminarProfesor", method = RequestMethod.POST)
   public String eliminarProfesor(@RequestParam String eliminar_nombre_profesor){
              
       profesor_bd.eliminarProfesor(eliminar_nombre_profesor);
       
       return "modificacionExitosa";
   }
   
   @RequestMapping(value= "/modificarNombre", method = RequestMethod.POST)
   public String modificarNombreGrupo(@RequestParam long id_grupo, @RequestParam String nombre_grupo){
       
       profesor_bd.actualizarNombreGrupo(nombre_grupo, id_grupo);
       
       return "modificacionExitosa";
       
   }
   
   
   
}
