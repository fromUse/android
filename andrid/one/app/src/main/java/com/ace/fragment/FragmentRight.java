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
public class FragmentRight extends Fragment {

    private View root = null;


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

        View root = inflater.inflate (R.layout.page_right,null);

        return root;
    }


}
