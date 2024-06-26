package Serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.ProfilAstral;

public class ObtenirProfilClientSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("[trace] appel de ObtenirProfilClientSerialisation : appliquer");
        Client client = (Client) req.getAttribute("client");
        ProfilAstral profilAstralClient = client.getProfilAstral();

        List<Consultation> historiqueConsultation = client.getHistoriqueConsultation();

        String animalTotem = profilAstralClient.getAnimalTotem();
        String couleurPorteBonheur = profilAstralClient.getCouleurPorteBonheur();
        String signeAstroChinois = profilAstralClient.getSigneAstroChinois();
        String signeZodiaque = profilAstralClient.getSigneZodiaque();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        JsonObject jsonClient = new JsonObject();
 
        JsonObject jsonInfosClient = new JsonObject();
        jsonInfosClient.addProperty("nom", client.getNom());
        jsonInfosClient.addProperty("prenom", client.getPrenom());
        jsonInfosClient.addProperty("tel", client.getNumeroTelephone());
        jsonInfosClient.addProperty("adresse", client.getAdressePostale());
        jsonInfosClient.addProperty("mail", client.getMail());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = client.getDateNaissance();
        String dateNaissanceAsString = dateFormat.format(dateNaissance);
        jsonInfosClient.addProperty("dateNaissance", dateNaissanceAsString);
        jsonInfosClient.addProperty("animalTotem", animalTotem);
        jsonInfosClient.addProperty("couleurPorteBonheur", couleurPorteBonheur);
        jsonInfosClient.addProperty("signeAstroChinois", signeAstroChinois);
        jsonInfosClient.addProperty("signeZodiaque", signeZodiaque);

        JsonArray jsonListeConsultation = new JsonArray();
        for (Consultation consultation : historiqueConsultation) {
            JsonObject jsonConsultation = new JsonObject();
            jsonConsultation.addProperty("nomClient", consultation.getClient().getNom());
            jsonConsultation.addProperty("prenomClient", consultation.getClient().getPrenom());
            jsonConsultation.addProperty("medium", consultation.getMedium().getDenomination());
            jsonConsultation.addProperty("date", consultation.getDateDemande().toString());
            jsonConsultation.addProperty("etat", consultation.getEtat());
            jsonConsultation.addProperty("commentaire", consultation.getCommentaire());
            jsonConsultation.addProperty("idEmploye", consultation.getEmploye().getId());
            jsonConsultation.addProperty("idConsultation", consultation.getId());
            jsonConsultation.addProperty("idClient", consultation.getClient().getId());
            jsonListeConsultation.add(jsonConsultation);
        }
        jsonClient.add("infosClient", jsonInfosClient);
        jsonClient.add("historiqueConsultation", jsonListeConsultation);
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println(gson.toJson(jsonClient));
        out.close();
        System.out.println("[TRACE]Response = " + res);
    }
}
