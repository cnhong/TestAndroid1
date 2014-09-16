package com.example.testandroid1;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {
	private Button showbutton;
	private Button changebutton;
	private ImageButton imageButton1;
	private TextView showaccount;
	private TextView showpasswode;
	private static final int EDIT=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showbutton = (Button)findViewById(R.id.button1);
        showaccount=(TextView)findViewById(R.id.textView1);
        showpasswode=(TextView)findViewById(R.id.textView2);
        //顯示訊息
        showbutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//(誰呼叫(目標是誰)，顯示訊息，時間長短)
				Toast.makeText(v.getContext(), "Toast", Toast.LENGTH_SHORT).show();
			}
		});
        
        imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
        //按圖片跳轉下一頁
        imageButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                //跳轉下頁intebt(a,b)--a頁跳到b頁				
				Intent nextIntent=new Intent(MainActivity.this, SecondActivity.class);
				startActivity(nextIntent);
			}
		});
        changebutton = (Button)findViewById(R.id.button2);
        changebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();  // 取得FragmentManager（如果不向下相容，就不用加Support）
                android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                LoginFragment f = new LoginFragment();  // 把上面的FragmentA new出來！
                fragmentTransaction.add(R.id.main_activity, f,"login");  // 丟入到llParent之中,給新增的fragment加入tag
                fragmentTransaction.commit(); // 必須commit以後才會真正add
            }
        });
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
               super.onActivityResult(requestCode, resultCode, data);

               if(resultCode == RESULT_OK){
                showaccount.setText("帳號："+data.getStringExtra("account"));
                showpasswode.setText("密碼："+data.getStringExtra("password"));
               }else if(resultCode == RESULT_CANCELED)
               {
            	   showaccount.setText("尚未登入！！");
               }
    }
    }
