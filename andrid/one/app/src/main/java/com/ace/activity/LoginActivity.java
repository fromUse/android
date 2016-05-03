package com.ace.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ace.template.BasicActivity;
import com.ace.template.PUBLIC_FILE;
import com.ace.template.Top;
import com.ace.utlis.MD5;
import com.ace.utlis.StringLoad;
import com.example.jia.one.R;
import com.roger.catloadinglibrary.CatLoadingView;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends BasicActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TextWatcher {
    //LOG标记
    private static final String TAG = "LoginActivity";

    //所需控件声明
    private EditText mUserID;
    private EditText mPassword;
    private CheckBox mRemenber_pass;
    private CheckBox mAutoLogin;
    private Button login_button;
    private Top tober;
    private SharedPreferences pref;//简单的数据存储xml
    //登陆请求的url
    private String mURL = PUBLIC_FILE.BASIC_URL+ "Login/Check";

    private static final String LOGIN_SUCCESSFUL = "1";
    private static final String LOGIN_ERROR = "0";
    private String user_id = "";
    private String savePassword = "";
    private  CatLoadingView cat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView (R.layout.activity_main);

        super.onCreate (savedInstanceState);
        //此处不再需要写以下三行代码
        //因为在父类BasicActivity已经提前调用
        //super.onCreate (savedInstanceState); 千万不能删除
        //并且必须把 setContentView (R.layout.release); 放在第一行

        /*inits();
        listeners();
        settings();*/
    }


    @Override
    protected void settings() {

        //头部按钮关闭
        tober.setleftIsvisable (true);
        tober.setrightIsvisable (true);
    }

    @Override
    protected void inits() {

		/*初始化控件变量*/
        initViews ();
    }

    /*初始化控件变量*/
    private void initViews() {

        mUserID = (EditText) findViewById (R.id.user_id);
        mPassword = (EditText) findViewById (R.id.password);
        mRemenber_pass = (CheckBox) findViewById (R.id.remenber_pass);
        mAutoLogin = (CheckBox) findViewById (R.id.auto_login);
        login_button = (Button) findViewById (R.id.login);
        tober = (Top) findViewById (R.id.toper);
        pref = getSharedPreferences ("user_info_normal", Context.MODE_PRIVATE);

        //当本地已经保存密码就，并且密码没有异常就直接登陆
        final String user = pref.getString ("USERNAME","");
        final String pass = pref.getString ("PWD","");
        Log.e (TAG, "loginAction: 账户密码 "+ user+pass);
        mAutoLogin.setChecked (pref.getBoolean ("AUTO_LOGIN",false));
        if (pref.getBoolean ("FLAG_PASS",false) && !(user.equals ("")) && !(pass.equals ("")) && pref.getBoolean ("AUTO_LOGIN",false)){

           String post_param = "user_id=" + user + "&password=" + pass;
            cat = new CatLoadingView ();
            cat.show (LoginActivity.this.getSupportFragmentManager (), "登录中...");
            //当自动登陆时需要把记住密码对的状态改成true
            SharedPreferences.Editor editor = pref.edit ();
            editor.putBoolean ("FLAG_PASS", true);
            editor.commit ();
            user_id = user;
            savePassword = pass;
           new StringLoad (StringLoad.METHOD_POST) {
               @Override
               public void executeUI(String result) {

                   loginAction (result);
               }
           }.execute (mURL,post_param);

        }

        //启动activity直接获取账户密码
        //有就有没有就是空白
        mUserID.setText (pref.getString ("USERNAME", ""));

        //记住密码复选框，默认为不记住密码
        mRemenber_pass.setChecked (mAutoLogin.isChecked ());
        if (pref.getBoolean ("FLAG_PASS", false)) {

            String pwd = pref.getString ("PWD", "");
            Log.i (TAG, "当前启动获取xml的密码 ：" +pass);
            //获取md5后的密码，只是给用户一个假象
            mPassword.setText (pass.equals ("") ? "" : pwd.substring (0, 16));
            mRemenber_pass.setChecked (true);
        }

    }


    //新建一个事件处理
    @Override
    protected void listeners() {

        //登录按钮事件处理
        login_button.setOnClickListener (this);
        //监听密码输入框发生变化
        mPassword.addTextChangedListener (this);
        //监听复选框，是否记住密码
        mRemenber_pass.setOnCheckedChangeListener (this);
        ///监听自动登陆是否开启
        mAutoLogin .setOnCheckedChangeListener (this);
        tober.setOntopClickListener (new Top.topClickListener () {
            @Override
            public void leftClick() {
                Toast.makeText (LoginActivity.this, "left", Toast.LENGTH_SHORT).show ();
            }

            @Override
            public void rightClick() {
                Toast.makeText (LoginActivity.this, "right", Toast.LENGTH_SHORT).show ();
            }
        });

    }


    @Override
    public void onClick(View v) {


        int view_id = v.getId ();

        switch (view_id) {

            case R.id.login:
                  cat = new CatLoadingView ();

                user_id = mUserID.getText ().toString ();


                String mPassword_start = mPassword.getText ().toString ();

                if (mPassword_start == null || mPassword_start.equals ("")) {
                    Toast.makeText (this, "请输入账户密码", Toast.LENGTH_SHORT).show ();

                    return;
                }
                cat.show (getSupportFragmentManager (), "登录中...");
                String mPassword_end = MD5.getMD5 (mPassword_start);
                String post_param = "";

                //根据密码保存状态标志对密码进行赋值
                if ( !pref.getString ("PWD","").equals ("") ) {
                    savePassword = pref.getString ("PWD", "");
                    post_param = "user_id=" + user_id + "&password=" + savePassword;
                } else {
                    savePassword = mPassword_end ;
                    post_param = "user_id=" + user_id + "&password=" + mPassword_end;

                }

                new StringLoad (StringLoad.METHOD_POST) {
                    //在此方法更新UI
                    @Override
                    public void executeUI(String result) {
                        loginAction (result);
                    }

                }.execute (mURL, post_param);
                break;
        }

    }

    private void savePassword(String user_id, String mPasswordword) {

        if (pref != null) {

            SharedPreferences.Editor editor = pref.edit ();
            editor.putString ("USERNAME", user_id);
            editor.putString ("PWD", mPasswordword);
            editor.putBoolean ("FLAG_PASS", true);
            editor.commit ();
            Log.i (TAG, "savePassword:"+user_id+" 密码已保存"+mPasswordword);
        }
    }

    /**
     * 改变复选框的状态并且更新FLAG_PASS
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences.Editor edit = pref.edit ();
        switch (buttonView.getId ()){

            case R.id.auto_login:
                //更改自动登陆按钮

                edit.putBoolean ("AUTO_LOGIN", isChecked);
                edit.commit ();
                //这里不结束
            case R.id.remenber_pass:


            edit.putBoolean ("FLAG_PASS", isChecked);
            mRemenber_pass.setChecked (isChecked);
            Log.i (TAG, "当前密码选择的状态 ：" + pref.getBoolean ("FLAG_PASS", false));
            break;
        }
        
    }


    //输入前
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    //输入过程中
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        SharedPreferences.Editor edit = pref.edit ();
        edit.putBoolean ("FLAG_PASS", false);
        edit.putString ("PWD", "");
        edit.commit ();
        Log.i (TAG, "onTextChanged: 你正在输入的密码" + s);
    }

    //输入后
    @Override
    public void afterTextChanged(Editable s) {

    }

    private void loginAction(String result){

        if (result != null) {

            try {
                //解析json数据
                JSONObject jsonObject = new JSONObject (result  );
                //获取字段
                String flag = jsonObject.getString ("flag");
                String msg = jsonObject.getString ("msg");
                //判断flag的状态码
                Toast.makeText (LoginActivity.this, msg, Toast.LENGTH_SHORT).show ();
                if (flag.equals (LoginActivity.LOGIN_SUCCESSFUL)) {

                    if (mRemenber_pass.isChecked ()) {

                        savePassword (user_id, savePassword);
                    }
                    cat.dismiss ();
                    Intent it = new Intent (LoginActivity.this, HomeActivity.class);
                    startActivity (it);
                    LoginActivity.this.finish ();
                } else {
                    //登陆失败时把猫关掉
                    cat.dismiss ();
                }

            } catch (JSONException e) {
                e.printStackTrace ();
            }


                              Toast.makeText (LoginActivity.this,result,Toast.LENGTH_SHORT).show ();
        } else {
            Toast.makeText (LoginActivity.this, "网络貌似有问题.....", Toast.LENGTH_SHORT).show ();
            cat.dismiss ();
        }


      /*Intent it = new Intent (LoginActivity.this, HomeActivity.class);
        cat.dismiss ();
        startActivity (it);
        Toast.makeText (this,"登陆成功",Toast.LENGTH_SHORT).show ();
        LoginActivity.this.finish ();*/
    }


}


