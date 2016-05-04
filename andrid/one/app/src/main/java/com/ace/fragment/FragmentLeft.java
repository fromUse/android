package com.ace.fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.ace.activity.MarketActivity;
import com.ace.adapter.FragmentAdapter;
import com.ace.template.BasicActivity;
import com.example.jia.one.R;

import java.util.ArrayList;
import java.util.List;

import afor.com.two.RepairActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLeft extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {


    //此Fragment下的页面容器ViewGroup
    private View root = null;
    //Log调试日志 标记
    private static final String TAG = "FragmentLeft";
    private ViewPager notice_page = null;
    private List<Fragment> mList = null;
    private ImageView point_left = null;
    private ImageView point_center = null;
    private ImageView point_right = null;
    private BasicActivity context = null;
    private ImageButton option_first = null;
    private ImageButton option_seconed = null;
    private ImageButton option_thrid = null;
    private ImageButton option_four = null;
    private int index = 0;
    private AsyncTask<Void, Integer, Void> mTaskpic = null;
    private boolean mTaskTag = true;
    private Handler handler = new Handler () {

        @Override
        public void handleMessage(Message msg) {

            notice_page.setCurrentItem (msg.arg1, true);
            Log.i (TAG, "doInBackground: 当前pager :" + msg.arg1);

        }

    };

    public FragmentLeft(BasicActivity context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //判断是否时第二次调用onCreate
        if (root != null) {
            ViewGroup parent = (ViewGroup) root.getParent ();
            if (parent != null) {

                parent.removeView (root);
            }
            return root;
        }
        root = inflater.inflate (R.layout.page_left, null);

        inits ();
        settings ();
        listeners ();
        return root;
    }


    private void settings() {
        //给ViewPager设置适配器
        notice_page.setAdapter (new FragmentAdapter (context.getSupportFragmentManager (), mList));

    }


    private void listeners() {

        notice_page.setOnPageChangeListener (this);

        //轮询播放公告的幻灯片
        timerChangeIMG ();

        option_first.setOnClickListener (this) ;

        option_thrid.setOnClickListener (this);

        option_seconed.setOnClickListener (this);

        option_four.setOnClickListener (this);
    }

    private void timerChangeIMG() {

        new Thread () {

            @Override
            public void run() {
                while (true) {

                    if (!mTaskTag) {
                        break;
                    }
                    try {

                        Thread.sleep (3000);
                        index++;
                        index = index % 3;
                        Message msg = new Message ();
                        msg.arg1 = index;
                        handler.sendMessage (msg);

                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }


            }
        }.start ();


       /* mTaskpic = new AsyncTask<Void, Integer, Void> () {
            @Override
            protected Void doInBackground(Void... params) {

                int count = 0;
                 index = 0;
                while(true){

                    if (!mTaskTag) {
                        break;
                    }
                    try {
                        Thread.sleep (3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }

                    index++;
                    index = index % 3;
                    publishProgress (index);

                }
                return null;
            }


            @Override
            protected void onProgressUpdate(Integer... values) {
                notice_page.setCurrentItem (values[0],true);
                Log.i (TAG, "doInBackground: 当前pager :"+values[0]);
            }
        };


        mTaskpic.execute ();*/


    }


    private void inits() {
        initVies ();
        initData ();
    }

    private void initVies() {
        //新闻公告页
        notice_page = (ViewPager) root.findViewById (R.id.notice_viewpage);

        //公告下面的三个小圆点
        point_left = (ImageView) root.findViewById (R.id.point_left);
        point_center = (ImageView) root.findViewById (R.id.point_center);
        point_right = (ImageView) root.findViewById (R.id.point_right);

        //主页的四大功能
        option_first = (ImageButton) root.findViewById (R.id.option_first);
        option_seconed = (ImageButton) root.findViewById (R.id.option_seconed);
        option_thrid = (ImageButton) root.findViewById (R.id.option_thrid);
        option_four = (ImageButton) root.findViewById (R.id.option_four);

    }

    private void initData() {
        mList = new ArrayList<Fragment> ();

        //循环多少次具体看服务器数据源
       /* for (int i = 0; i < 3; i++) {
            //这里具体填图片url地址，当值为null时，显示系统默认图片
            mList.add (new Page_Fragment ("http://www.swvtc.cn/UploadFiles/2014-10/admin/2014101715330643173.jpg"));
        }*/

        mList.add (new Page_Fragment ("http://www.swvtc.cn/UploadFiles/2014-10/admin/2014101715330643173.jpg"));
        mList.add (new Page_Fragment ("http://www.swvtc.cn/UploadFiles/2014-10/admin/2014101715332694727.jpg"));
        mList.add (new Page_Fragment ("http://www.swvtc.cn/UploadFiles/2014-10/admin/201410171532295159.jpg"));


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //当pager滑动完成后，即手指松开后
    //回调此方法
    @Override
    public void onPageSelected(int position) {

        point_left.setImageResource (R.mipmap.point_normal);
        point_center.setImageResource (R.mipmap.point_normal);
        point_right.setImageResource (R.mipmap.point_normal);
        switch (position + 1) {

            case 1:
                //滑动公共时同时切换到相应的小图标
                point_left.setImageResource (R.mipmap.point_on);
                //同时也修改轮询播放的的位置改成当前位置
                index = 0;
                break;
            case 2:
                point_center.setImageResource (R.mipmap.point_on);
                index = 1;
                break;
            case 3:
                point_right.setImageResource (R.mipmap.point_on);
                index = 2;
                break;
        }
    }

    //
    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onPause() {
        super.onPause ();
        //把公论循环播放终止
        mTaskTag = false;
        Log.i (TAG, "onStop: " + "  ----------------  " + mTaskTag);
    }

    @Override
    public void onResume() {
        super.onResume ();
        //公告轮循播放
        mTaskTag = true;
        timerChangeIMG ();
    }

    @Override
    public void onClick(View v) {

        Intent it = null;

        switch (v.getId ()){

            case R.id.option_first:

                 it = new Intent (getContext (), MarketActivity.class);
                 getActivity ().startActivity (it);

            break;

            case R.id.option_seconed:
                Toast.makeText (getContext (),"由于开发时间紧张，本模块尚未完善,你可以点击查看电脑维护或者二手市场",Toast.LENGTH_LONG).show ();
                break;

            case R.id.option_thrid:
                it = new Intent (getContext (),RepairActivity.class);
                startActivity (it);
                break;

            case R.id.option_four:
                Toast.makeText (getContext (),"由于开发时间紧张，本模块尚未完善,你可以点查看电脑维护或者二手市场",Toast.LENGTH_LONG).show ();
                break;
        }
    }
}
