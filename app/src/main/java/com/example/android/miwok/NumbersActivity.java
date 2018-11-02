package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
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

		ArrayAdapter<String> theItemsAdapter = new ArrayAdapter<String>(
					this, R.layout.list_item, theEngNumbers);
		ListView theView = (ListView) findViewById(R.id.list);
		theView.setAdapter(theItemsAdapter);
	}
}
