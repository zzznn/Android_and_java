package com.example.sp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec);
		SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
		String name = sp.getString("key", "Ĭ��");
		TextView mTvView = (TextView) findViewById(R.id.tv);
		mTvView.setText(name);

	}
}
