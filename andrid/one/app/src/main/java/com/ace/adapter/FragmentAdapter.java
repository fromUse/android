package com.ace.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by chen-gui on 16-4-30.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> mList = null;

    public FragmentAdapter(FragmentManager fm,List<Fragment> mList) {
        super (fm);
        this.mList  = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get (position);
    }

    @Override
    public int getCount() {
        return mList.size ();
    }
}
