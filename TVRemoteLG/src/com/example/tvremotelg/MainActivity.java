package com.example.tvremotelg;


import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		addListenerOnGivenButton(R.id.buttonPower, R.raw.lg_power);
		
		addListenerOnGivenButton(R.id.buttonChUp, R.raw.lg_ch_up);
		addListenerOnGivenButton(R.id.buttonChDown, R.raw.lg_ch_down);
		
		addListenerOnGivenButton(R.id.buttonVolUp, R.raw.lg_vol_up);
		addListenerOnGivenButton(R.id.buttonVolDown, R.raw.lg_vol_down);
		
		//numerical keypad
		addListenerOnGivenButton(R.id.button0, R.raw.lg_0);
		addListenerOnGivenButton(R.id.button1, R.raw.lg_1);
		addListenerOnGivenButton(R.id.button2, R.raw.lg_2);
		addListenerOnGivenButton(R.id.button3, R.raw.lg_3);
		addListenerOnGivenButton(R.id.button4, R.raw.lg_4);
		addListenerOnGivenButton(R.id.button5, R.raw.lg_5);
		addListenerOnGivenButton(R.id.button6, R.raw.lg_6);
		addListenerOnGivenButton(R.id.button7, R.raw.lg_7);
		addListenerOnGivenButton(R.id.button8, R.raw.lg_8);
		addListenerOnGivenButton(R.id.button9, R.raw.lg_9);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addListenerOnGivenButton(int buttonID, final int wavFileID) 
	{
		
		Button buttonChUp = (Button) findViewById(buttonID);
 
		buttonChUp.setOnClickListener(new OnClickListener() 
		{
 
			@Override
			public void onClick(View arg0) 
			{
				
				final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), wavFileID);
			
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() 
				{
		             @Override
		             public void onCompletion(MediaPlayer mp) 
		             {
		            	 mediaPlayer.release();
		             }
		          });  
				
				mediaPlayer.start(); // no need to call prepare(); create() does that for you
				
			}
 
		});
	}
	
}
