package com.ace.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.ace.template.Bot;
import com.ace.template.Exit;
import com.ace.template.Top;
import com.example.jia.one.R;


public class HomeActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Top top = (Top) findViewById(R.id.top);
        top.setOntopClickListener(new Top.topClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });
        top.setleftIsvisable(false);
        top.setrightIsvisable(false);


        Bot bottom = (Bot) findViewById(R.id.bottom);
        bottom.setOnbotClickListener(new Bot.botClickListener() {
            @Override
            public void dleftClick() {
                Toast.makeText(HomeActivity.this,"hehe",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void drightClick() {
                Toast.makeText(HomeActivity.this,"hehe",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void dcentClick() {
                Toast.makeText(HomeActivity.this,"hehe",Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void onBackPressed() {

        Exit.exitonBackPressed(this);
    }
}
