package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import uteq.student.examen_movil.WebService.Asynchtask;
import uteq.student.examen_movil.WebService.WebService;

public class Articulos extends AppCompatActivity implements Asynchtask {
    public String URL = "https://revistas.uteq.edu.ec/ws/pubs.php?i_id=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);
        String id = getIntent().getExtras().getString("id");
        URL=URL+id;
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}