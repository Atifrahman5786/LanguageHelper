package com.example.languagehelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ConversationActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_numbers);

        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("minto wuksus", "Where are you going?", R.raw.phrase_where_are_you_going));
        words.add(new Words("tinnә oyaase'nә", "What is your name?", R.raw.phrase_what_is_your_name));
        words.add(new Words("oyaaset...", "My name is...", R.raw.phrase_my_name_is));
        words.add(new Words("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        words.add(new Words("kuchi achit", "I am feeling good.", R.raw.phrase_im_feeling_good));
        words.add(new Words("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming));
        words.add(new Words("hәә’ әәnәm", "Yes I'm coming", R.raw.phrase_yes_im_coming));
        words.add(new Words("әәnәm", "I'm coming", R.raw.phrase_im_coming));
        words.add(new Words("yoowutis", "Let's go", R.raw.phrase_lets_go));
        words.add(new Words("әnni'nem", "Come Here", R.raw.phrase_come_here));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.blue);
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