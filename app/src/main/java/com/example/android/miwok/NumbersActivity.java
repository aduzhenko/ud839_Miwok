package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		ArrayList<Word> theWords = new ArrayList<Word>();
		theWords.add(new Word("one", "lutti"));
		theWords.add(new Word("two", "otiiko"));
		theWords.add(new Word("three", "tolookosu"));
		theWords.add(new Word("four", "oyyisa"));
		theWords.add(new Word("five", "massokka"));
		theWords.add(new Word("six", "temmokka"));
		theWords.add(new Word("seven", "kenekaku"));
		theWords.add(new Word("eight", "kawinta"));
		theWords.add(new Word("nine", "wo'e"));
		theWords.add(new Word("ten", "na'aacha"));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);
	}
}
