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
import uteq.student.examen_movil.model.ItemView;
import uteq.student.examen_movil.model.LoadMoreView;
import uteq.student.examen_movil.model.journal;

public class MainActivity extends AppCompatActivity implements  Asynchtask {
    public static final String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializacion del InfinitePlaceHolderView
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.loadMoreView);

        //consulta al Web Service
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        //envio a parsear
        ArrayList<journal> feedList= journal.JsonObjectsBuild(result);

        //llenar CardView de Infinity placeholderview
        for(int i = 0; i < feedList.size(); i++) {
            mLoadMoreView.addView(new ItemView(this.getApplicationContext(), feedList.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, feedList));
    }

}