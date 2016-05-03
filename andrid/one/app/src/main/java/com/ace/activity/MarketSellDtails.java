package com.ace.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ace.bean.SellBean;
import com.ace.template.BasicActivity;
import com.ace.utlis.ImageLoad;
import com.example.jia.one.R;

public class MarketSellDtails extends BasicActivity implements View.OnClickListener {

    private TextView mTitle = null;
    private TextView mContent = null;
    private TextView mPhone = null;
    private TextView mTime = null;
    private ImageView mImg = null;
    private SellBean bean = null;
    private ImageButton mSendMsg = null;
    private ImageButton mCall = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView (R.layout.sell_details);
        super.onCreate (savedInstanceState);

        Bundle bundle = getIntent ().getExtras ();

        bean = (SellBean) bundle.getSerializable ("sell_bean");

        if (bean != null) {

            //此处要设置tag，图片加载器时用tag来标识
            mImg.setTag (bean.getImgURL ());
            new ImageLoad (mImg).execute (bean.getImgURL ());

            mTitle.setText (bean.getTitle ());
            mContent.setText (bean.getContent ());
            mPhone.setText (bean.getPhone ());
            mTime.setText (bean.getTime ());
        }

    }

    @Override
    protected void settings() {

    }

    @Override
    protected void listeners() {

        mSendMsg.setOnClickListener (this);
        mCall.setOnClickListener (this);
    }

    @Override
    protected void inits() {

        mTitle = (TextView) findViewById (R.id.market_details_title);
        mContent = (TextView) findViewById (R.id.market_details_content);
        mPhone = (TextView) findViewById (R.id.market_details_phone);
        mTime = (TextView) findViewById (R.id.market_details_time);
        mSendMsg = (ImageButton) findViewById (R.id.market_details_send_msg);
        mCall = (ImageButton) findViewById (R.id.market_details_call);
        mImg = (ImageView) findViewById (R.id.market_details_img);
    }

    @Override
    public void onBackPressed() {

        finish ();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId ()){

            //跳转到短信界面
            case R.id.market_details_send_msg:

            {
                Uri smsToUri = Uri.parse ("smsto:" + bean.getPhone ());
                Intent it = new Intent (Intent.ACTION_SENDTO, smsToUri);
                it.putExtra("sms_body","\n\n\n" + "              来自 : xxx二手市场");
                startActivity (it);
            }

                break;
            //跳转到拨号
            case R.id.market_details_call:

            {
                Uri smsToUri = Uri.parse ("tel:" + bean.getPhone ());
                Intent it = new Intent (Intent.ACTION_DIAL, smsToUri);
                startActivity (it);


               /* Intent intent = new Intent("/");
                ComponentName cm = new ComponentName("com.android.settings",
                        "com.android.settings.Settings");
                intent.setComponent(cm);
                intent.setAction("android.intent.action.VIEW");
                startActivity(intent);*/
            }
                break;
        }
    }
}
