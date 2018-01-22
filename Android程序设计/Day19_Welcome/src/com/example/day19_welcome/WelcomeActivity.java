package com.example.day19_welcome;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class WelcomeActivity extends FragmentActivity{

	private ViewPager mVp;
	private LinearLayout llPoints;
	private MyAdapter adapter;
	
	private List<Fragment> mlList;
	
	private int prePosition = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wel);
		mVp = (ViewPager) findViewById(R.id.vp);
		llPoints = (LinearLayout) findViewById(R.id.ll_points);
		mlList = new ArrayList<Fragment>();
		WelFragment01 welFragment01 = new WelFragment01();
		WelFragment02 welFragment02 = new WelFragment02();
		WelFragment03 welFragment03 = new WelFragment03();
		mlList.add(welFragment01);
		mlList.add(welFragment02);
		mlList.add(welFragment03);
		for (int i = 0; i < mlList.size(); i++) {
			View view = new View(WelcomeActivity.this);
			view.setBackgroundResource(R.drawable.page);
			LayoutParams layoutParams = new LayoutParams(15, 15);
			layoutParams.leftMargin = 5;
			view.setLayoutParams(layoutParams);
			llPoints.addView(view);
		}
		llPoints.getChildAt(0).setBackgroundResource(R.drawable.page_now);
		
		FragmentManager manager = getSupportFragmentManager();
		adapter = new MyAdapter(manager);
		mVp.setAdapter(adapter);
		mVp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				llPoints.getChildAt(position).setBackgroundResource(R.drawable.page_now);
				llPoints.getChildAt(prePosition).setBackgroundResource(R.drawable.page);
				prePosition = position;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}
	
	class MyAdapter extends FragmentPagerAdapter{

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return mlList.get(position);
		}

		@Override
		public int getCount() {
			return mlList != null?mlList.size():0;
		}
		
	}
}
