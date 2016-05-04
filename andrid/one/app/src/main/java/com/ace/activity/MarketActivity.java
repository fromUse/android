package com.ace.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ace.adapter.FragmentAdapter;
import com.ace.fragment.MarketBuyFragment;
import com.ace.fragment.MarketSellFragment;
import com.example.girdviewtest.ReleaseActivity;
import com.example.jia.one.R;

import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {


    private static final String TAG = "MarketActivity";

    public ViewPager mMarketPage = null;
    private List<Fragment> mDate = null;
    private FloatingActionButton mFab = null;
    private int mPagePosition = 0;
    private TextView mBuy = null;
    private TextView mSell = null;
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
        mFab.setOnClickListener (this);
    }


    protected void inits() {
        mMarketPage = (ViewPager) findViewById (R.id.market_page);
        mBuy = (TextView) findViewById (R.id.market_buy);
        mSell = (TextView) findViewById (R.id.market_sell);
        mFab = (FloatingActionButton) findViewById (R.id.fab);
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
        mPagePosition = position;
        Log.i (TAG, "onPageSelected:        :"  + position);
        mBuy.setTextSize (18);
        mSell.setTextSize (18);

        switch (position){
            case 0:
                mBuy.setTextSize (25);
                break;
            case 1:
                mSell.setTextSize (25);
                break;


        }

        /*Toast.makeText (this,"滑动到了第"+position+"页",Toast.LENGTH_SHORT).show ();*/
    }

    @Override
    public void onPageScrollStateChanged(int state) {

        //正在滑动
        if (ViewPager.SCROLL_STATE_IDLE == state){

            //按钮放大动画
            ObjectAnimator.ofFloat (mFab,"scaleX",0,1.0F).setDuration (100).start ();
            ObjectAnimator.ofFloat (mFab,"scaleY",0,1.0F).setDuration (100).start ();
            mFab.setVisibility (View.VISIBLE);

        }else if (ViewPager.SCROLL_STATE_DRAGGING == state)
        {
            //按钮缩小动画
            ObjectAnimator.ofFloat (mFab,"scaleX",1.0f,0).setDuration (100).start ();
            ObjectAnimator.ofFloat (mFab,"scaleY",1.0f,0).setDuration (100).start ();

        }

    }

    @Override
    public void onClick(View v) {

        switch (mPagePosition){
            case 0:
            {
             //   Toast.makeText (MarketActivity.this, "点击发布购买页面", Toast.LENGTH_SHORT).show ();
                Intent it = new Intent (this, ReleaseActivity.class);
                startActivity (it);
            }
                break;
            case 1:
               // Toast.makeText (MarketActivity.this, "点击发布出售页面", Toast.LENGTH_SHORT).show ();
            {
                Intent it = new Intent (this, ReleaseActivity.class);
                startActivity (it);
            }
                break;



        }
    }
}
