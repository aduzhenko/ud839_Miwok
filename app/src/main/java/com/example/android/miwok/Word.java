package com.example.android.miwok;

public class Word {

	private static final int NO_IMAGE_PROVIDED = -1;

	private String mDefaultTranslation;
	private String mMiwokTranslation;
	private int mImageResourceId = NO_IMAGE_PROVIDED;

	public Word(String defaultTranslation, String miwokTranslation) {
		this.mDefaultTranslation = defaultTranslation;
		this.mMiwokTranslation = miwokTranslation;

	}

	public Word(String defaultTranslation, String miwokTranslation,
				int imageResourceId) {
		mDefaultTranslation = defaultTranslation;
		mMiwokTranslation = miwokTranslation;
		mImageResourceId = imageResourceId;
	}

	public String getDefaultTranslation() {
		return mDefaultTranslation;
	}

	public String getMiwokTranslation() {
		return mMiwokTranslation;
	}

	public boolean hasImage() {
		return mImageResourceId != NO_IMAGE_PROVIDED;
	}

	public int getImageResourceId() {
		return mImageResourceId;
	}
}
