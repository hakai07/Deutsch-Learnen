package com.example.welcome.deutschlerenen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors_Activity extends AppCompatActivity {
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
        words.add(new word("black", "schwarz",R.raw.colors_black));
        words.add(new word("white", "weiß",R.raw.colors_white));
        words.add(new word("red", "rot",R.raw.colors_red));
        words.add(new word("yellow", "gelb",R.raw.colors_yellow));
        words.add(new word("blue", "blau",R.raw.colors_blue));
        words.add(new word("green", "grün",R.raw.colors_green));
        words.add(new word("brown", "braun",R.raw.colors_brown));
        words.add(new word("pink", "rosa",R.raw.colors_pink));
        words.add(new word("orange", "orange",R.raw.colors_orange));
        words.add(new word("grey", "grau",R.raw.colors_grey));

        wordAdapter wordsAdapter = new wordAdapter(this, words,R.color.Colors);
        ListView list = (ListView) findViewById(R.id.lists);
        list.setAdapter(wordsAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(Colors_Activity.this, word.getAudioResourceId());
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
