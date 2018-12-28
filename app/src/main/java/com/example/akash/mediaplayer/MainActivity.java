package com.example.akash.mediaplayer;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    Button firstSong,secondSong,thirdSong;
    ArrayAdapter adapter;
    Intent intent;
    List<String> songStorage;
    ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseComponent();
    }
    private void initialiseComponent() {
        /*firstSong=(Button)findViewById(R.id.firstSong);
        secondSong=(Button)findViewById(R.id.secondSong);
        thirdSong=(Button)findViewById(R.id.thirdSong);

        firstSong.setOnClickListener(this);
        secondSong.setOnClickListener(this);
        thirdSong.setOnClickListener(this);*/
        songList=(ListView)findViewById(R.id.songList);
        songStorage=new ArrayList<String>(Arrays.asList(
                "backtoyou",
                "girlslikeyou",
                "letyouberight",
                "loveme",
                "scaredtobelonely"
        ));

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,songStorage);
        songList.setAdapter(adapter);
        

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, songStorage.get(position), Toast.LENGTH_SHORT).show();
                intent=new Intent(getApplicationContext(),play_song.class);
                intent.putExtra("song",songStorage.get(position).toString());
                startActivity(intent);
            }
        });
        
        
       // intent=new Intent(this,play_song.class);
    }

   /* @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(intent);
    }*/
   
   

    /*@Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.firstSong:
                intent.putExtra("song","firstSong");
                startActivity(intent);
                break;
            case R.id.secondSong:
                intent.putExtra("song","secondSong");
                startActivity(intent);
                break;
            case R.id.thirdSong:
                intent.putExtra("song","thirdSong");
                startActivity(intent);
                break;
        }
    }*/
}
