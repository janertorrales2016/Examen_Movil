package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import uteq.student.examen_movil.WebService.Asynchtask;
import uteq.student.examen_movil.WebService.WebService;
import uteq.student.examen_movil.model.journal;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    public static final String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");
    }
    ArrayList<journal> listjournal;
    @Override
    public void processFinish(String result) throws JSONException {
        try {
            JSONObject JSONlista =  new JSONObject(result);

            listjournal = journal.JsonObjectsBuild(JSONlista);
            PlaceHolderView mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
            mGalleryView
                    .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, url1));
        }catch(JSONException e){
        }
    }
}