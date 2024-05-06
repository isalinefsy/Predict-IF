
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ifoissey
 */
public class ProfilUtilisateurSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response)throws IOException {
        System.out.println("[trace] appel de ProfilUtilisateurSerialisation : appliquer");
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        JsonObject container = new JsonObject();
        TestUtilisateur user = (TestUtilisateur) request.getAttribute("user");
        if (user!=null){
        container.addProperty("connexion",true);
        
        JsonObject AttributesUser = new JsonObject();
        AttributesUser.addProperty("id", user.getId());
        AttributesUser.addProperty("nom", user.getNom());
        AttributesUser.addProperty("prenom", user.getPrenom());
        AttributesUser.addProperty("mail", user.getMail());
        container.add("utilisateur", AttributesUser);
        }else{
            container.addProperty("connexion",false);
        }
       
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(container));
        out.close();
        System.out.println("[TRACE]Response = " + response);
    }

}