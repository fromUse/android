package com.ace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jia.one.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCenter extends Fragment {


    public FragmentCenter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.page_center,null);
        return view;
    }

}
