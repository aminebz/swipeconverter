package org.tinovation.swipeconverter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainPageFragment extends Fragment {
	
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_page, container, false);
	        return rootView;
	  }
	  
}
