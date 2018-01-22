package com.example.day19_welcome;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private long exitTime = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	// TODO Auto-generated method stub
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (System.currentTimeMillis() - exitTime > 2000) {
				Toast.makeText(MainActivity.this, "再按一次推出程序！", Toast.LENGTH_LONG).show();
				exitTime = System.currentTimeMillis();
			}else {
				System.exit(0);
				finish();
			}
			
		}
    	return true;
    }
}
