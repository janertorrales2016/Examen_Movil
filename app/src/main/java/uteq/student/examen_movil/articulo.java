package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import uteq.student.examen_movil.WebService.Asynchtask;
import uteq.student.examen_movil.WebService.WebService;
import uteq.student.examen_movil.model.ItemView3;
import uteq.student.examen_movil.model.LoadMoreView3;
import uteq.student.examen_movil.model.dataarticulos;

public class articulo extends AppCompatActivity implements Asynchtask {
    public String URL = "https://revistas.uteq.edu.ec/ws/pubs.php?i_id=";
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);
        //inicializacion del InfinitePlaceHolderView
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.articuloloadMoreView);

        //url mas el id que se obtiene del activity anterior
        URL = URL+  getIntent().getStringExtra("id");

        //consulta al Web Service
        Log.d("DEBUG", ""+URL);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        //envio a parsear
        ArrayList<dataarticulos> listarticulos= dataarticulos.JsonObjectsBuild(result);
        //llenar CardView de Infinity placeholderview
        for(int i = 0; i < listarticulos.size(); i++){
            mLoadMoreView.addView(new ItemView3(this.getApplicationContext(), listarticulos.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView3(mLoadMoreView, listarticulos));

    }
}