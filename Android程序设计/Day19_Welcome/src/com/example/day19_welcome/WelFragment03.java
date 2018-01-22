package com.example.day19_welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class WelFragment03 extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_wel03, null);
		ImageButton btn = (ImageButton) view.findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),MainActivity.class));
				getActivity().finish();
				SharedPreferences sp = getActivity().getSharedPreferences("Tag", 0);
				Editor editor = sp.edit();
				editor.putBoolean("isFrist", false);
				editor.commit();
			}
		});
		
		return view;
	}

}
