package uteq.student.examen_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONArray;
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

public class MainActivity extends AppCompatActivity implements  Asynchtask {
    public static final String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.loadMoreView);
        Log.d("DEBUG", "algo");
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        ArrayList<journal> feedList= journal.JsonObjectsBuild(result);
        Toast.makeText(this.getApplicationContext(),feedList.toString(),Toast.LENGTH_SHORT).show();
        Log.d("DEBUG", ""+feedList.size());
        Log.d("DEBUG", "LoadMoreView.LOAD_VIEW_SET_COUNT " + LoadMoreView.LOAD_VIEW_SET_COUNT);

        for(int i = 0; i < feedList.size(); i++){

            mLoadMoreView.addView(new ItemView(this.getApplicationContext(), feedList.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, feedList));
    }

}