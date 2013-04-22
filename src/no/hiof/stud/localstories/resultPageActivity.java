//TEST PAGE
//TODO:
//Add result list
//Design displaying
//Add clicking


package no.hiof.stud.localstories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;
import android.view.View;

public class ResultPageActivity extends Activity {
	public final static String EVENT_ID = "1";

		  @Override
		  protected void onCreate(Bundle savedInstanceState) {

			    Log.i("LocalStories", "1");
		    super.onCreate(savedInstanceState);

		    setContentView(R.layout.activity_result_page);

		    Log.i("LocalStories", "2");
		    
		    final ListView listview = (ListView) findViewById(R.id.listView1);
		    
		    ArrayList<Event> events = Search.getList();
		    String[] values = new String[events.size()];
		    for(int i=0; i<events.size(); i++){
		    	values[i] = events.get(i).text;
		    	
		    }
		    
		    
		    
		    /*String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
		        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
		        "Android", "iPhone", "WindowsMobile" };*/

		    final ArrayList<String> list = new ArrayList<String>();
		    for (int i = 0; i < values.length; ++i) {
		      list.add(values[i]);
		    }

		    Log.i("LocalStories", "3");
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		    		R.layout.item, R.id.label, values);
		    listview.setAdapter(adapter);

		    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
				int position, long id) {
				
				String ide = Search.getList().get((int) id).id+"";
				Intent intent = new Intent(getApplicationContext(), EventActivity.class);
				intent.putExtra(EVENT_ID, ide);
				startActivity(intent);
		      }

		    });
		  }

		  private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }

		    @Override
		    public long getItemId(int position) {
		      String item = getItem(position);
		      return mIdMap.get(item);
		    }

		    @Override
		    public boolean hasStableIds() {
		      return true;
		    }

		  }

		} 