package no.hiof.stud.localstories;

public class Event {
	public int id;
	private static int idcount=0;
	public String header;
	public String text;
	public String[] pictures;
	public String[] audio;
	//From-Date
	public int fromDay=0;
	public int fromMonth=0;
	public int fromYear=0;
	//To-Date
		public int toDay=0;
		public int toMonth=0;
		public int toYear=0;
	//Location [Posibly temp]
	private double x=0;
	private double y=0;
	//
	public String[] keywords;
	
	public Event(String head, String txt, String fromDate, String toDate, String[] pics, String[] sounds, String keys){
		id=idcount;
		idcount++;
		header=head;
		text=txt;
		pictures=pics;
		audio=sounds;
		String[] fDte=fromDate.split("[.]");
		if(fDte.length==3){
			fromDay = Integer.parseInt(fDte[0]);
			fromMonth = Integer.parseInt(fDte[1]);
			fromYear =  Integer.parseInt(fDte[2]);
		}
		String[] tDte=toDate.split("[.]");
		if(tDte.length==3){
			toDay = Integer.parseInt(tDte[0]);
			toMonth = Integer.parseInt(tDte[1]);
			toYear =  Integer.parseInt(tDte[2]);
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
