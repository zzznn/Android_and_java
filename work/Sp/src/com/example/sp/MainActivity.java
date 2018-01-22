package com.example.sp;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private EditText mEt;
	private Button mBtn;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mEt = (EditText) findViewById(R.id.et);
        mBtn = (Button) findViewById(R.id.btn);
        
        mBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String cont = mEt.getText().toString();
				//´æ´¢
				SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
				Editor editor = sp.edit();
				editor.putString("key", cont);
				editor.commit();
				
				
				//Ìø×ª
				startActivity(new Intent(MainActivity.this,SecActivity.class));
				
			}
		});
        
        
    }
    


}
