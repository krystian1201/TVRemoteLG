package com.example.tvremotelg;


import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends Activity
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenersOnAllButtons();
		
		setImageButtonsHighlighting();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addListenersOnAllButtons()
	{
		//ordinary buttons
		addListenerOnGivenImageButton(R.id.imageButtonPower, R.raw.lg_power);
		addListenerOnGivenImageButton(R.id.imageButtonVolUp, R.raw.lg_vol_up);
		addListenerOnGivenImageButton(R.id.imageButtonVolDown, R.raw.lg_vol_down);
		addListenerOnGivenImageButton(R.id.imageButtonChUp, R.raw.lg_ch_up);
		addListenerOnGivenImageButton(R.id.imageButtonChDown, R.raw.lg_ch_down);

		
		addListenerOnGivenImageButton(R.id.imageButton0, R.raw.lg_0);
		addListenerOnGivenImageButton(R.id.imageButton1, R.raw.lg_1);
		addListenerOnGivenImageButton(R.id.imageButton2, R.raw.lg_2);
		addListenerOnGivenImageButton(R.id.imageButton3, R.raw.lg_3);
		addListenerOnGivenImageButton(R.id.imageButton4, R.raw.lg_4);
		addListenerOnGivenImageButton(R.id.imageButton5, R.raw.lg_5);
		addListenerOnGivenImageButton(R.id.imageButton6, R.raw.lg_6);
		addListenerOnGivenImageButton(R.id.imageButton7, R.raw.lg_7);
		addListenerOnGivenImageButton(R.id.imageButton8, R.raw.lg_8);
		addListenerOnGivenImageButton(R.id.imageButton9, R.raw.lg_9);
		
	}
	
	//set ImageButtons to be highlighted when they are clicked
	public void setImageButtonsHighlighting()
	{
		//ordinary buttons
		ImageButton myImageButton = (ImageButton) findViewById(R.id.imageButtonPower);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));

		myImageButton = (ImageButton) findViewById(R.id.imageButtonVolUp);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));

		myImageButton = (ImageButton) findViewById(R.id.imageButtonVolDown);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));

		myImageButton = (ImageButton) findViewById(R.id.imageButtonChUp);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));

		myImageButton = (ImageButton) findViewById(R.id.imageButtonChDown);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		//numerical keypad
		myImageButton = (ImageButton) findViewById(R.id.imageButton0);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton1);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton2);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton3);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton4);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton5);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton6);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton7);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton8);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
		
		myImageButton = (ImageButton) findViewById(R.id.imageButton9);
		myImageButton.setOnTouchListener(new ImageButtonHighlighterOnTouchListener(myImageButton));
	}

	
	public void addListenerOnGivenImageButton(int imageButtonID, final int wavFileID) 
	{
		
		ImageButton imageButton = (ImageButton) findViewById(imageButtonID);
 
		imageButton.setOnClickListener(new OnClickListener() 
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
