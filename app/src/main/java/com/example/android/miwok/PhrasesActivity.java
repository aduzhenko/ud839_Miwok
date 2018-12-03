package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

	private MediaPlayer mMediaPlayer = null;

	private MediaPlayer.OnCompletionListener mCompletionListener =
				new MediaPlayer.OnCompletionListener() {

		@Override
		public void onCompletion(MediaPlayer mp) {
			releaseMediaPlayer();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		final ArrayList<Word> theWords = new ArrayList<>();
		theWords.add(new Word("Where are you going?",
					"minto wuksus", R.raw.phrase_where_are_you_going));
		theWords.add(new Word("What is your name?",
					"tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
		theWords.add(new Word("My name is...",
					"oyaaset...", R.raw.phrase_my_name_is));
		theWords.add(new Word("How are you feeling?",
					"michәksәs?", R.raw.phrase_how_are_you_feeling));
		theWords.add(new Word("I’m feeling good.",
					"kuchi achit", R.raw.phrase_im_feeling_good));
		theWords.add(new Word("Are you coming?",
					"әәnәs'aa?", R.raw.phrase_are_you_coming));
		theWords.add(new Word("Yes, I’m coming.",
					"hәә’ әәnәm", R.raw.phrase_yes_im_coming));
		theWords.add(new Word("I’m coming.", "әәnәm",
					R.raw.phrase_im_coming));
		theWords.add(new Word("Let’s go.", "yoowutis",
					R.raw.phrase_lets_go));
		theWords.add(new Word("Come here.", "әnni'nem",
					R.raw.phrase_come_here));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords,
					R.color.category_phrases);
		ListView theView = findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);

		theView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int
					position, long id) {

			releaseMediaPlayer();

			int theSoundResourceId = theWords.get(position).getSoundResourceId();
			mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,
						theSoundResourceId);

			mMediaPlayer.start();
			mMediaPlayer.setOnCompletionListener(mCompletionListener);
			}
		});
	}

	@Override
	protected void onStop() {
		super.onStop();
		releaseMediaPlayer();
	}

	private void releaseMediaPlayer() {
		mMediaPlayer.release();
		mMediaPlayer = null;
	}
}
