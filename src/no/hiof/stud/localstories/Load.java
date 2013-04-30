package no.hiof.stud.localstories;

public class Load {
	private static String header;
	private static String text;
	private static String[] pictures;
	private static String[] audio;
	private static String fdate;
	private static String tdate;
	private static String keywords;
	private static Event evt;
	public static void load(){
		Library.emptyList();
		
		// Noise-events...
		
		header="Oslo Operahus Åpning";
		text="Lorem Ipsum";
		fdate = "12.04.2008";
		tdate = "12.04.2008";
		pictures=new String[]{};
		audio=new String[]{"Åpningen"};
		keywords = "oslo, opera, åpning";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.906944f);
		evt.setLng(10.753611f);
		Library.addEvent(evt);
		
		header="Fredrikstad Grunnlegges";
		text="Lorem Ipsum";
		fdate = "01.01.1567";
		tdate = "01.01.1567";
		pictures=new String[]{};
		audio=new String[]{"Grunnleggingen"};
		keywords = "fredrikstad, grunnlegging, grunnlegges, glomma";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.220537f);
		evt.setLng(10.934701f);
		Library.addEvent(evt);
		
		header="Slaget ved Stiklestad";
		text="Lorem Ipsum";
		fdate = "29.07.1030";
		tdate = "29.07.1030";
		pictures=new String[]{"Stiklestad"};
		audio=new String[]{""};
		keywords = "olav, hellige, stiklestad, slag, haraldsson";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(63.796111f);
		evt.setLng(11.560556f);
		Library.addEvent(evt);
		
		header="Kapitulasjonsavtalen Undertegnes";
		text="Lorem Ipsum";
		fdate = "10.06.1940";
		tdate = "10.06.1940";
		pictures=new String[]{};
		audio=new String[]{""};
		keywords = "kapitulasjon, verdenskrig, norge, tyskland";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(63.430515f);
		evt.setLng(10.395053f);
		Library.addEvent(evt);
		
		header="Imperiet Slår Tilbake-filming starter i Norge";
		text="Lorem Ipsum";
		fdate = "05.03.1979";
		tdate = "05.03.1979";
		pictures=new String[]{};
		audio=new String[]{""};
		keywords = "kapitulasjon, verdenskrig, norge, tyskland";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(60.547676f);
		evt.setLng(7.448344f);
		Library.addEvent(evt);
		
		
		
		// IMPORTANT EVENTS
		
		//Event 1
		header="Påskekrim på HiOF";
		text="Påskekrim i HiOFs bokbad Krimforfatter Jan-Erik Fjell var gjest under bokbadet til biblioteket ved Høgskolen i Østfold 18. mars 2013. 'Jeg håper min nye bok er klar for lansering i august', sa Jan-Erik Fjell under sitt besøk på Remmen i ettermiddag. Snaut en uke før årets påskeferie tok krimforfatteren tilhørerne med inn i sin skrivestue, arbeidshverdag og kontakt med forlagsbransjen. Bokbad med krim og påskeliljer i biblioteketet møte med Jan-Erik Fjells hovedfigur i krimbøkene hans - Anton Brekke - ble det også tid til. Jan-Erik Fjell er både som forfatter og radiovert kjent for å kunne formidle seg godt.I 2010 vant han Bokhandlerprisen i Norge for sin krimdebut med boka 'Tysteren'. Under samtalen ved Høgskolen i Østfold fortalte Jan-Erik Fjell Åpent om hvordan han jobber seg fram med to-tre utvalgte sparringspartnerne - kapittel for kapittel. Mord for mord.";
		fdate = "18.03.2013";
		tdate = "18.03.2013";
		pictures=new String[]{"Jan-Erik Fjell"};
		audio=new String[]{};
		keywords = "Krimforfatter,Jan-Erik,Jan,Erik,Fjell,krim,hiof,bibliotek";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.129154f);
		evt.setLng(11.353394f);
		Library.addEvent(evt);
		
		//Event 2
		header="Feiring av Arbeidernes Dag, Oslo";
		text="Arbeidernes dag ble dette året også feiret på youngstorget i Oslo.";
		fdate = "01.05.2013";
		tdate = "01.05.2013";
		pictures=new String[]{"Tog", "Tale"};
		audio=new String[]{};
		keywords = "Arbeider,dag,youngstorget,oslo,mai";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.914399f);
		evt.setLng(10.74918f);
		Library.addEvent(evt);
		
		//Event 3
		header="Karl 12s Død";
		text="Karl 12 døde her.";
		fdate = "11.12.1718";
		tdate = "11.12.1718";
		pictures=new String[]{};
		audio=new String[]{"Lydguide"};
		keywords = "Karl,XII,12,død,fall,fredriksten,festning,halden";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.119946f);
		evt.setLng(11.397007f);
		Library.addEvent(evt);
		
		//Event 4
		header="Åpningen av HiOF";
		text="Høgskolesenteret i Halden ble offisielt innviet 15. september 2006. Kunnskapsminister Øystein Djupedal gjorde sin entrè på rød løper. Høgskoledirektør Birgitta Rødstøl Næss tok imot statsråden sammen med rektor Elin Nesje Vestli og adm. dir. i Statsbygg Øivind Christoffersen foran hovedinngangen på Remmen.";
		fdate = "15.09.2006";
		tdate = "15.09.2006";
		pictures=new String[]{"Kunnskapsministeren"};
		audio=new String[]{};
		keywords = "Halden,Åpning,høgskole,høyskole,resepsjon,hiof,kunnskapsminister";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.129107f);
		evt.setLng(11.352600f);
		Library.addEvent(evt);
		
		//Event 5
		header="Offisiell åpning av nye studiested Fredrikstad";
		text="Høgskolen i Østfold flyttet Avdeling for ingeniørfag til Fredrikstad.";
		fdate = "20.01.2010";
		tdate = "20.01.2010";
		pictures=new String[]{"Klipping av snor"};
		audio=new String[]{"Audio-guide"};
		keywords = "hiof,kråkerøy,fredrikstad,åpning,høgskole,høyskole,studiested,offisiell";
		evt = new Event(header,text,fdate,tdate,pictures,audio,keywords);
		evt.setLat(59.212467f);
		evt.setLng(10.931038f);
		Library.addEvent(evt);
	}
}
