package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

	private MediaPlayer mMediaPlayer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		final ArrayList<Word> theWords = new ArrayList<>();
		theWords.add(new Word("father", "әpә",
					R.drawable.family_father, R.raw.family_father));
		theWords.add(new Word("mother", "әṭa",
					R.drawable.family_mother, R.raw.family_mother));
		theWords.add(new Word("son", "angsi",
					R.drawable.family_son, R.raw.family_son));
		theWords.add(new Word("daughter", "tune",
					R.drawable.family_daughter, R.raw.family_daughter));
		theWords.add(new Word("older brother", "taachi",
					R.drawable.family_older_brother, R.raw.family_older_brother));
		theWords.add(new Word("younger brother", "chalitti",
					R.drawable.family_younger_brother, R.raw.family_younger_brother));
		theWords.add(new Word("older sister", "teṭe",
					R.drawable.family_older_sister, R.raw.family_older_sister));
		theWords.add(new Word("younger sister", "kolliti",
					R.drawable.family_younger_sister, R.raw.family_younger_sister));
		theWords.add(new Word("grandmother", "ama",
					R.drawable.family_grandmother, R.raw.family_grandmother));
		theWords.add(new Word("grandfather", "paapa",
					R.drawable.family_grandfather, R.raw.family_grandmother));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords,
				R.color.category_family);
		ListView theView = findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);

		theView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int
						position, long id) {

			releasemediaPlayer();

			int theSoundResourceId = theWords.get(position).getSoundResourceId();
			mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this,
						theSoundResourceId);

			mMediaPlayer.start();
			mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					releasemediaPlayer();
				}
			});
			}
		});
	}

	private void releasemediaPlayer() {
		mMediaPlayer.release();
		mMediaPlayer = null;
	}
}
