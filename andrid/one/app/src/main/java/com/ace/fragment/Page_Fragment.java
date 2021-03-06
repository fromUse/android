package com.ace.fragment;


import android.annotation.SuppressLint;
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
@SuppressLint("ValidFragment")
public class Page_Fragment extends Fragment {

    private static final String TAG = "Page_Fragment";

    private String url = null;
    private View root = null;
    private ImageView img = null;

    public Page_Fragment(String url) {
        this.url = url;
    }

    public  Page_Fragment(){
        super();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (root != null) {
            ViewGroup parent = (ViewGroup) root.getParent ();
            if (parent!=null){

                parent.removeView (root);
            }
            return root;
        }


        root = inflater.inflate (R.layout.page_item,null,false);
        img = (ImageView) root.findViewById (R.id.page_img);

        img.setTag (url);
        new ImageLoad (img).execute (url);
        return  root;
    }

}
