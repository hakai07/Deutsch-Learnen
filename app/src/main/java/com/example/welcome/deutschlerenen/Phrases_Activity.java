package com.example.welcome.deutschlerenen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases_Activity extends AppCompatActivity {
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
        words.add(new word("that’s ridiculous"," das ist Bescheuert ",R.raw.family_grandmother));
        words.add(new word("so…?","na?",R.raw.family_grandmother));
        words.add(new word("what do I care?","das ist mir Wurst",R.raw.family_grandmother));
        words.add(new word("nobody was there","kein Schwein war da ",R.raw.family_grandmother));
        words.add(new word("little by little","langsam langsam",R.raw.family_grandmother));
        words.add(new word("I’m sick of it","Ich habe die Nase voll davon",R.raw.family_grandmother));
        words.add(new word("What's your name?","Wie heißen Sie",R.raw.family_grandmother));
        words.add(new word("Where are you from?","Woher kommst du/ kommen Sie?",R.raw.family_grandmother));
        words.add(new word("Where do you live?","Wo wohnst du/ wohnen Sie?",R.raw.family_grandmother));
        words.add(new word("Germany is a wonderful country","Deutschland ist wunderschön",R.raw.family_grandmother));

        wordAdapter wordsAdapter = new wordAdapter(this, words,R.color.Phrases);
        ListView list = (ListView) findViewById(R.id.lists);
        list.setAdapter(wordsAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(Phrases_Activity.this, word.getAudioResourceId());
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
