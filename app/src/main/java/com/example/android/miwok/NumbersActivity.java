package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_numbers);

		List<String> theEngNumbers = Arrays.asList("one", "two", "three", "four",
					"five", "six", "seven", "eight", "nine", "ten");

		LinearLayout theLayout = (LinearLayout) findViewById(R.id.rootView);
		for (String theNumber : theEngNumbers) {
			TextView theView = new TextView(this);
			theView.setText(theNumber);
			theLayout.addView(theView);
		}
	}
}
