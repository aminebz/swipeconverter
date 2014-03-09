package org.tinovation.swipeconverter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class SlidePagerActivity extends FragmentActivity {
	
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.viewpager_slide);

	        // Instantiate a ViewPager and a PagerAdapter.
	        mPager = (ViewPager) findViewById(R.id.pager);
	        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
	        mPager.setAdapter(mPagerAdapter);
	 }
	 
	@Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
	 
	 
	 private class SlidePagerAdapter extends FragmentStatePagerAdapter{
			

			public SlidePagerAdapter(FragmentManager fm) {
				super(fm);
			}

			
			public Fragment getItem(int position){
				return new MainPageFragment();
				
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 5;
			}
			
			
		}
	
	

}

