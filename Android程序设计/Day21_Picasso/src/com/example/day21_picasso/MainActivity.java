package com.example.day21_picasso;

import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mIv;
	private Button btn;

	private String mUrl= "http://img.my.csdn.net/uploads/201407/26/1406383130_5094.jpg";
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Picasso.with(MainActivity.this).load(mUrl).into(mIv);
				Picasso.with(MainActivity.this).load(mUrl).centerCrop().placeholder(R.drawable.ic_launcher)
				.resize(20, 20).error(R.drawable.ic_launcher).into(mIv);
			}
		});
    }

    
}
