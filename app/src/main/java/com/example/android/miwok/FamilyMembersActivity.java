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

public class FamilyMembersActivity extends AppCompatActivity {

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

				releaseMediaPlayer();
				int theSoundResourceId = theWords.get(position).getSoundResourceId();

				mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
				int theResult = mAudioManager.requestAudioFocus(
							mAudioFocusChangeListener, AudioManager.STREAM_MUSIC,
							AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
				if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == theResult) {
					mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this,
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
