package com.example.testandroid1;

import android.R.fraction;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ShowFragment extends Fragment {
	private EditText sharetext;
	private EditText sqltext;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.frame_p3, container, false);
		
		//sharepreferences 找資料
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		String account = sharedPref.getString("shareaccount", null);  
		String password = sharedPref.getString("sharepassword", null);
		sharetext=(EditText)v.findViewById(R.id.editText1);
		sharetext.setText("帳號："+account +"\n"+"密碼："+password);
		
		//從sql找資料
		TestSQL mysql=new TestSQL(getActivity());
	    Cursor cs=mysql.querycontent();
		String sqlasscount=cs.getString(0);
		String sqlpassword=cs.getString(1);
		sqltext=(EditText)v.findViewById(R.id.editText2);
		sqltext.setText("sql帳號："+sqlasscount +"\n"+"sql密碼："+sqlpassword);
		return v;
	}

}
