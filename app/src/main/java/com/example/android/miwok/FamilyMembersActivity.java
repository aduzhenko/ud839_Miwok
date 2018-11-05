package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		ArrayList<Word> theWords = new ArrayList<Word>();
		theWords.add(new Word("father", "әpә"));
		theWords.add(new Word("mother", "әṭa"));
		theWords.add(new Word("son", "angsi"));
		theWords.add(new Word("daughter", "tune"));
		theWords.add(new Word("older brother", "taachi"));
		theWords.add(new Word("younger brother", "chalitti"));
		theWords.add(new Word("older sister", "teṭe"));
		theWords.add(new Word("younger sister", "kolliti"));
		theWords.add(new Word("grandmother", "ama"));
		theWords.add(new Word("grandfather", "paapa"));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);
	}
}
