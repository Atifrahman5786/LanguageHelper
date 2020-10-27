package com.example.languagehelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BasicsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("wetetti", "red", R.drawable.color_red, R.raw.color_red));
        words.add(new Words("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        words.add(new Words("takakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Words("topoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Words("kululli", "black", R.drawable.color_black, R.raw.color_black));
        words.add(new Words("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        words.add(new Words("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Words("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.red);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = words.get(position);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;
    }
}