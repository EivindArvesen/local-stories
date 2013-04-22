package no.hiof.stud.localstories;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {
	public final static String EVENT_ID = "1";

	@Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	// Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_fragment, container, false);
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Fragment frag = getFragmentManager().findFragmentByTag("list_Fragment");
        final ListView listview = (ListView) frag.getView().findViewById(R.id.listView1);
	    
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
	    StableArrayAdapter adapter = new StableArrayAdapter(getActivity(),
	    		R.layout.item, R.id.label, values);
	    listview.setAdapter(adapter);

	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	      @Override
	      public void onItemClick(AdapterView<?> parent, final View view,
			int position, long id) {
			
			String ide = Search.getList().get((int) id).id+"";
			Intent intent = new Intent(getActivity(), EventActivity.class);
			intent.putExtra(EVENT_ID, ide);
			startActivity(intent);
	      }

	    });
	  }

	  private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int viewResourceId, int textViewResourceId,
	        String[] values) {
	      super(context, viewResourceId, textViewResourceId, values);
	      for (int i = 0; i < values.length; ++i) {
	        mIdMap.put(values[i], i);
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
