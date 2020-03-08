package tw.org.iii.ellen.ellen03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;
    private SimpleAdapter simpleAdapter ;
    private ArrayList<HashMap<String, String>> data = new ArrayList<>() ;
    private String[] from = {"f1","f2","f3"} ;
    private int[] to = {R.id.item_title, R.id.item_content,R.id.item_date} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView) ;

        initListVies() ;
    }

    private void initListVies(){
        for (int i = 0; i<100; i++) {
            HashMap<String, String> row0 = new HashMap<>();
            row0.put(from[0], "value" + i);
            row0.put(from[1], "xxxx");
            row0.put(from[2], "2020-03-07");
            data.add(row0);
        }
        simpleAdapter = new SimpleAdapter(this,data,R.layout.item,from,to) ;
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showOneItem(position);
            }
        });
    }

    private void showOneItem(int pos){
        Toast.makeText(this,data.get(pos).get(from[0]),Toast.LENGTH_SHORT).show() ;
    }

    public void addItem(View view) {
        HashMap<String, String> row0 = new HashMap<>();
        row0.put(from[0], "value" + (int)(Math.random()*100+100));
        row0.put(from[1], "new data");
        row0.put(from[2], "2020-02-07");
        data.add(0,row0);
        simpleAdapter.notifyDataSetChanged() ;
    }
}
