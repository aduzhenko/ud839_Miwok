package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

	private MediaPlayer mMediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		ArrayList<Word> theWords = new ArrayList<Word>();
		theWords.add(new Word("one", "lutti",
					R.drawable.number_one));
		theWords.add(new Word("two", "otiiko",
					R.drawable.number_two));
		theWords.add(new Word("three", "tolookosu",
					R.drawable.number_three));
		theWords.add(new Word("four", "oyyisa",
					R.drawable.number_four));
		theWords.add(new Word("five", "massokka",
					R.drawable.number_five));
		theWords.add(new Word("six", "temmokka",
					R.drawable.number_six));
		theWords.add(new Word("seven", "kenekaku",
					R.drawable.number_seven));
		theWords.add(new Word("eight", "kawinta",
					R.drawable.number_eight));
		theWords.add(new Word("nine", "wo'e",
					R.drawable.number_nine));
		theWords.add(new Word("ten", "na'aacha",
					R.drawable.number_ten));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords,
					R.color.category_numbers);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);

		theView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int
						position, long id) {
				mMediaPlayer = MediaPlayer.create(NumbersActivity.this,
							R.raw.number_one);
				mMediaPlayer.start();
			}
		});
	}
}
