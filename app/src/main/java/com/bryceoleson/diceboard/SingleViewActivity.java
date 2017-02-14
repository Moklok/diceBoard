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

public class SingleViewActivity extends Activity {
	/** Called when the activity is first created. */
	AnimationDrawable animation;
	private MediaPlayer diceRoll;
	int rand_1 = 0;
	int rand_2 = 0;
	private Handler handler; // used to sync the delay
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.bryceoleson.diceboard.R.layout.sview);

		diceRoll = MediaPlayer.create(this, com.bryceoleson.diceboard.R.raw.dice);
		handler = new Handler();

		final ImageView dice1 = (ImageView) findViewById(com.bryceoleson.diceboard.R.id.imageView1);
		final TextView outcome1 = (TextView) findViewById(com.bryceoleson.diceboard.R.id.outcome1);


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


		final ImageView imageAnim = (ImageView) findViewById(com.bryceoleson.diceboard.R.id.imageView1);
		imageAnim.setBackgroundDrawable(animation);

		dice1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				diceRoll.start();
				dice1.setImageBitmap(null);
				// run the start() method later on the UI thread
				imageAnim.post(animation);
				handler.postDelayed(new Runnable() {
					public void run() {
						rand_1 = (int) Math.round(Math.random() * 5);
						dice1.setImageResource(com.bryceoleson.diceboard.R.drawable.dice_white1 + rand_1);
						outcome1.setText("Face Value: # "+ String.valueOf(rand_1 + 1));
						rand_2 = (int) Math.round(Math.random() * 5);

					}
				}, 800);

			}

		});

	}
}