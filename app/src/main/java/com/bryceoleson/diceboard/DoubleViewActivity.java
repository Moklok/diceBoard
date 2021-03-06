package com.bryceoleson.diceboard;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DoubleViewActivity extends Activity {
    /** Called when the activity is first created. */
	AnimationDrawable animation;
	AnimationDrawable animation1;
	private MediaPlayer diceRoll;
	int rand_1 = 0;
	int rand_2 = 0;
	private Handler handler; // used to sync the delay
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.bryceoleson.diceboard.R.layout.dview);

        diceRoll = MediaPlayer.create(this, com.bryceoleson.diceboard.R.raw.dice);
		handler = new Handler();

		final ImageView dice1 = (ImageView) findViewById(com.bryceoleson.diceboard.R.id.imageView1);
		final ImageView dice2 = (ImageView) findViewById(com.bryceoleson.diceboard.R.id.imageView2);
		final TextView outcome1 = (TextView) findViewById(com.bryceoleson.diceboard.R.id.outcome1);
		final TextView outcome2 = (TextView) findViewById(com.bryceoleson.diceboard.R.id.outcome2);
		final TextView total = (TextView) findViewById(com.bryceoleson.diceboard.R.id.total);


		animation = new AnimationDrawable();
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w1), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w2), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w3), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w4), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w5), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w1), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w2), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w3), 80);
		animation.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.w0), 80);
		animation.setOneShot(true);

		rand_1 = (int) Math.round(Math.random() * 5);
		dice1.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_white1 + rand_1);


		animation1 = new AnimationDrawable();

		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r5), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r1), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r2), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r3), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r1), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r2), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r3), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r4), 80);
		animation1.addFrame(getResources().getDrawable(com.bryceoleson.diceboard.R.drawable.r0), 80);
		animation1.setOneShot(true);

		rand_2 = (int) Math.round(Math.random() * 5);
		dice2.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_red1 + rand_2);


		final ImageView imageAnim = (ImageView) findViewById(com.bryceoleson.diceboard.R.id.imageView1);
		imageAnim.setBackgroundDrawable(animation);

		final ImageView imageAnim1 = (ImageView) findViewById(com.bryceoleson.diceboard.R.id.imageView2);
		imageAnim1.setBackgroundDrawable(animation1);

		dice1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				total.setText("");
		 		diceRoll.start();
				dice1.setImageBitmap(null);
				dice2.setImageBitmap(null);
				imageAnim.post(animation);
				imageAnim1.post(animation1);
				handler.postDelayed(new Runnable() {
					public void run() {
						rand_1 = (int) Math.round(Math.random() * 5);
						dice1.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_white1 + rand_1);
						outcome1.setText(" # "+ String.valueOf(rand_1 + 1));
						rand_2 = (int) Math.round(Math.random() * 5);
						dice2.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_red1 + rand_2);
						outcome2.setText(" # "+ String.valueOf(rand_2 + 1));
						total.setText("Total # "+ String.valueOf((rand_1 + 1)+(rand_2 + 1)));

					}
				}, 800);

			}

		});

		dice2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				total.setText("");
				diceRoll.start();
				dice1.setImageBitmap(null);
				dice2.setImageBitmap(null);
				imageAnim.post(animation);
				imageAnim1.post(animation1);
				handler.postDelayed(new Runnable() {
					public void run() {
						rand_1 = (int) Math.round(Math.random() * 5);
						dice1.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_white1 + rand_1);
						outcome1.setText(" # "+ String.valueOf(rand_1 + 1));
						rand_2 = (int) Math.round(Math.random() * 5);
						dice2.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_red1 + rand_2);
						outcome2.setText(" # "+ String.valueOf(rand_2 + 1));
						total.setText("Total # "+ String.valueOf((rand_1 + 1)+(rand_2 + 1)));
						
					}
				}, 800);

			}

		});

    }
}