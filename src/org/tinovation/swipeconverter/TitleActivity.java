package org.tinovation.swipeconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TitleActivity extends Activity {
	
	protected Spinner type;
	protected Spinner units;
	protected EditText number;
	protected Button calc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
		
		number = (EditText)findViewById(R.id.numberbox);
		
		type = (Spinner)findViewById(R.id.type);
		ArrayAdapter<CharSequence> types = ArrayAdapter.createFromResource(this, R.array.Types, android.R.layout.simple_spinner_item);
		types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		type.setAdapter(types);
		
		type.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
				if(parent.getItemAtPosition(pos).equals("Temperature")){
					units = (Spinner)findViewById(R.id.units);
					ArrayAdapter<CharSequence> temp_units = ArrayAdapter.createFromResource(TitleActivity.this, R.array.Temperature, android.R.layout.simple_spinner_item);
					temp_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					units.setAdapter(temp_units);
				}
				else if(parent.getItemAtPosition(pos).equals("Distance")){
					units = (Spinner)findViewById(R.id.units);
					ArrayAdapter<CharSequence> dis_units = ArrayAdapter.createFromResource(TitleActivity.this, R.array.Distance, android.R.layout.simple_spinner_item);
					dis_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					units.setAdapter(dis_units);
				}
				else if(parent.getItemAtPosition(pos).equals("Mass")){
					units = (Spinner)findViewById(R.id.units);
					ArrayAdapter<CharSequence> mass_units = ArrayAdapter.createFromResource(TitleActivity.this, R.array.Mass, android.R.layout.simple_spinner_item);
					mass_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					units.setAdapter(mass_units);
				}
				else if(parent.getItemAtPosition(pos).equals("Speed")){
					units = (Spinner)findViewById(R.id.units);
					ArrayAdapter<CharSequence> speed_units = ArrayAdapter.createFromResource(TitleActivity.this, R.array.Speed, android.R.layout.simple_spinner_item);
					speed_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					units.setAdapter(speed_units);
				}
			}
			
			public void onNothingSelected(AdapterView<?> parent){
				//implement later
			}
			
			
		});
		
		calc = (Button)findViewById(R.id.calculate);
		calc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				final Animation out = new AlphaAnimation(1.0f,0.0f);
				units = (Spinner)findViewById(R.id.units);
				out.setDuration(1000);
				type.startAnimation(out);
				units.startAnimation(out);
				calc.startAnimation(out);
				number.startAnimation(out);
				
				
				// Animation stuff for fade out effect
//				Animation fadeOut = new AlphaAnimation(1,0);
//				fadeOut.setInterpolator(new AccelerateInterpolator());
//				fadeOut.setDuration(1000);
//				
//			
//				AnimationSet animation = new AnimationSet(false);
//			    animation.addAnimation(fadeOut);
//			   
//			    calc.setAnimation(animation);
				
				//check if we entered something
				
				out.setAnimationListener(new Animation.AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						if(number.getText().toString().length() > 0){
							Intent intent = new Intent(TitleActivity.this,SlidePagerActivity.class);
							startActivity(intent);
						}
					}
				});
				
				

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.title, menu);
		return true;
	}

}
