package com.ace.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ace.activity.MarketSellDtails;
import com.ace.bean.SellBean;
import com.ace.utlis.ImageLoad;
import com.example.jia.one.R;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chen-gui on 16-4-30.
 */
public class SellListViewAdapter extends BaseAdapter implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {

    private static final String TAG = "BuyListViewAdapter";

    private List<SellBean> mData = null;
    private Context context = null;
    private ListView mBuyMarketListview = null;
    //可见选项的起始位置、可见最后位置
    private int mStart,mEnd;
    //数据源的所以图片url
    public static String [] URLS = null;
    private SellBean bean = null;
    private Set<ImageLoad> imageLoadManager  = null;
    private boolean loadTag = true;

    public SellListViewAdapter(List<SellBean> mData, Context context, ListView mBuyMarketListview) {
        this.mData = mData;
        this.context = context;
        this.mBuyMarketListview = mBuyMarketListview;

        mBuyMarketListview.setOnItemClickListener (this);
        mBuyMarketListview.setOnScrollListener(this);
   /*     mBuyMarketListview.setOnScrollListener (this);*/
        imageLoadManager = new HashSet<ImageLoad> ();

        URLS = new String[mData.size ()];
        for (int i = 0; i <mData.size () ; i++) {
            URLS[i] = mData.get (i).getImgURL ();
        }
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
            convertView = LayoutInflater.from (context).inflate (R.layout.list_item_sell,null);

            holder.img = (ImageView) convertView.findViewById (R.id.market_image);
            holder.title  = (TextView) convertView.findViewById (R.id.market_title_text);
            holder.price = (TextView) convertView.findViewById (R.id.market_price_text);
            holder.time = (TextView) convertView.findViewById (R.id.market_time_text);
            convertView.setTag (holder);
        }else {

            holder = (ViewHolder) convertView.getTag ();
        }
        bean = mData.get (position);
        //图片还没在福曲奇获取所有先用系统自带的图片
        holder.title.setText (bean.getTitle ());
        holder.price.setText ( "价格" +bean.getPrice ());
        holder.time.setText (bean.getTime ());

        holder.img.setTag (bean.getImgURL ());
        //设置默认图片
        holder.img.setImageResource (R.mipmap.ic_launcher);
        ImageLoad load =  new ImageLoad (holder.img);
        load.execute (bean.getImgURL ());


        return convertView;
    }

    //滑动状态改时调用

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        Log.i (TAG, "onScrollStateChanged: -----------滑动状态发生改变----------");
        if (scrollState == SCROLL_STATE_IDLE) {
            //加载可见项
            loadImage2 (mStart,mEnd);
        }else {
            //停止加载
            unLoad();
        }

    }



    //一直被调用
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //可见的第一项
        mStart = firstVisibleItem;
        //可见项的地第一项到可见最后一项
        mEnd = firstVisibleItem + visibleItemCount;

        if(loadTag && visibleItemCount >0){
            loadImage2 (mStart,mEnd);
            loadTag = false;
        }
    }



    /**
     *
     * 当滑动停止的时候才记载图片
     *
     * @param start
     * @param end
     */

    private void loadImage2(int start,int end){

        for (int i = start; i <end ; i++) {
            String url = this.URLS[i];
            //通过url标记获取指定的可见项
            ImageView imgView = (ImageView) mBuyMarketListview.findViewWithTag (url);
            ImageLoad load= new ImageLoad (imgView);
            load.execute (url);
            Log.i (TAG, "loadImage2: ------加载可见项--------");
            imageLoadManager.add (load);
        }

    }



    /**
     *
     * 当正在滑时，就终止所有异步任务
     */

    private void unLoad() {
        if (imageLoadManager != null) {
            for (ImageLoad load : imageLoadManager){
                load.cancel (true);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent it = new Intent (context, MarketSellDtails.class);
        Bundle bundle = new Bundle ();
        bundle.putSerializable("sell_bean",mData.get (position));
        it.putExtras (bundle);
        context.startActivity (it);

    }


    private class ViewHolder{
        //此类封装listview中每一项item
        //具体情况看项目需求
        private ImageView img = null;
        private TextView title = null;
        private TextView price = null;
        private TextView time = null;
    }
    
    
}
