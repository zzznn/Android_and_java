package com.example.day19_welcome;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends Activity{
	
	private SharedPreferences sp;
	private boolean isFirst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		sp = getSharedPreferences("Tag", MODE_PRIVATE);
		isFirst = sp.getBoolean("isFrist", true);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(isFirst){
					//是第一次安装
					startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
					finish();
				}else {
					startActivity(new Intent(SplashActivity.this,MainActivity.class));
					finish();
				}
			}
		}, 2000);
		
	}

}
