
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ifoissey
 */
public class AuthentifierUtilisateurAction extends Action {

    public void executer(HttpServletRequest req) {
        System.out.println("[trace] appel de exectuer de AuthentifierUtilisateurAction");
        TestUtilisateur user1 = new TestUtilisateur (1024,"Lovelace","Ada", "ada.lovelace@insa-lyon.fr");
        
        String mail = req.getParameter("login");
        System.out.println("Test mail "+mail +"compare with user : "+ user1.getMail());
        if (mail.equals(user1.getMail())){
            req.setAttribute("user",user1);
    }else{
            req.setAttribute("user",null);
        }
    }
}
