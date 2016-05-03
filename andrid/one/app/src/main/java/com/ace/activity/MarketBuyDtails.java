package com.ace.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ace.bean.BuyBean;
import com.ace.template.BasicActivity;
import com.example.jia.one.R;

public class MarketBuyDtails extends BasicActivity implements View.OnClickListener {

    private TextView mTitle = null;
    private TextView mContent = null;
    private TextView mPhone = null;
    private TextView mTime = null;
    private BuyBean  bean = null;
    private ImageButton mSendMsg = null;
    private ImageButton mCall = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView (R.layout.buy_details);
        super.onCreate (savedInstanceState);

        Bundle bundle = getIntent ().getExtras ();

        bean = (BuyBean) bundle.getSerializable ("buy_bean");
        if (bean != null) {
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
                Intent it = new Intent (android.content.Intent.ACTION_SENDTO, smsToUri);
                it.putExtra("sms_body","\n\n\n" + "              来自 : xxx二手市场");
                startActivity (it);
            }

                break;
            //跳转到拨号
            case R.id.market_details_call:

            {
                Uri smsToUri = Uri.parse ("tel:" +bean.getPhone ());
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
