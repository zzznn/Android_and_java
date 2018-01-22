package com.example.fragmentlife;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment {
	//11个 生命周期方法
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		Log.d("TAG", "fragment________onAttach");
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d("TAG", "fragment________onDetach");
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("TAG", "fragment________onCreate");
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("TAG", "fragment________onDestroy");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.d("TAG", "fragment________onDestroyView");
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("TAG", "fragment________onStart");
	}
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("TAG", "fragment________onStop");
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d("TAG", "fragment________onActivityCreated");
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("TAG", "fragment________onResume");
	}
	
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("TAG", "fragment________onPause");
	}
	
	
	
	
}
