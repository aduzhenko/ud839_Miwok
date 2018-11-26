package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		ArrayList<Word> theWords = new ArrayList<Word>();
		theWords.add(new Word("Where are you going?",
					"minto wuksus"));
		theWords.add(new Word("What is your name?",
					"tinnә oyaase'nә"));
		theWords.add(new Word("My name is...",
					"oyaaset..."));
		theWords.add(new Word("How are you feeling?",
					"michәksәs?"));
		theWords.add(new Word("I’m feeling good.",
					"kuchi achit"));
		theWords.add(new Word("Are you coming?",
					"әәnәs'aa?"));
		theWords.add(new Word("Yes, I’m coming.",
					"hәә’ әәnәm"));
		theWords.add(new Word("I’m coming.", "әәnәm"));
		theWords.add(new Word("Let’s go.", "yoowutis"));
		theWords.add(new Word("Come here.", "әnni'nem"));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords,
					R.color.category_phrases);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);
	}
}
