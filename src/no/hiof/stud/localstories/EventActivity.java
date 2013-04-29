package no.hiof.stud.localstories;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class EventActivity extends FragmentActivity {
	private static Event event = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		// Restrict application to portrait view only
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Intent intent = getIntent();
	    String message = intent.getStringExtra(resultPageActivity.EVENT_ID);
	    int id= Integer.parseInt(message);
	    EventActivity.setEvent(Library.Events.get(id));
	    
	    TextView EventHeader = (TextView) findViewById(R.id.EventHeader);
	    EventHeader.setText(getEvent().header);
	    
	    // Create new fragment and transaction => osmdroid
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ArticleFragment fragment = new ArticleFragment();
        
        // Adding
        fragmentTransaction.add(R.id.fragment_container, fragment, "event_article_Fragment");
        
        // Commiting
        fragmentTransaction.commit();
        
        // Execute pending operations (commit) IMMEDEATELY
        fragmentManager.executePendingTransactions();
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
	
	/** Called when the user clicks the "Article" button */
	public void mapView(View view) {
		// Create new fragment and transaction => osmdroid
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ArticleFragment fragment = new ArticleFragment();

        // Replacing
        fragmentTransaction.replace(R.id.fragment_container, fragment, "event_article_Fragment");
        fragmentTransaction.addToBackStack(null);
        
        // Commiting
        fragmentTransaction.commit();
        
        // Execute pending operations (commit) IMMEDEATELY
        fragmentManager.executePendingTransactions();
	}

	public static Event getEvent() {
		return event;
	}

	public static void setEvent(Event event) {
		EventActivity.event = event;
	}

}
