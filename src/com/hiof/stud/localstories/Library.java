package com.hiof.stud.localstories;

import java.util.ArrayList;

public class Library {

	public static ArrayList<Event> Events = new ArrayList<Event>();
	public static ArrayList<Picture> Pictures = new ArrayList<Picture>();
	public static void addEvent(Event evt){
		Events.add(evt);
	}
	public static void addPicture(String picture){
		Picture pic = new Picture(picture);
		Pictures.add(pic);
	}
	public static void emptyList(){
		Events = new ArrayList<Event>();
		Pictures = new ArrayList<Picture>();
	}
}
