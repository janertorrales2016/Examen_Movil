package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import uteq.student.examen_movil.WebService.Asynchtask;
import uteq.student.examen_movil.WebService.WebService;
import uteq.student.examen_movil.model.ItemView2;
import uteq.student.examen_movil.model.LoadMoreView2;
import uteq.student.examen_movil.model.datavolumen;

public class volumenes extends AppCompatActivity implements Asynchtask {
    public String URL = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=";
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);
        //inicializacion del InfinitePlaceHolderView
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.volumenloadMoreView);

        //url mas el id que se obtiene del activity anterior
        URL = URL+  getIntent().getStringExtra("id");

        //consulta al Web Service
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        //envio a parsear
        ArrayList<datavolumen> listvoluen= datavolumen.JsonObjectsBuild(result);
        //llenar CardView de Infinity placeholderview
        for(int i = 0; i < listvoluen.size(); i++){
            mLoadMoreView.addView(new ItemView2(this.getApplicationContext(), listvoluen.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView2(mLoadMoreView, listvoluen));
    }

}