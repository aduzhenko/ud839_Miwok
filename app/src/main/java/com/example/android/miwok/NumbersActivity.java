package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

	private MediaPlayer mMediaPlayer = null;

	private MediaPlayer.OnCompletionListener mCompletionListener =
				new MediaPlayer.OnCompletionListener() {

		@Override
		public void onCompletion(MediaPlayer mp) {
			releaseMediaPlayer();
		}
	};

	private AudioManager mAudioManager;

	private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener =
				new AudioManager.OnAudioFocusChangeListener() {
		@Override
		public void onAudioFocusChange(int focusChange) {

			if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
				mMediaPlayer.start();
			} else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
				releaseMediaPlayer();
			} else {
				mMediaPlayer.pause();
				mMediaPlayer.seekTo(0);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_list);

		final ArrayList<Word> theWords = new ArrayList<>();
		theWords.add(new Word("one", "lutti",
					R.drawable.number_one, R.raw.number_one));
		theWords.add(new Word("two", "otiiko",
					R.drawable.number_two, R.raw.number_two));
		theWords.add(new Word("three", "tolookosu",
					R.drawable.number_three, R.raw.number_three));
		theWords.add(new Word("four", "oyyisa",
					R.drawable.number_four, R.raw.number_four));
		theWords.add(new Word("five", "massokka",
					R.drawable.number_five, R.raw.number_five));
		theWords.add(new Word("six", "temmokka",
					R.drawable.number_six, R.raw.number_six));
		theWords.add(new Word("seven", "kenekaku",
					R.drawable.number_seven, R.raw.number_seven));
		theWords.add(new Word("eight", "kawinta",
					R.drawable.number_eight, R.raw.number_eight));
		theWords.add(new Word("nine", "wo'e",
					R.drawable.number_nine, R.raw.number_nine));
		theWords.add(new Word("ten", "na'aacha",
					R.drawable.number_ten, R.raw.number_ten));

		WordAdapter theWordAdapter = new WordAdapter(this, theWords,
					R.color.category_numbers);
		ListView theView = findViewById(R.id.list);
		theView.setAdapter(theWordAdapter);

		theView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int
						position, long id) {
			releaseMediaPlayer();
			int theSoundResourceId = theWords.get(position).getSoundResourceId();

			mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
			int theResult = mAudioManager.requestAudioFocus(
						mAudioFocusChangeListener, AudioManager.STREAM_MUSIC,
						AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
			if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == theResult) {
				mMediaPlayer = MediaPlayer.create(NumbersActivity.this,
							theSoundResourceId);
				mMediaPlayer.start();
				mMediaPlayer.setOnCompletionListener(mCompletionListener);
			}
			}
		});
	}

	@Override
	protected void onStop() {
		super.onStop();
		releaseMediaPlayer();
	}

	private void releaseMediaPlayer() {
		if (null != mMediaPlayer) {
			mMediaPlayer.release();
			mMediaPlayer = null;
			mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
		}
	}
}
