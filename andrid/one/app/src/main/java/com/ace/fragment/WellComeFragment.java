package com.ace.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WellComeFragment extends Fragment {


    private View root = null;
    private int layout;
    public WellComeFragment(int layout) {
        this.layout = layout;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (root!=null)
        {
            ViewGroup parent = (ViewGroup) root.getParent ();

            if (parent != null) {
                parent.removeView (root);
            }
            return  root;
        }

        root = inflater.inflate (layout,null);

        return root;
    }

}
