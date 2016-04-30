package com.ace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ace.utlis.ImageLoad;
import com.example.jia.one.R;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Page_Fragment extends Fragment {


    private String url = null;
    private ImageView img = null;
    public Page_Fragment(String url) {
        this.url = url;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.page_item,null);

        img = (ImageView) view.findViewById (R.id.page_img);

        if (url!=null){
            //调用图片异步加载类
            //将url对应的图片下载回来并设置到img上
            //内置一级缓存
            new ImageLoad (img).execute (url);
        }

        return  view;
    }

}
