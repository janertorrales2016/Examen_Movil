package uteq.student.examen_movil.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class journal {
    private String journal_id;
    private String portada;
    private String abbreviation;
    private String description;
    private String journalThumbnail;
    private String name;

    public journal() {
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJournalThumbnail() {
        return journalThumbnail;
    }

    public void setJournalThumbnail(String journalThumbnail) {
        this.journalThumbnail = journalThumbnail;
    }

    public String getName() {
        return name;
    }

    public journal(String journal_id, String portada, String abbreviation, String description, String journalThumbnail, String name) {
        this.journal_id = journal_id;
        this.portada = portada;
        this.abbreviation = abbreviation;
        this.description = description;
        this.journalThumbnail = journalThumbnail;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<journal> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<journal> jou = new ArrayList<>();

        for (int i = 0; i < datos.length() ; i++) {
            String journal_id = datos.getString("journal_id").toString() ;
            String portada  =  datos.getString("portada").toString() ;
            String abbreviation  =  datos.getString("abbreviation").toString() ;
            String  description  =  datos.getString("description").toString() ;
            String  journalThumbnail  =  datos.getString("journalThumbnail").toString() ;
            String name  =  datos.getString("name").toString() ;
            jou.add(new journal(journal_id,portada,abbreviation,description,journalThumbnail,name));
        }
        return jou;
    }

}
