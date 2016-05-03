package com.ace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jia.one.R;
import com.roger.catloadinglibrary.GraduallyTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCenter extends Fragment {

    public FragmentCenter() {
        // Required empty public constructor
    }

    private View root = null;
    private GraduallyTextView graduallyTextView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (root != null) {
            ViewGroup parent = (ViewGroup) root.getParent ();
            if (parent!=null){

                parent.removeView (root);
            }
            return root;
        }
        root = inflater.inflate (R.layout.page_center,null);

        graduallyTextView = (GraduallyTextView) root.findViewById (R.id.graduallyTextView);

        return root;
    }


    @Override
    public void onResume() {
        graduallyTextView.startLoading ();
        super.onResume ();

    }

    @Override
    public void onStop() {
        graduallyTextView.stopLoading ();
        super.onStop ();
    }
}
