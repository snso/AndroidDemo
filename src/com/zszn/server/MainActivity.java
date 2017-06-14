package com.zszn.server;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.zszn.custom.view.Topbar;
import com.zszn.custom.view.Topbar.topbarClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        Topbar topbar = (Topbar) findViewById(R.id.topbar);
        topbar.setOnTopbarClickListener(new topbarClickListener() {
			
			@Override
			public void rightClick() {
				Toast.makeText(MainActivity.this, "ÓÒ±ß", Toast.LENGTH_SHORT).show();
				
			}
			
			@Override
			public void leftClick() {
				Toast.makeText(MainActivity.this, "×ó±ß", Toast.LENGTH_SHORT).show();
				
			}
		});
    }

}
