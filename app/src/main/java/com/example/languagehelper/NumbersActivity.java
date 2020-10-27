package com.example.languagehelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("lutti", "One", R.drawable.number_one, R.raw.number_one));
        words.add(new Words("otiiko", "Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Words("tolookosu", "Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Words("oyyisa", "Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Words("massokka", "Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Words("temmokka", "Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Words("kenekaku", "Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Words("kawinta", "Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Words("wo'e", "Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Words("na'aacha", "Ten", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.orange);
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