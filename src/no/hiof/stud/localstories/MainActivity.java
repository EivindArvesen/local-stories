package no.hiof.stud.localstories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import no.hiof.stud.localstories.RangeSeekBar.OnRangeSeekBarChangeListener;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ZoomControls;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "no.hiof.stud.localstories.MESSAGE";
	
	private MapView         mMapView;
    private MapController   mMapController;
    ZoomControls zoom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
		// create RangeSeekBar as Date range between 1950 BCE and now
        Date minDate = null;
		try {
			minDate = new SimpleDateFormat("yyyy").parse("-1950");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Date maxDate = new Date();
        RangeSeekBar<Long> seekBar = new RangeSeekBar<Long>(minDate.getTime(), maxDate.getTime(), this);
        seekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Long>() {
                @Override
                public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Long minValue, Long maxValue) {
                        // handle changed range values
                        Log.i("LocalStories", "User selected new date range: MIN=" + new Date(minValue) + ", MAX=" + new Date(maxValue));
                }
        });

        // add RangeSeekBar to pre-defined layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.range);
        layout.addView(seekBar);
        
        // osm-code here
     	mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        
        mMapView.setClickable(true);
        mMapView.setMultiTouchControls(true);
        mMapView.setBuiltInZoomControls(true);
        
        mMapController = mMapView.getController();
        mMapController.setZoom(13);
        
        zoom = (ZoomControls) findViewById(R.id.map_zoom_controls);
        zoom.setOnZoomInClickListener(new OnClickListener() {
			
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			
    			float x = mMapView.getScaleX();
    			float y = mMapView.getScaleY();
    			
    			mMapView.setScaleX((float) (x+1));
    			mMapView.setScaleY((float) (y+1));
    		}
    	});
     
            zoom.setOnZoomOutClickListener(new View.OnClickListener() {
    			
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			
     
    			float x = mMapView.getScaleX();
    			float y = mMapView.getScaleY();
    			
    			mMapView.setScaleX((float) (x-1));
    			mMapView.setScaleY((float) (y-1));
    		}
    	});
        
        float lat   = 59.123389f;   //in DecimalDegrees
        float lng   = 11.446778f;   //in DecimalDegrees
        GeoPoint gPt = new GeoPoint((int)(lat * 1E6), (int)(lng * 1E6));
        //Centre map near to Halden
        mMapController.setCenter(gPt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DisplayMessageActivity.class);
	    EditText editText = (EditText) findViewById(R.id.edit_message);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	}

}
