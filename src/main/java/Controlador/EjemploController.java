
package Controlador;

import Modelo.ProfesorDAOImpl;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String index(){
       return "index";
    }

   @RequestMapping(value = "/muestraGrupos")
   public ModelAndView login(ModelMap model,HttpServletRequest request){
       
       String id_profesor = request.getParameter("id_profesor"); 
       LinkedList<String> grupos= profesor_bd.getGrupos(Integer.valueOf(id_profesor));
     
       model.addAttribute("id_profesor", id_profesor);
       model.addAttribute("grupos", grupos);
   
       return new ModelAndView("datos",model);   
   }
   
}
