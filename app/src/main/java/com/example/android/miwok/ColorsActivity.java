package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		ArrayList<Word> theWords = new ArrayList<Word>();
		theWords.add(new Word("red", "weṭeṭṭi",
					R.drawable.color_red));
		theWords.add(new Word("green", "chokokki",
					R.drawable.color_green));
		theWords.add(new Word("brown", "ṭakaakki",
					R.drawable.color_brown));
		theWords.add(new Word("gray", "ṭopoppi",
					R.drawable.color_gray));
		theWords.add(new Word("black", "kululli",
					R.drawable.color_black));
		theWords.add(new Word("white", "kelelli",
					R.drawable.color_white));
		theWords.add(new Word("dusty yellow",
					"ṭopiisә", R.drawable.color_dusty_yellow));
		theWords.add(new Word("mustard yellow",
					"chiwiiṭә", R.drawable.color_mustard_yellow));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);
	}
}
