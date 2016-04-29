package com.ace.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ace.template.Exit;
import com.ace.template.Top;
import com.example.jia.one.R;

public class LoginActivity extends Activity{

    //所需控件声明
    EditText snumber;
    EditText pass;
    CheckBox rememberpwd_check;
    Button regbutton;
    ProgressBar progressBar;
    /*TextView view_tishi;*/
    //变量
    SharedPreferences pref;//简单的数据存储
    Handler handler;//线程手柄


    static final int STOP = 0x111;//完成进度消息ID
    static final int CONTINUE = 0x112;//继续显示进度条消息ID
    static final int MAX = 100;//最大进度为100% 完成进度
    int progress;//当前进度条进度




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        //新建一个事件处理
        setListeners();
        //头部登录
        Top tober = (Top) findViewById(R.id.toper);
        tober.setOntopClickListener(new Top.topClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(LoginActivity.this,"hehe",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(LoginActivity.this,"hehe",Toast.LENGTH_SHORT).show();
            }
        });
        //头部按钮关闭
        tober.setleftIsvisable(false);
        tober.setrightIsvisable(false);
    }


    public void init(){

		/*初始化控件变量*/
        initViews();
		/*初始化线程手柄*/
        initHandler();
    }

    /*初始化控件变量*/
    void initViews(){

        snumber = (EditText) findViewById (R.id.snumber);
        pass = (EditText) findViewById (R.id.pass);
        rememberpwd_check = (CheckBox) findViewById (R.id.remcheckBox);
        regbutton = (Button) findViewById (R.id.regbutton);
        progressBar = (ProgressBar)findViewById(R.id.progressBar) ;
        pref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        if(pref.getBoolean("REMBERPWD",false)){//记住密码标示为否
            //将文件内键值及类型返回并输出
            snumber.setText(pref.getString("USERNAME", ""));
            pass.setText(pref.getString("PWD",""));
        }else{
            //置空
            snumber.setText("");
            pass.setText("");
        }
        //记住密码将数据存储的键值及返回类型用boolean保存
        rememberpwd_check.setChecked(pref.getBoolean("REMBERPWD", false));
        progress = 0;//进度条初始化为零
		 /*进度条初始化初始值及最大值*/
        progressBar.setProgress(progress);
        progressBar.setMax(MAX);
    }

    /*初始化线程手柄*/
    void initHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch(msg.what){

				/*进度未完成*/
                    case CONTINUE:
                        //判断线程是否正在运行
                        if(! Thread.currentThread().isInterrupted()){
                            progressBar.setProgress(progress);
                        }
                        break;
			    /*进度已完成*/
                    case STOP:
                        //线程完成

                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        LoginActivity.this.finish();
                        startActivity(intent);
                }
            }
        };
    }



    //新建一个事件处理
    public void setListeners(){




        //登录按钮事件处理
        regbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //获取用户名密码转化成字符串
                String username = snumber.getText().toString();
                String userpwd = pass.getText().toString();
                if((! username.equals(pref.getString("USERNAME","123")))||(! userpwd.equals(pref.getString("PWD", "123")))){
                    Toast.makeText(LoginActivity.this,"用户名或密码不正确",Toast.LENGTH_LONG).show();
                }else{
					/*用户名密码都正确的情况下*/
                    //新建一个编辑器
                    SharedPreferences.Editor editor = pref.edit();
                    //判断记住密码是否打钩
                    if(rememberpwd_check.isChecked()){
                        editor.putString("USERNAME",username);
                        editor.putString("PWD",userpwd);
                        editor.putBoolean("REMBERPWD", true);//记住密码标示为ture
                        editor.commit();
                    }else{
                        editor.putBoolean("REMBERPWD", false);//记住密码标示为false
                        editor.commit();
                    }

					/*控件不可用*/
                    snumber.setEnabled(false);
                    pass.setEnabled(false);
                    regbutton.setEnabled(false);

					/*显示进度条为五秒*/
                    progressBar.setVisibility(View.VISIBLE);
                   /* view_tishi.setVisibility(View.VISIBLE);*/
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try{
								/*循环五次，每次一秒*/
                                for(int i = 0;i < 5;i++){
                                    progress = (i+1) * 20;
                                    Thread.sleep(1000);//一秒
                                    if(i == 4){
                                        Message msg = new Message();
                                        msg.what = STOP;
                                        handler.sendMessage(msg);
                                        break;
                                    }else{
                                        Message msg = new Message();
                                        msg.what = CONTINUE;
                                        handler.sendMessage(msg);
                                    }
                                }
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    /*重写onBackPressed()方法*/
    @Override
    public void onBackPressed() {

        Exit.exitonBackPressed(this);
    }


}




