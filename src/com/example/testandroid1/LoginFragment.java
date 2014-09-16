package com.example.testandroid1;

import android.R.string;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class LoginFragment extends Fragment {
	private Button postbutton;
    private EditText accountedit;
    private EditText passwordedit;
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	View view=inflater.inflate(R.layout.activity_p2, container, false);
    	accountedit=(EditText)view.findViewById(R.id.EditText02);
    passwordedit=(EditText)view.findViewById(R.id.EditText01); 
    	postbutton=(Button)view.findViewById(R.id.button3);
    postbutton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		    String account=accountedit.getText().toString().trim();
		    String password=passwordedit.getText().toString().trim();
			//SharedPreferences儲存方法
			SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPref.edit();
		    editor.putString("shareaccount",account);
		    editor.putString("sharepassword",password);
		    editor.commit(); 
		    //sql儲存方法
		    TestSQL mysql=new TestSQL(getActivity());
		    mysql.insercontent(account, password);
		    //fragment方法
			android.app.FragmentManager fragManager=getFragmentManager();
			android.app.FragmentTransaction frgTransaction=fragManager.beginTransaction(); 
			ShowFragment f=new ShowFragment();
			LoginFragment loging=(LoginFragment)fragManager.findFragmentByTag("login");//取得當下的Fragment
			frgTransaction.remove(loging);//移除當下的fragment
			frgTransaction.add(R.id.main_activity, f);//新增一個Fragment，由於當前fragment被移除，要由第一頁往上加		 
			frgTransaction.commit();
		}

	});
  
    	return view;
    }
    
}
