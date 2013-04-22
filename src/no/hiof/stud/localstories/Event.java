package no.hiof.stud.localstories;

public class Event {
	public int id;
	private static int idcount=0;
	public String text;
	public int[] pictures;
	//Year
	public int day=0;
	public int month=0;
	public int year=0;
	//Location [Posibly temp]
	private double x=0;
	private double y=0;
	//
	public String[] keywords;
	
	public Event(String txt, String date, int[] pics, String keys){
		id=idcount;
		idcount++;
		text=txt;
		pictures=pics;
		String[] dte=date.split("[.]");
		if(dte.length==3){
			day = Integer.parseInt(dte[0]);
			month = Integer.parseInt(dte[1]);
			year =  Integer.parseInt(dte[2]);
		}
		keywords = keys.split(",");
	}

	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double xx){
		x=xx;
	}
	public void setY(double yy){
		y=yy;
	}
}
