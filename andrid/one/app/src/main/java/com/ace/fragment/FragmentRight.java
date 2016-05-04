package com.ace.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ace.activity.Information_about;
import com.ace.activity.Information_notice;
import com.ace.activity.Information_setting;
import com.example.jia.one.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRight extends Fragment implements View.OnClickListener {

    private View root = null;
    private LinearLayout userinof_layout = null;
    private LinearLayout notice_layout = null;
    private LinearLayout update_layout = null;
    private LinearLayout about_us_layout = null;
    private LinearLayout unlogin_layout = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (root != null) {

            ViewGroup parent = (ViewGroup) root.getParent ();
            if (parent != null) {
                parent.removeView (root);
            }
            return  root;

        }

         root = inflater.inflate (R.layout.information,null);

        init();
        linster();

        return root;
    }

    //设置点击事件
    private void linster() {

        userinof_layout.setOnClickListener (this);
        notice_layout.setOnClickListener (this);
        update_layout.setOnClickListener (this);
        about_us_layout.setOnClickListener (this);
        unlogin_layout.setOnClickListener (this);
    }

    //初始化控件，控件绑定
    private void init() {
        userinof_layout = (LinearLayout) root.findViewById (R.id.user_info_layout);
        notice_layout   = (LinearLayout) root.findViewById (R.id.notice_layout);
        update_layout   = (LinearLayout) root.findViewById (R.id.update_layout);
        about_us_layout = (LinearLayout) root.findViewById (R.id.about_us_about);
        unlogin_layout  = (LinearLayout) root.findViewById (R.id.unlogin_layout);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId ()){


            case R.id.user_info_layout:

                 intent = new Intent(getContext (),Information_setting.class);
                startActivity(intent);

                break;

            case R.id.notice_layout:
                intent = new Intent (getContext (), Information_notice.class);
                startActivity(intent);
                break;

            case R.id.update_layout:

                Toast toast = Toast.makeText(getContext (),"恭喜你，已经是最新版本!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastView = (LinearLayout) toast.getView();
                ImageView imageCodeProject = new ImageView(getContext ());
                imageCodeProject.setImageResource(R.mipmap.ic_launcher);
                toastView.addView(imageCodeProject, 0);
                toast.show();
                break;
            case R.id.about_us_about:

                intent = new Intent(getContext (), Information_about.class);
                startActivity(intent);
                break;

            case R.id.unlogin_layout:

                break;


        }

    }
}



