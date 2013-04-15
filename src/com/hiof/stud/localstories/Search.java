package com.hiof.stud.localstories;

import java.util.ArrayList;

public class Search {
	private ArrayList<Event> events;
	//Location
	public double locX=0;
	public double locY=0;
	public double distance=0;
	//Time
	public int yearFrom=0;
	public int yearTo=0;
	//Text
	public String freeText = "";
	
	public void setYear(int from, int to){
		yearFrom=from;
		yearTo=to;
	}
	public void setText(String txt){
		freeText=txt;
	}
	public void setLocation(double x,double y, double dist){
		locX=x;
		locY=y;
		distance=dist;
	}
	
	public void resetSearch(){
		locX=0;
		locY=0;
		distance=0;
		yearFrom=0;
		yearTo=0;
		freeText = "";
		events = new ArrayList<Event>();
	}
	public void start(){
		events = (ArrayList<Event>) Library.Events.clone();
		yearFilter();
		locationFilter();
		if(freeText!="") freeTextFilter();
		
	}
	public ArrayList<Event> getList(){
		return events;
	}
	
	//Filters out events based on yearFrom and yearTo
	private void yearFilter(){
		for(int i=0; i<events.size();i++){
			Event evt = events.get(i);
			if(evt.year<yearFrom || evt.year>yearTo){
				events.remove(i);
				i--;
			}
		}
		
	}

	//Filters out events based on freeText
	private void freeTextFilter(){
		boolean wordMatch = false;
		String[] txt = freeText.split(" ");
		for(int i=0; i<events.size();i++){
			Event evt = events.get(i);
			wordMatch = false;
			//Keyword filter
			for(int s=0; s<txt.length; s++){
				for(int r=0; r<evt.keywords.length; r++){
					if(txt[s]==evt.keywords[r]) wordMatch = true;
				}
			}
			//Text filter
			for(int s=0; s<txt.length; s++){
				
				if(evt.text.indexOf(txt[s])!=-1) wordMatch = true;
				
			}
			//FILTERING
			if(!wordMatch){
				events.remove(i);
				i--;
			}
			
		}
		
	}

	//Filters out events based on location
	private void locationFilter(){
		for(int i=0; i<events.size();i++){
			Event evt = events.get(i);
			//Phytagoras
			double kat1 = Math.pow(Math.abs(locX-evt.getX()),2.0);
			double kat2 = Math.pow(Math.abs(locY-evt.getY()),2.0);
			double dist = Math.sqrt(kat1+kat2);
			
			if(dist>distance){
				events.remove(i);
				i--;
			}
		}
	}


}
