package uteq.student.examen_movil.model;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class dataarticulos {
    public String  title;
    public  String autores;
    public String año;
    public String url;

    public dataarticulos(String title, String autores, String año, String url) {
        this.title = title;
        this.autores = autores;
        this.año = año;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //Parsear
    public static ArrayList<dataarticulos> JsonObjectsBuild(String xx) throws JSONException {
        ArrayList<dataarticulos> volu = new ArrayList<>();
        JSONArray datos = new JSONArray(xx);
        for (int i = 0; i < datos.length() ; i++) {
            JSONObject data = datos.getJSONObject(i);
            String title2 = data.getString("title") ;
            String año2  =  data.getString("date_published") ;
            JSONArray galeys =  data.getJSONArray("galeys");
            JSONObject galeysobject = galeys.getJSONObject(0);
            String url2 = galeysobject.getString("UrlViewGalley");
            JSONArray authors =  data.getJSONArray("authors");
            String autores2="";
            for (int j=0;j<authors.length();j++){
                JSONObject authorsobject = authors.getJSONObject(j);
                autores2= autores2+", "+ authorsobject.getString("nombres");
            }
            volu.add(new dataarticulos(title2,autores2,año2,url2));
        }
        return volu;
    }
}
