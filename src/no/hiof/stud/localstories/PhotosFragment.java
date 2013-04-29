package no.hiof.stud.localstories;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PhotosFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	// Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_photos_fragment, container, false);
    }
	
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Fragment frag = getFragmentManager().findFragmentByTag("event_photos_Fragment");	    
	    ListView AudioList = (ListView) frag.getView().findViewById(R.id.listView3);
	    String[] audio = EventActivity.getEvent().pictures;
	    
	    String[] values = new String[audio.length];
	    for(int i=0; i<audio.length; i++){
	    	values[i] = audio[i];
	    }

	    StableArrayAdapter adapter = new StableArrayAdapter(getActivity(),
	    		R.layout.item, R.id.label, values);
	    AudioList.setAdapter(adapter);
	    
	    AudioList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
				int position, long id) {
				
				String ide = Search.getList().get((int) id).id+"";
				Intent intent = new Intent(getActivity(), DisplayPhoto.class);
				intent.putExtra(EventActivity.EVENT_ID, ide);
				startActivity(intent);
		      }

		    });
	}
	
	public class StableArrayAdapter extends ArrayAdapter<String> {

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
