package com.ace.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by chen-gui on 16-4-30.
 */
public class ListVIewAdapter extends BaseAdapter {

    List<String> mImgUrl = null;

    @Override
    public int getCount() {
        return mImgUrl.size ();
    }

    @Override
    public Object getItem(int position) {
        return mImgUrl.get (position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null){

            //此处写具体控件的b绑定与设置属性


            convertView.setTag (holder);
        }else {

            holder = (ViewHolder) convertView.getTag ();
        }

        return null;
    }

    private class ViewHolder{
        //此类封装listview中每一项item
        //具体情况看项目需求
    }
}
