package uteq.student.examen_movil.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class datavolumen {
    private  String issue_id;
    private String volume;
    private String number;
    private String year;
    private String date_published;
    private String title;
    private String doi;
    private String cover;

    public datavolumen(String issue_id, String volume, String number, String year, String date_published, String title, String doi, String cover) {
        this.issue_id = issue_id;
        this.volume = volume;
        this.number = number;
        this.year = year;
        this.date_published = date_published;
        this.title = title;
        this.doi = doi;
        this.cover = cover;
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    //Parsear
    public static ArrayList<datavolumen> JsonObjectsBuild(String xx) throws JSONException {
        ArrayList<datavolumen> volu = new ArrayList<>();
        JSONArray datos = new JSONArray(xx);
        for (int i = 0; i < datos.length() ; i++) {

            JSONObject data = datos.getJSONObject(i);

            String issue_id2 = data.getString("issue_id") ;
            String volume2  =  data.getString("volume");
            String number2  =  data.getString("number") ;
            String  year2  =  data.getString("year");
            String  date_published2  =  data.getString("date_published") ;
            String title2  =  data.getString("title").toString() ;
            String doi2  =  data.getString("doi").toString() ;
            String cover2  =  data.getString("cover").toString() ;
            volu.add(new datavolumen(issue_id2,volume2,number2,year2,date_published2,title2,doi2,cover2));
        }
        return volu;
    }
}
