package com.events.time;

import java.util.Random;

public class PseudoTime{
	final String time;
	
	public PseudoTime(String time){
		this.time = genTime();
	}
	
public static String genTime(){
	 Random gen = new Random();
	 int hour = gen.nextInt(23);
	 int minute = gen.nextInt(59);
	 String time;
	 if(minute < 10){
		time = "" +hour +":0" +minute;  
	 }else{
	 time = "" + hour + ":" + minute;
	 }
	 return time;
	}
}