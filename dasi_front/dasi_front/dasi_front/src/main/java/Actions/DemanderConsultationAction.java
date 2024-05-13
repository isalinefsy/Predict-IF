/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Medium;
import static org.joda.time.format.ISODateTimeFormat.date;

/**
 *
 * @author ifoissey
 */
//public class DemanderConsultationAction extends Action {
//     public void executer(HttpServletRequest req){
//        System.out.println("[trace] appel de exectuer de DemanderConsultationAction");
//        Long idMedium = (Long) req.getParameter("idMedium");
//        Long idClient = (Long) req.getParameter("idClient");
//        
//        Client client = this.service.rechercherClientParID(idClient);
//        Medium medium = this.service.rechercherMediumParID(idMedium);
//         = this.service.demanderConsultation(medium, client);
//  
//        if (inscrit==true){
//           req.setAttribute("client",client);
//        }
//    }
//}
