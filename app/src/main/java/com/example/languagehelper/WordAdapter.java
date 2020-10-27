package com.example.languagehelper;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Words> {
    private int clrResourceId;
   public WordAdapter(Activity context, ArrayList<Words> words, int colorResourceId){
       super(context, 0, words);
       clrResourceId = colorResourceId;
   }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_layout, parent, false
            );
        }
            final Words currentWords = getItem(position);
            TextView txtEnglish = listItemView.findViewById(R.id.txtEnglish);
            txtEnglish.setText(currentWords.getDefaultTranslation());

            TextView txtMiwok = listItemView.findViewById(R.id.txtMiwok);
            txtMiwok.setText(currentWords.getMiwokTranslation());
            ImageView imgView = listItemView.findViewById(R.id.imgView);
            if(currentWords.hasImage()){
                imgView.setImageResource(currentWords.getImgResourceId());
                imgView.setVisibility(View.VISIBLE);
            }
            else{
                imgView.setVisibility(View.GONE);
            }
            final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentWords.getAudioResourceId());
            View textContainer = listItemView.findViewById(R.id.linearTextView);
            int color = ContextCompat.getColor(getContext(), clrResourceId);
            textContainer.setBackgroundColor(color);


            return listItemView;



    }





}
