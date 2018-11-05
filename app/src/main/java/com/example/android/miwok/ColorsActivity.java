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
		theWords.add(new Word("red", "weṭeṭṭi"));
		theWords.add(new Word("green", "chokokki"));
		theWords.add(new Word("brown", "ṭakaakki"));
		theWords.add(new Word("gray", "ṭopoppi"));
		theWords.add(new Word("black", "kululli"));
		theWords.add(new Word("white", "kelelli"));
		theWords.add(new Word("dusty yellow", "ṭopiisә"));
		theWords.add(new Word("mustard yellow", "chiwiiṭә"));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);
	}
}
