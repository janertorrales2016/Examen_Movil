package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import uteq.student.examen_movil.WebService.Asynchtask;
import uteq.student.examen_movil.WebService.WebService;

public class articulo extends AppCompatActivity implements Asynchtask {
    public String URL = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=";
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.articuloloadMoreView);
        URL = URL+  getIntent().getStringExtra("id");

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}