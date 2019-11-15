package co.poligran.sw_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView episodesRV;
    private RecyclerView.Adapter EpisodeAdapter;
    private ArrayList<Episode> episodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        episodesRV = findViewById(R.id.episodesRecyclerView);


        episodeList = new ArrayList<>();
        InformGetter infor = new InformGetter(episodeList);
        infor.getInfo();



        while(episodeList.size()!=7){

        }



        episodesRV.setLayoutManager(new LinearLayoutManager(this));


        EpisodeAdapter = new AdapterEpi(episodeList);
        episodesRV.setAdapter(EpisodeAdapter);
    }
}
