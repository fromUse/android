package com.ace.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.ace.adapter.FragmentAdapter;
import com.ace.fragment.WellComeFragment;
import com.ace.template.BasicActivity;
import com.ace.utlis.ZoomOutPageTransformer;
import com.example.jia.one.R;

import java.util.ArrayList;
import java.util.List;

public class WellComePage extends BasicActivity implements ViewPager.OnPageChangeListener {

    private List<Fragment> mData = null;
    private Button mBt_go = null;
    private ViewPager wellcome_page = null;
    private SharedPreferences pref = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

         pref = getSharedPreferences ("user_info_normal", Context.MODE_PRIVATE);

        boolean  isFirstStart = pref.getBoolean ("FIRST_START",true);

        if (!isFirstStart) {
            Intent it = new Intent (this,HomeActivity.class);
            startActivity (it);
            finish ();
        }

        setContentView (R.layout.activity_well_come_page);
        super.onCreate (savedInstanceState);

    }

    @Override
    protected void settings() {

        wellcome_page.setAdapter (new FragmentAdapter (getSupportFragmentManager (),mData));
        wellcome_page.setPageTransformer(true, new ZoomOutPageTransformer ());
    }

    @Override
    protected void listeners() {
        wellcome_page.setOnPageChangeListener (this);
    }

    @Override
    protected void inits() {

        mBt_go = (Button) findViewById (R.id.bt_go);
        wellcome_page = (ViewPager) findViewById (R.id.wellcome_page);
        mData = new ArrayList<Fragment> ();

       mData.add (new WellComeFragment (R.layout.wellcome_page1));
       mData.add (new WellComeFragment (R.layout.wellcome_page2));
       mData.add (new WellComeFragment (R.layout.wellcome_page3));
       mData.add (new WellComeFragment (R.layout.wellcome_page4));

    }

    @Override
    public void onBackPressed() {
        finish ();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if (position + 1 == mData.size ()){


            ObjectAnimator.ofFloat (mBt_go,"scaleX",0,1.0F).setDuration (100).start ();
            ObjectAnimator.ofFloat (mBt_go,"scaleY",0,1.0F).setDuration (100).start ();
            mBt_go.setVisibility (View.VISIBLE);
        }else {

                ObjectAnimator.ofFloat (mBt_go,"scaleX",1.0f,0).setDuration (100).start ();
                ObjectAnimator.ofFloat (mBt_go,"scaleY",1.0f,0).setDuration (100).start ();
                mBt_go.setVisibility (View.GONE);

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {



    }

    public void go(View view){

    //    Toast.makeText (this,"跳转到主页",Toast.LENGTH_SHORT).show ();
        SharedPreferences.Editor editor = pref.edit ();
        editor.putBoolean ("FIRST_START",false);
        editor.commit ();
        Intent it = new Intent (this,HomeActivity.class);
        startActivity (it);
        finish ();
    }
}
