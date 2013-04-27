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
		text="Påskekrim i HiOFs bokbad Krimforfatter Jan-Erik Fjell var gjest under bokbadet til biblioteket ved Høgskolen i Østfold 18. mars 2013. 'Jeg håper min nye bok er klar for lansering i august', sa Jan-Erik Fjell under sitt besøk på Remmen i ettermiddag. Snaut en uke før årets påskeferie tok krimforfatteren tilhørerne med inn i sin skrivestue, arbeidshverdag og kontakt med forlagsbransjen. Bokbad med krim og påskeliljer i biblioteketet møte med Jan-Erik Fjells hovedfigur i krimbøkene hans - Anton Brekke - ble det også tid til. Jan-Erik Fjell er både som forfatter og radiovert kjent for å kunne formidle seg godt.I 2010 vant han Bokhandlerprisen i Norge for sin krimdebut med boka 'Tysteren'. Under samtalen ved Høgskolen i Østfold fortalte Jan-Erik Fjell Åpent om hvordan han jobber seg fram med to-tre utvalgte sparringspartnerne - kapittel for kapittel. Mord for mord.";
		date = "18.03.2013";
		keywords = "Krimforfatter,Jan-Erik,Jan,Erik,Fjell";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(59.163389f);//TODO: add correct location
		evt.setY(11.446778f);//TODO: add correct location
		Library.addEvent(evt);
		//Event 4
		text="Høgskolesenteret i Halden ble offisielt innviet 15. september 2006. Kunnskapsminister Øystein Djupedal gjorde sin entrè på rød løper. Høgskoledirektør Birgitta Rødstøl Næss tok imot statsråden sammen med rektor Elin Nesje Vestli og adm. dir. i Statsbygg Øivind Christoffersen foran hovedinngangen på Remmen.";
		date = "15.09.2006";
		keywords = "Halden, Åpning, høgskole,høyskole, resepsjon";
		evt = new Event(text,date,pictures,keywords);
		evt.setX(59.163389f);//TODO: add correct location
		evt.setY(11.446778f);//TODO: add correct location
		Library.addEvent(evt);
	}
	
}
