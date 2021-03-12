package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uteq.student.examen_movil.WebService.Asynchtask;
import uteq.student.examen_movil.WebService.WebService;
import uteq.student.examen_movil.model.ItemView;
import uteq.student.examen_movil.model.LoadMoreView;
import uteq.student.examen_movil.model.journal;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    public static final String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.loadMoreView);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");
    }
    ArrayList<journal> listjournal;
    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista=  new JSONObject(result);
        Toast.makeText(this.getApplicationContext(),result, Toast.LENGTH_LONG).show();
        
            listjournal = journal.JsonObjectsBuild(JSONlista);

        Toast.makeText(this.getApplicationContext(),"can"+listjournal.size(), Toast.LENGTH_LONG).show();

            for(int i = 0; i < listjournal.size(); i++){

                mLoadMoreView.addView(new ItemView(this.getApplicationContext(), listjournal.get(i)));
            }
            mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, listjournal));


    }
}