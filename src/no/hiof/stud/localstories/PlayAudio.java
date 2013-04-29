package no.hiof.stud.localstories;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class PlayAudio extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_audio);
		
		// Restrict application to portrait view only
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_event, menu);
		return true;
	}
	
	/** Called when the user clicks the Back button */
	public void backButton(View view) {
		finish();
	}
}
