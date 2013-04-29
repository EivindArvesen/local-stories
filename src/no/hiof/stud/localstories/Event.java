package no.hiof.stud.localstories;

public class Event {
	public int id;
	private static int idcount=0;
	public String header;
	public String text;
	public String[] pictures;
	public String[] audio;
	//Year
	public int day=0;
	public int month=0;
	public int year=0;
	//Location [Posibly temp]
	private double x=0;
	private double y=0;
	//
	public String[] keywords;
	
	public Event(String head, String txt, String date, String[] pics, String[] sounds, String keys){
		id=idcount;
		idcount++;
		header=head;
		text=txt;
		pictures=pics;
		audio=sounds;
		String[] dte=date.split("[.]");
		if(dte.length==3){
			day = Integer.parseInt(dte[0]);
			month = Integer.parseInt(dte[1]);
			year =  Integer.parseInt(dte[2]);
		}
		keywords = keys.split(",");
	}

	public double getLat(){
		return x;
	}
	public double getLng(){
		return y;
	}
	public void setLat(double xx){
		x=xx;
	}
	public void setLng(double yy){
		y=yy;
	}
}
