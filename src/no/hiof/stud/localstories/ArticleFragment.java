package no.hiof.stud.localstories;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	// Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_article_fragment, container, false);
    }
	
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Fragment frag = getFragmentManager().findFragmentByTag("event_article_Fragment");	    
	    TextView EventText = (TextView) frag.getView().findViewById(R.id.EventText);
        EventText.setText(EventActivity.getEvent().text);
	  }
}
