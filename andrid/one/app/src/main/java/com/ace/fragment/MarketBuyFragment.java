package com.ace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ace.adapter.BuyListViewAdapter;
import com.ace.bean.BuyBean;
import com.ace.template.PUBLIC_FILE;
import com.ace.utlis.StringLoad;
import com.example.jia.one.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarketBuyFragment extends Fragment implements AdapterView.OnItemClickListener {

    private View root = null;
    private ListView mBuyMarketListview = null;
    private List<BuyBean> mBuyData = null;
    private String url = PUBLIC_FILE.BASIC_URL + "Market/buy";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (root != null) {
            ViewGroup parent = (ViewGroup) getView ().getParent ();
            if (parent != null) {
                parent.removeView (root);

            }
            return root;
        }

        root = inflater.inflate (R.layout.market_container,null);


        inits ();
        settings ();
        listeners ();

        return root;
    }

    private void listeners() {
        mBuyMarketListview.setOnItemClickListener (this);
    }

    private void settings() {

    }

    private void inits() {

        mBuyMarketListview = (ListView) root.findViewById (R.id.market_listview);
        mBuyData = new ArrayList<BuyBean> ();

        new StringLoad (StringLoad.METHOD_GET) {
            @Override
            public void executeUI(String result) {

                if (result != null) {

                    try {

                        JSONArray jsonArray = new JSONArray (result);
                        for (int i = 0; i < jsonArray.length (); i++) {
                            JSONObject jsonObject =jsonArray.getJSONObject (i);
                            String id = jsonObject.getString ("id");
                            String user_id = jsonObject.getString ("user_id");
                            String title  =jsonObject.getString ("title");
                            String content = jsonObject.getString ("content");
                            String time = jsonObject.getString ("time");
                            String phone = jsonObject.getString ("phone");
                            BuyBean item = new BuyBean (id,time,phone,content,title,user_id);
                            mBuyData.add (item);

                        }


                    } catch (JSONException e) {
                        e.printStackTrace ();
                    }

                    mBuyMarketListview.setAdapter (new BuyListViewAdapter (mBuyData,getContext (),mBuyMarketListview));
                }else {
                    Toast.makeText (getContext (),"网络貌似有问题...",Toast.LENGTH_LONG).show ();
                }



            }
        }.execute (url);


    }


    //ListView条目点击事件的回调方法
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText (getContext (),"你点击了第 :"+position,Toast.LENGTH_SHORT).show ();
    }
}
