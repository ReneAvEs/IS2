
package Controlador;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rae
 */
@Controller
public class LoginController{
    
    @RequestMapping(value = "/")
    public String index(){
       return "login";
    }

   @RequestMapping(value = "/login")
   public ModelAndView login(ModelMap model,HttpServletRequest request){
       
       String login = request.getParameter("login"); 
       String contrasena = request.getParameter("contrasena");
       
       model.addAttribute("login", login);
       model.addAttribute("contrasena", contrasena);
       
       return new ModelAndView("datos",model);   
   }
   
}
