package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		final ArrayList<Word> theWords = new ArrayList<>();
		theWords.add(new Word("red", "weṭeṭṭi",
					R.drawable.color_red, R.raw.color_red));
		theWords.add(new Word("green", "chokokki",
					R.drawable.color_green, R.raw.color_green));
		theWords.add(new Word("brown", "ṭakaakki",
					R.drawable.color_brown, R.raw.color_brown));
		theWords.add(new Word("gray", "ṭopoppi",
					R.drawable.color_gray, R.raw.color_gray));
		theWords.add(new Word("black", "kululli",
					R.drawable.color_black, R.raw.color_black));
		theWords.add(new Word("white", "kelelli",
					R.drawable.color_white, R.raw.color_white));
		theWords.add(new Word("dusty yellow","ṭopiisә",
					R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
		theWords.add(new Word("mustard yellow", "chiwiiṭә",
					R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords,
					R.color.category_colors);
		ListView theView = findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);

		theView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int
					position, long id) {

				int theSoundResourceId = theWords.get(position).getSoundResourceId();
				MediaPlayer thePlayer = MediaPlayer.create(ColorsActivity.this,
							theSoundResourceId);
				thePlayer.start();
			}
		});
	}
}
