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
		theWords.add(new Word("father", "әpә",
					R.drawable.family_father));
		theWords.add(new Word("mother", "әṭa",
					R.drawable.family_mother));
		theWords.add(new Word("son", "angsi",
					R.drawable.family_son));
		theWords.add(new Word("daughter", "tune",
					R.drawable.family_daughter));
		theWords.add(new Word("older brother",
					"taachi", R.drawable.family_older_brother));
		theWords.add(new Word("younger brother",
					"chalitti", R.drawable.family_younger_brother));
		theWords.add(new Word("older sister", "teṭe",
					R.drawable.family_older_sister));
		theWords.add(new Word("younger sister",
					"kolliti", R.drawable.family_younger_sister));
		theWords.add(new Word("grandmother", "ama",
					R.drawable.family_grandmother));
		theWords.add(new Word("grandfather", "paapa",
					R.drawable.family_grandfather));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);
	}
}
