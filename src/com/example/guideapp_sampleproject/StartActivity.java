package com.example.guideapp_sampleproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
	}

	public void startActivity(View view){
		startActivity(new Intent(StartActivity.this, MainActivity.class));
	}
	
	public void listViewActivity(View view){
		startActivity(new Intent(StartActivity.this, ListViewActivity.class));
	}
	
	public void dbListViewActivity(View view){
		startActivity(new Intent(StartActivity.this, CursorAdapterActivity.class));
	}
	
	public void serviceActivity(View view){
		startActivity(new Intent(StartActivity.this, ServiceActivity.class));
	}
}
