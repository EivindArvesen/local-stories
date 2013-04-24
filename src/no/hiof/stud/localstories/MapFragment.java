package no.hiof.stud.localstories;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.util.constants.MapViewConstants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ZoomControls;

public class MapFragment extends Fragment {
	private MapView         mMapView;
    private MapController   mMapController;

    ZoomControls zoom;
    
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	// Inflate the layout for this fragment
        return inflater.inflate(R.layout.map_fragment, container, false);
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // OSMdroid-code here
        Fragment frag = getFragmentManager().findFragmentByTag("map_Fragment");
	    mMapView = (MapView) frag.getView().findViewById(R.id.mapview);
	    mMapView.setTileSource(TileSourceFactory.MAPNIK);
	
	    //mMapView.setClickable(true);
	    mMapView.setMultiTouchControls(true);
	    mMapView.setBuiltInZoomControls(true);
	
	    mMapController = mMapView.getController();
	    
	    GeoPoint gPt = new GeoPoint((int)(MainActivity.lat * 1E6), (int)(MainActivity.lng * 1E6));
	    // Centre map near to Halden
	    mMapController.setZoom(13);
	    mMapController.setCenter(gPt);
	    
	    //mMapController.animateTo(gPt);
	    
	    zoom = (ZoomControls) frag.getView().findViewById(R.id.map_zoom_controls);
	    zoom.setOnZoomInClickListener(new OnClickListener() {
     	
     	@Override
     	public void onClick(View v) {
     		mMapController.setZoom(mMapView.getZoomLevel()+1);
     		Log.i("LocalStories", "Zoom level now: " + mMapView.getZoomLevel());
     		}
     	});
      
        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
     			
     	@Override
     	public void onClick(View v) {
     		mMapController.setZoom(mMapView.getZoomLevel()-1);
     		Log.i("LocalStories", "Zoom level now: " + mMapView.getZoomLevel());
	     	}
	     });
    }

    /**
     * An appropriate place to override and add overlays.
     */
    protected void addOverlays() {
        //
    }
}
