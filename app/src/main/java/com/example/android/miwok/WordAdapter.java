package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

	private static final String LOG_TAG = WordAdapter.class.getSimpleName();
	private int mColor;

	public WordAdapter(Activity context, ArrayList<Word> words,
	         int colorResourceId) {
		super(context, 0, words);
		mColor = ContextCompat.getColor(getContext(), colorResourceId);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View theListItemView = convertView;
		if(null == theListItemView) {
			theListItemView = LayoutInflater.from(getContext()).inflate(
						R.layout.word_item, parent, false);
		}

		LinearLayout theLayout = (LinearLayout) theListItemView
					.findViewById(R.id.text_layout);
		theLayout.setBackgroundColor(mColor);

		Word theCurrentword = getItem(position);

		TextView miwokTranslationView = (TextView) theListItemView
					.findViewById(R.id.miwok_word);
		miwokTranslationView.setText(theCurrentword.getMiwokTranslation());

		TextView theDefaultTranslationView = (TextView) theListItemView
					.findViewById(R.id.default_word);
		theDefaultTranslationView.setText(theCurrentword.getDefaultTranslation());

		ImageView theWordIcon = (ImageView) theListItemView.findViewById(R.id.image);
		if (theCurrentword.hasImage()) {
			theWordIcon.setImageResource(theCurrentword.getImageResourceId());
			theWordIcon.setVisibility(View.VISIBLE);
		} else {
			theWordIcon.setVisibility(View.GONE);
		}

		return theListItemView;
	}
}
