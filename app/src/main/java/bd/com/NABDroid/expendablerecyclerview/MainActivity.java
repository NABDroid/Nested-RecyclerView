package bd.com.NABDroid.expendablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    RecyclerView rootRecyclerView;
    private Data data;
    private ArrayList<Data> dataForFirstRecyclerView;
    private AdapterForFirstRecyclerView adapterForFirstRecyclerView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getDataFromDB();
        initRecyclerView();
        textView.setVisibility(View.VISIBLE);
    }

    private void initRecyclerView() {
        rootRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterForFirstRecyclerView = new AdapterForFirstRecyclerView(dataForFirstRecyclerView, this);
        rootRecyclerView.setAdapter(adapterForFirstRecyclerView);
    }

    private void getDataFromDB() {
        for (int i = 1; i<=20; i++){
            data = new Data("Data from DB will be added into the arraylist! Data from DB will be added into the arraylist! Data from DB will be added into the arraylist", i);
            dataForFirstRecyclerView.add(data);
        }
    }

    private void init() {
        rootRecyclerView = findViewById(R.id.rootRecyclerView);
        textView = findViewById(R.id.headingTV);
        dataForFirstRecyclerView =  new ArrayList<>();
    }


}
