package no.hiof.stud.localstories;

import java.util.ArrayList;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class MyOwnItemizedOverlay extends Activity{
	protected ItemizedIconOverlay<OverlayItem> mOverlay;
	protected Context mContext;
	protected Drawable mMarker;

	public MyOwnItemizedOverlay(Drawable marker, Context context) {
		mContext = context;
		ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
		ResourceProxy resourceProxy = (ResourceProxy) new DefaultResourceProxyImpl(mContext);
		mMarker = marker;

		mOverlay = new ItemizedIconOverlay<OverlayItem>(
				items, mMarker, 
				new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
			@Override public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
				return onSingleTapUpHelper(index, item);
			}
	
			@Override public boolean onItemLongPress(final int index, final OverlayItem item) {
				return true;
			}
		}, resourceProxy);

	}
	
	public boolean onSingleTapUpHelper(int i, OverlayItem item) {
		// Show clicked event in event-view...
		String ide = Search.getList().get((int) i).id+"";
		Intent intent = new Intent(mContext, EventActivity.class);
		intent.putExtra(ListFragment.EVENT_ID, ide);
		mContext.startActivity(intent);
		return true;
	}
	
	public void addItem(OverlayItem item){
		mOverlay.addItem(item);
	}
	
	public ItemizedIconOverlay<OverlayItem> getOverlay(){
		return mOverlay;
	}
}