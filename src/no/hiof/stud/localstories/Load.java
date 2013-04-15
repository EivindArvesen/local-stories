package no.hiof.stud.localstories;

public class Load {
	private static String text;
	private static int[] pictures;
	private static String date;
	private static String keywords;
	private static Event evt;
	public static void load(){
		Library.emptyList();
		//Event 1
		text="Hello World";
		date = "09.04.2013";
		keywords = "Hello,World,day,thing,programing";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(100.0);
		evt.setY(100.0);
		Library.addEvent(evt);
		//Event 2
		text="Goodbye World";
		date = "21.12.2012";
		keywords = "End, of,the,day,thing,programing";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(-100.0);
		evt.setY(-100.0);
		Library.addEvent(evt);
	}
	
}
