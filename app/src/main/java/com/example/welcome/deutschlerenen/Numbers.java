package com.example.welcome.deutschlerenen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
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
        words.add(new word("one","eins", R.raw.numbers_one));
        words.add(new word("two","zwei",R.raw.numbers_two));
        words.add(new word("three","drei",R.raw.numbers_three));
        words.add(new word("four","vier",R.raw.numbers_four));
        words.add(new word("five","funf",R.raw.numbers_five));
        words.add(new word("six","sechs",R.raw.numbers_six));
        words.add(new word("seven","sieben",R.raw.numbers_seven));
        words.add(new word("eight","acht",R.raw.numbers_eight));
        words.add(new word("nine","neun",R.raw.numbers_nine));
        words.add(new word("ten","zhen",R.raw.numbers_ten));

        wordAdapter wordsAdapter = new wordAdapter(this, words,R.color.Numbers);
        ListView list = (ListView) findViewById(R.id.lists);
        list.setAdapter(wordsAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(Numbers.this,word.getAudioResourceId());
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
