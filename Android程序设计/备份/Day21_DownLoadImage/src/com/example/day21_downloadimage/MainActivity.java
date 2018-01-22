package com.example.day21_downloadimage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ImageView mIv;
	private Button mBtn;
	private String mUrl = "http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg";
	private String mUrl2 ="http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg";
	private Bitmap bitmap;
	private Bitmap bitmap2;

	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				mIv.setImageBitmap(bitmap);
				break;
			case 2:
				mIv.setImageBitmap(bitmap2);
				break;
			default:
				break;
			}
		};
	};
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv = (ImageView) findViewById(R.id.iv);
        mBtn = (Button) findViewById(R.id.btn);
        
        mBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						//getImageByHttpClient();
						getImageByHttpUrLConnection();
					}
				}).start();
				
				
			}

			
		});
        
    }
	//httpClient
	private void getImageByHttpClient() {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(mUrl);
		try {
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				InputStream inputStream = response.getEntity().getContent();
				bitmap = BitmapFactory.decodeStream(inputStream);
				mHandler.sendEmptyMessage(1);
			}else {
				Toast.makeText(MainActivity.this, "œ¬‘ÿ ß∞‹", Toast.LENGTH_SHORT).show();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	private void getImageByHttpUrLConnection(){
		try {
			URL url = new URL(mUrl2);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setReadTimeout(200);
			connection.setRequestMethod("GET");
			if (connection.getResponseCode() == 200) {
				InputStream inputStream = connection.getInputStream();
				bitmap2 = BitmapFactory.decodeStream(inputStream);
				mHandler.sendEmptyMessage(2);
			}else {
				Toast.makeText(MainActivity.this, "œ¬‘ÿ ß∞‹", Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
