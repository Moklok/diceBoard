package com.bryceoleson.diceboard;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableRow;

public class SplashActivity1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.bryceoleson.diceboard.R.layout.main);

        TableRow tableRow2 = (TableRow) findViewById(com.bryceoleson.diceboard.R.id.tableRow2);
		TableRow tableRow4 = (TableRow) findViewById(com.bryceoleson.diceboard.R.id.tableRow4);
		TableRow tableRow7 = (TableRow) findViewById(com.bryceoleson.diceboard.R.id.tableRow7);

		tableRow2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(SplashActivity1.this,SingleViewActivity.class);
				startActivity(myIntent);

			
			}
		});
		tableRow4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(SplashActivity1.this,DoubleViewActivity.class);
				startActivity(myIntent);

			
			}
		});
		tableRow7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(SplashActivity1.this,TripleViewActivity.class);
				startActivity(myIntent);

			
			}
		});
    }
}