package com.hiof.stud.localstories;

public class Picture {
	private static int idd=0;
	public int id;
	public String address;
	public Picture(String adrs){
		id=idd;
		idd++;
		address=adrs;
	}
}
