package com.Kevin.day0401;

import java.util.zip.Inflater;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyPragment extends Fragment {
	
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view = inflater.inflate(R.layout.my_fragment, null);
	return view;
}

}
