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

	//MediaPlayer mediaPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//mediaPlayer = MediaPlayer.create(this, R.raw.lg_power);
		
		addListenerOnButtonPower();
		addListenerOnButtonChUp();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*@Override public void onDestroy() 
	{
	       //set here the media volume back to the level it was
			//before starting the application
			//I don't know if this is necessary
	}*/

	
	public void addListenerOnButtonPower() 
	{
		
		Button buttonPower = (Button) findViewById(R.id.buttonPower);
 
		buttonPower.setOnClickListener(new OnClickListener() 
		{
 
			@Override
			public void onClick(View arg0) 
			{
				//TextView textView1 = (TextView)findViewById(R.id.textView1);
				//textView1.setText("lol");
				
				//MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.lg_power);
				
				//mediaPlayer.setVolume(0.9f, 0.9f);
				
				//mediaPlayer.setDataSource(getBaseContext(), new Uri(R.raw.lg_ch_up));
				final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lg_power);
			
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() 
				{
		             @Override
		             public void onCompletion(MediaPlayer mp) 
		             {
		            	 mediaPlayer.release();
		             }
		          });   
				
				mediaPlayer.start(); // no need to call prepare(); create() does that for you
				
				//mediaPlayer.reset();
				//mediaPlayer.release();
				//mediaPlayer = null;
 
			}
 
		});
 
	}
	
	public void addListenerOnButtonChUp() 
	{
		
		Button buttonChUp = (Button) findViewById(R.id.ButtonChUp);
 
		buttonChUp.setOnClickListener(new OnClickListener() 
		{
 
			@Override
			public void onClick(View arg0) 
			{
				
				final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lg_ch_up);
			
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
