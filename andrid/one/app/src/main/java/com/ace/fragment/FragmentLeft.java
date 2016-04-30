package com.ace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ace.adapter.FragmentAdapter;
import com.ace.template.BasicActivity;
import com.example.jia.one.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLeft extends Fragment implements ViewPager.OnPageChangeListener {


    private View root = null;
    //Log调试日志 标记
    private ViewPager notice_page = null;
    private List<Fragment> mList = null;
    private ImageView point_left = null;
    private ImageView point_center = null;
    private ImageView point_right = null;
    private BasicActivity context  = null;


    public FragmentLeft(BasicActivity context) {
      this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate (R.layout.page_left,null);

        inits ();
        settings ();
        listeners ();
        return root;
    }


    private void settings() {
        //给ViewPager设置适配器
        notice_page.setAdapter (new FragmentAdapter (context.getSupportFragmentManager (),mList));

    }


    private void listeners() {

        notice_page.setOnPageChangeListener (this);
    }


    private void inits() {
        initVies();
        initData();
    }

    private void initVies() {
        notice_page = (ViewPager) root.findViewById (R.id.notice_page);
        point_left = (ImageView) root.findViewById (R.id.point_left);
        point_center = (ImageView) root.findViewById (R.id.point_center);
        point_right = (ImageView) root.findViewById (R.id.point_right);
    }

    private void initData() {
        mList = new ArrayList<Fragment> ();

        //循环多少次具体看服务器数据源
        for (int i = 0; i < 3; i++) {
            //这里具体填图片url地址，当值为null时，显示系统默认图片
            mList.add (new Page_Fragment (null));
        }


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        point_left.setImageResource (R.mipmap.point_normal);
        point_center.setImageResource (R.mipmap.point_normal);
        point_right.setImageResource (R.mipmap.point_normal);
        switch (position + 1){

            case 1:
                point_left.setImageResource (R.mipmap.point_on);
                break;
            case 2:
                point_center.setImageResource (R.mipmap.point_on);
                break;
            case 3:
                point_right.setImageResource (R.mipmap.point_on);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
