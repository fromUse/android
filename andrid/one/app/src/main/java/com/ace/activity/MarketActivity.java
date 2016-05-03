package com.ace.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ace.adapter.FragmentAdapter;
import com.ace.fragment.MarketBuyFragment;
import com.ace.fragment.MarketSellFragment;
import com.example.jia.one.R;

import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {



    private ViewPager mMarketPage = null;
    private List<Fragment> mDate = null;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
         setContentView (R.layout.market_avtivity);

         inits ();
         listeners ();
         settings ();
     }


    protected void settings() {

        mMarketPage.setAdapter (new FragmentAdapter (getSupportFragmentManager (),mDate));
    }


    protected void listeners() {
        //设置page页面切换监听事件
        mMarketPage.setOnPageChangeListener (this);
    }


    protected void inits() {
        mMarketPage = (ViewPager) findViewById (R.id.market_page);
        mDate = new ArrayList<Fragment> ();
        //添加数据到ViewPager上，
        //两个页面分别是 买和卖
        mDate.add (new MarketBuyFragment ());
        mDate.add (new MarketSellFragment ());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText (this,"滑动到了第"+position+"页",Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
