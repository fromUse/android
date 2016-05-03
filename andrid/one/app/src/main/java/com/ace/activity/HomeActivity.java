package com.ace.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.ace.adapter.FragmentAdapter;
import com.ace.fragment.FragmentCenter;
import com.ace.fragment.FragmentLeft;
import com.ace.fragment.FragmentRight;
import com.ace.template.BasicActivity;
import com.ace.template.Bot;
import com.ace.template.Top;
import com.example.jia.one.R;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends BasicActivity implements ViewPager.OnPageChangeListener {

    //Log调试日志 标记
    private static final String TAG = "HomeActivity";
    private Top top = null;
    private Bot bottom = null;
    private ViewPager viewpage_container = null;
    private List<Fragment> mList = null;
    private ImageView page_left = null;
    private ImageView page_center = null;
    private ImageView page_right = null;


    protected void onCreate(Bundle savedInstanceState) {
        setContentView (R.layout.activity_home);
        super.onCreate (savedInstanceState);

        //此处不再需要写以下三行代码
        //因为在父类BasicActivity已经提前调用
        //super.onCreate (savedInstanceState); 千万不能删除
        //并且必须把 setContentView (R.layout.activity_home); 放在第一行
        /*inits();
        listeners();
        settings();*/

    }

    @Override
    protected void settings() {
        top.setleftIsvisable (false);
        top.setrightIsvisable (false);
        //给ViewPager设置适配器
        viewpage_container.setAdapter (new FragmentAdapter (getSupportFragmentManager (), mList));


    }

    @Override
    protected void listeners() {


        top.setOntopClickListener (new Top.topClickListener () {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });

        //监听三大页面[ 主页，社交，个人信息 ]的滑动
        viewpage_container.setOnPageChangeListener (this);

        bottom.setOnbotClickListener (new Bot.botClickListener () {
            @Override
            public void dleftClick() {
                Log.i (TAG, "dleftClick: 切换到第一页");
                viewpage_container.setCurrentItem (0);
                top.setPagerTitle ("主页");
                bottom.setAllBackgroundToNormal ();
                bottom.setLeftBackgroundResource (R.mipmap.home_on);
            }

            @Override
            public void dcentClick() {

                Log.i (TAG, "dleftClick: 切换到第二页");
                viewpage_container.setCurrentItem (1);
                top.setPagerTitle ("社交");
                bottom.setAllBackgroundToNormal ();
                bottom.setCenterBackgroundResource (R.mipmap.community_on);

            }

            @Override
            public void drightClick() {
                Log.i (TAG, "dleftClick: 切换到第三页");
                viewpage_container.setCurrentItem (2);
                top.setPagerTitle ("个人信息");
                bottom.setAllBackgroundToNormal ();
                bottom.setRightBackgroundResource (R.mipmap.user_info_on);
            }
        });


    }


    @Override
    protected void inits() {
        initVies ();
        initData ();
    }

    private void initVies() {
        top = (Top) findViewById (R.id.top);
        bottom = (Bot) findViewById (R.id.bottom);
        viewpage_container = (ViewPager) findViewById (R.id.viewpage_container);
        page_left = null;
        page_center = null;
        page_right = null;
        ListView list = null;


    }

    private void initData() {


        mList = new ArrayList<Fragment> ();
        mList.add (new FragmentLeft (this));
        mList.add (new FragmentCenter ());
        mList.add (new FragmentRight ());


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position) {
            case 0:
                top.setPagerTitle ("主页");
                bottom.setAllBackgroundToNormal ();
                bottom.setLeftBackgroundResource (R.mipmap.home_on);
                break;
            case 1:
                top.setPagerTitle ("社交");
                bottom.setAllBackgroundToNormal ();
                bottom.setCenterBackgroundResource (R.mipmap.community_on);
                break;
            case 2:
                top.setPagerTitle ("个人信息");
                bottom.setAllBackgroundToNormal ();
                bottom.setRightBackgroundResource (R.mipmap.user_info_on);
                break;

        }
        Log.i (TAG, "onPageSelected: " + position);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onPause() {
        super.onPause ();



    }
}
