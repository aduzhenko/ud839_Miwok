package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

	private static final String LOG_TAG = WordAdapter.class.getSimpleName();

	public WordAdapter(Activity context, ArrayList<Word> words) {
		super(context, 0, words);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View theListItemView = convertView;
		if(null == theListItemView) {
			theListItemView = LayoutInflater.from(getContext()).inflate(
						R.layout.word_item, parent, false);
		}

		Word theCurrentword = getItem(position);
		TextView miwokTranslationView = (TextView) theListItemView
					.findViewById(R.id.miwok_word);
		miwokTranslationView.setText(theCurrentword.getMiwokTranslation());
		TextView theDefaultTranslationView = (TextView) theListItemView
					.findViewById(R.id.default_word);
		theDefaultTranslationView.setText(theCurrentword.getDefaultTranslation());

		return theListItemView;
	}
}
