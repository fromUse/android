package com.ace.template;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public  abstract class BasicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inits();
        listeners();
        settings();
        return null;
    }

    /**
     *
     * 对控件进行一些属性设置
     */
    abstract protected void settings();

    /**
     *
     * 初始化事件的绑定
     *
     */
    abstract  protected void listeners() ;

    /**
     *
     * 初始化控件，控件的绑定
     *
     */
    abstract protected void inits();
    
    
}
