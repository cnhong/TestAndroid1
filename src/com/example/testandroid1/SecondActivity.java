package com.example.testandroid1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	private EditText textaccount;
	private EditText textpassword;
	private Button checkbutton;
	private Button clearbutton;
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p2);
		final Bundle bundle=new Bundle();
		textaccount=(EditText)findViewById(R.id.EditText02);
		textpassword=(EditText)findViewById(R.id.EditText01);
        checkbutton=(Button)findViewById(R.id.button1);
		checkbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				if(textaccount.getText().toString().equals("")||textpassword.getText().toString().equals(""))
						{
		Toast.makeText(v.getContext(), "未輸入帳號密碼", Toast.LENGTH_SHORT).show();
	          return;
						}
				bundle.putString("account",textaccount.getText().toString() );
				bundle.putString("password",textpassword.getText().toString() );
				Intent nextIntent=new Intent(SecondActivity.this, MainActivity.class);
				nextIntent.putExtras(bundle);
				setResult(RESULT_OK,nextIntent);
				finish();
			}
		});
		 clearbutton=(Button)findViewById(R.id.button2);
		 clearbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent nextIntent=new Intent(SecondActivity.this, MainActivity.class);
				setResult(RESULT_CANCELED,nextIntent);
				finish();
			}
		});
	}
}
