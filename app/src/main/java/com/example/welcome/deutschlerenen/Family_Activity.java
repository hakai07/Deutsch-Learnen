package com.example.welcome.deutschlerenen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_Activity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mComplitionListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_activity);

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("mother","Mutter",R.raw.family_mother));
        words.add(new word("father","Vater ",R.raw.family_father));
        words.add(new word("brother","Bruder",R.raw.family_brother));
        words.add(new word("sister","Schwester ",R.raw.family_sister));
        words.add(new word("son","Sohn ",R.raw.family_son));
        words.add(new word("daughter","Tochter",R.raw.family_daughter));
        words.add(new word("nephew","Neffe ",R.raw.family_nephew));
        words.add(new word("uncle","onkel",R.raw.family_uncle));
        words.add(new word("grandmother","Großmutter",R.raw.family_grandmother));
        words.add(new word("grandfather","Großvater",R.raw.family_grandfather));

        wordAdapter wordsAdapter = new wordAdapter(this, words,R.color.Family);
        ListView list = (ListView) findViewById(R.id.lists);
        list.setAdapter(wordsAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(Family_Activity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mComplitionListner);
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

