package com.ace.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ace.activity.MarketBuyDtails;
import com.ace.bean.BuyBean;
import com.ace.utlis.ImageLoad;
import com.example.jia.one.R;

import java.util.List;
import java.util.Set;

/**
 * Created by chen-gui on 16-4-30.
 */
public class BuyListViewAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private static final String TAG = "BuyListViewAdapter";

    private List<BuyBean> mData = null;
    private Context context = null;
    private ListView mBuyMarketListview = null;
    //可见选项的起始位置、可见最后位置
    private int mStart,mEnd;
    //数据源的所以图片url
    public static String [] URLS = null;
    private Set<ImageLoad> imageLoadManager  = null;
    private boolean loadTag = true;
    private BuyBean bean = null;
    public BuyListViewAdapter(List<BuyBean> mData, Context context, ListView mBuyMarketListview) {
        this.mData = mData;
        this.context = context;
        this.mBuyMarketListview = mBuyMarketListview;

        mBuyMarketListview.setOnItemClickListener (this);
    }

    @Override
    public int getCount() {
        return mData.size ();
    }

    @Override
    public Object getItem(int position) {
        return mData.get (position);
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

            holder = new ViewHolder ();
            //加载买模块的布局
            convertView = LayoutInflater.from (context).inflate (R.layout.list_item_buy,null);
            //将控件保存到holder上
            holder.title  = (TextView) convertView.findViewById (R.id.market_title_text);
            holder.content = (TextView) convertView.findViewById (R.id.market_content_text);
            holder.titme = (TextView) convertView.findViewById (R.id.market_time_text);

            convertView.setTag (holder);
        }else {

            holder = (ViewHolder) convertView.getTag ();
        }
        bean = mData.get (position);

        holder.title.setText (bean.getTitle ());
        //暂时
        holder.content.setText (bean.getContent ());
        holder.titme.setText (bean.getTime ());

        return convertView;
    }

    //点击item跳转到相应的详细页面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent it = new Intent (context, MarketBuyDtails.class);
        Bundle bundle = new Bundle ();
        bundle.putSerializable("buy_bean",mData.get (position));
        it.putExtras (bundle);
        context.startActivity (it);
    }


    private class ViewHolder{
        //此类封装listview中每一项item
        //具体情况看项目需求
        private TextView title = null;
        private TextView content = null;
        private TextView titme = null;
    }
    
    
}
