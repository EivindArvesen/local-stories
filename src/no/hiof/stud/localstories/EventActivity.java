package no.hiof.stud.localstories;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class EventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		Intent intent = getIntent();
	    String message = intent.getStringExtra(resultPageActivity.EVENT_ID);
	    int id= Integer.parseInt(message);
	    Event event= Library.Events.get(id);
	    TextView EventText = (TextView) findViewById(R.id.EventText);
        EventText.setText(event.text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_event, menu);
		return true;
	}

}
