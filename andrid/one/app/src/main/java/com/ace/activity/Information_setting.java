package com.ace.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ace.template.BasicActivity;
import com.ace.template.PUBLIC_FILE;
import com.example.jia.one.R;

/**
 * Created by Administrator on 2016/5/4 0004.
 */
public class Information_setting extends BasicActivity {


    private  String url = PUBLIC_FILE.BASIC_URL + "Mobile/User/info";
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        SharedPreferences pref = getSharedPreferences ("user_info_normal", Context.MODE_PRIVATE);

        String user = pref.getString ("USERNAME","");
        String pass = pref.getString ("PWD","");

        if( !pref.getBoolean ("FLAG_PASS",false) || (user.equals ("")) || (pass.equals (""))){

            Intent intent = new Intent (this,LoginActivity.class);

            startActivity (intent);
            finish ();

        }


        setContentView(R.layout.information_setting);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void settings() {

    }

    @Override
    protected void listeners() {

    }

    @Override
    protected void inits() {

    }

    @Override
    public void onBackPressed() {
        finish ();
    }


    public void cancel_info(View view){
        finish ();
    }

    //具体保存逻辑看项目实际情况
    public void save_info(View view){
        Toast.makeText (this,"保存成功",Toast.LENGTH_SHORT).show ();
        finish ();
    }
}
