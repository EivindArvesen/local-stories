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
		evt.setX(59.123389f);
		evt.setY(11.446778f);
		Library.addEvent(evt);
		//Event 2
		text="Goodbye World";
		date = "21.12.2012";
		keywords = "End, of,the,day,thing,programing";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(59.163389f);
		evt.setY(11.446778f);
		Library.addEvent(evt);
		//Event 3
		text="P�skekrim i Hi�s bokbad Krimforfatter Jan-Erik Fjell var gjest under bokbadet til biblioteket ved H�gskolen i �stfold 18. mars 2013.� Jeg h�per min nye bok er klar for lansering i august, sa Jan-Erik Fjell under sitt bes�k p� Remmen i ettermiddag. Snaut en uke f�r �rets p�skeferie tok krimforfatteren tilh�rerne med inn i sin skrivestue, arbeidshverdag og kontakt med forlagsbransjen. Bokbad med krim og p�skeliljer i biblioteketEt m�te med Jan-Erik Fjells hovedfigur i krimb�kene hans - Anton Brekke - ble det ogs� tid til. Jan-Erik Fjell er b�de som forfatter og radiovert kjent for � kunne formidle seg godt.I 2010 vant han Bokhandlerprisen i Norge for sin krimdebut med boka 'Tysteren'. Under samtalen ved H�gskolen i �stfold fortalte Jan-Erik Fjell �pent om hvordan han jobber seg fram � med to-tre utvalgte sparringspartnerne � kapittel for kapittel. Mord for mord.";
		date = "18.03.2013";
		keywords = "Krimforfatter,Jan-Erik,Jan,Erik,Fjell";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(59.163389f);//TODO: add correct location
		evt.setY(11.446778f);//TODO: add correct location
		Library.addEvent(evt);
		//Event 4
		text="H�gskolesenteret i Halden ble offisielt innviet 15. september 2006. Kunnskapsminister �ystein Djupedal gjorde sin entr� p� r�d l�per. H�gskoledirekt�r Birgitta R�dst�l N�ss tok imot statsr�den sammen med rektor Elin Nesje Vestli og adm. dir. i Statsbygg �ivind Christoffersen foran hovedinngangen p� Remmen.";
		date = "15.09.2006";
		keywords = "Halden, �pning, h�gskole,h�yskole, resepsjon";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(59.163389f);//TODO: add correct location
		evt.setY(11.446778f);//TODO: add correct location
		Library.addEvent(evt);
	}
	
}
