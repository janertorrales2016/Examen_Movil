package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

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
    private InfinitePlaceHolderView mLoadMoreView;
    private TextView prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.loadMoreView);
        prueba= findViewById(R.id.prueba);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");
    }
    ArrayList<journal> listjournal;
    @Override
    public void processFinish(String result) throws JSONException {
        prueba.setText(result);
        try {
            JSONObject JSONlista =  new JSONObject(result);

            listjournal = journal.JsonObjectsBuild(JSONlista);


        }catch(JSONException e){
        }
    }
}