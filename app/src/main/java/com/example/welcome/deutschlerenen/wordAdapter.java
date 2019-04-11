package com.example.welcome.deutschlerenen;
import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Welcome on 7/17/2017.
 */
public class wordAdapter extends ArrayAdapter<word> {
    private  int mColorResourceId;

    public wordAdapter(Activity context,ArrayList<word> words,int colorResource) {
        super(context, 0, words);
        mColorResourceId = colorResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_view, parent, false);
        }
        word currentWord = getItem(position);
        TextView germanTranslate = (TextView) listItemView.findViewById(R.id.german_words);
        germanTranslate.setText(currentWord.getgermanTranslate());

        TextView engTranslate = (TextView) listItemView.findViewById(R.id.english_words);
        engTranslate.setText(currentWord.getEngTranslate());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;

    }

}