package no.hiof.stud.localstories;

import java.util.ArrayList;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.tileprovider.LRUMapTileCache;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.util.CloudmadeUtil;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.OverlayItem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
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
    
    MyItemizedOverlay myItemizedOverlay = null;
    MyOwnItemizedOverlay myOwnItemizedOverlay = null;
    
    public Boolean showLocation = false;    
	
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
	    
	    CloudmadeUtil.retrieveCloudmadeKey(getActivity());
	    mMapView.setTileSource(TileSourceFactory.CLOUDMADESTANDARDTILES); // previously MAPNIK
	    
	    // Increase cache
	    final MapTileProviderBase mapTileProvider = this.mMapView.getTileProvider();
	    int pCapacity=35;
	    mapTileProvider.ensureCapacity(pCapacity);
	    LRUMapTileCache capacity = new LRUMapTileCache(pCapacity);
	    capacity.ensureCapacity(pCapacity);
	    
	    mMapView.setMultiTouchControls(true);
	    mMapView.setBuiltInZoomControls(true);
	
	    mMapController = mMapView.getController();
	    
	    GeoPoint gPt= decimalDegreesToGeoPoint(MainActivity.lat, MainActivity.lng);
	    
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
        
    	mMapController.setZoom(13);
	    //mMapController.setCenter(gPt);
	    mMapController.animateTo(gPt);
        
        // Add overlays for current position and relevant events (default args or results from search)
        addOverlayCurrentPosition(gPt);
        addOverlays();
    }

    /**
     * An appropriate place to override and add overlays.
     * @param gPt = current position
     */
    
    protected void addOverlayCurrentPosition(GeoPoint gPt) {
    	Drawable marker=getResources().getDrawable(android.R.drawable.btn_star_big_on);
    	int iconColor = android.graphics.Color.rgb(38, 181, 225);
    	marker.setColorFilter( iconColor, Mode.SRC_ATOP );
    	
        int markerWidth = marker.getIntrinsicWidth();
        int markerHeight = marker.getIntrinsicHeight();
        marker.setBounds(0, markerHeight, markerWidth, 0);
         
        ResourceProxy resourceProxy = new DefaultResourceProxyImpl(getActivity());
         
        myItemizedOverlay = new MyItemizedOverlay(marker, resourceProxy);
        
        Fragment frag = getFragmentManager().findFragmentByTag("map_Fragment");
	    mMapView = (MapView) frag.getView().findViewById(R.id.mapview);
        mMapView.getOverlays().add(myItemizedOverlay);
         
        myItemizedOverlay.addItem(gPt, "currentPosition", "currentPosition");
    }
    
    protected void addOverlays() {
    	Drawable marker=getResources().getDrawable(android.R.drawable.star_big_on);
        int markerWidth = marker.getIntrinsicWidth();
        int markerHeight = marker.getIntrinsicHeight();
        marker.setBounds(0, markerHeight, markerWidth, 0);
         
        myOwnItemizedOverlay = new MyOwnItemizedOverlay(marker, getActivity());
        
        Fragment frag = getFragmentManager().findFragmentByTag("map_Fragment");
	    mMapView = (MapView) frag.getView().findViewById(R.id.mapview);
        mMapView.getOverlays().add(myOwnItemizedOverlay.getOverlay());
        
        ArrayList<Event> events = Search.getList();
        Log.i("LocalStories", "Events size: "+events.size());
	    for(int i=0; i<events.size(); i++){
	    	GeoPoint eventPoint = decimalDegreesToGeoPoint((float) events.get(i).getLat(), (float) events.get(i).getLng());
	    	myOwnItemizedOverlay.addItem(new OverlayItem("Event " + i, "Event " + i, eventPoint));
	    	
	    	// Listener for clicks on events...	    	
	    	//eventId = mMapView.findViewById(myItemizedOverlay.getId());
	    	//myItemizedOverlay.onTouchEvent(event, mMapView);
	    	    	
	    	//Log.i("LocalStories", "marker: ");
	    	/*.setOnClickListener(new OnClickListener() {
		         @Override
		         public void onClick(View v) {
		                 Log.i("LocalStories", "Clicked on event!");  
		         }
			 });*/
	    }
    }
    
    protected static GeoPoint decimalDegreesToGeoPoint(float lat, float lng)
    {
    	return new GeoPoint((int)(lat * 1E6), (int)(lng * 1E6));
    }
}
