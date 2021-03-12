package uteq.student.examen_movil.model;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

            String journal_id2 = datos.getString("journal_id") ;
            String portada2  =  datos.getString("portada");
            String abbreviation2  =  datos.getString("abbreviation") ;
            String  description2  =  datos.getString("description");
            String  journalThumbnail2  =  datos.getString("journalThumbnail") ;
            String name2  =  datos.getString("name").toString() ;

            jou.add(new journal(journal_id2,portada2,abbreviation2,description2,journalThumbnail2,name2));
        }
        return jou;
    }


}
