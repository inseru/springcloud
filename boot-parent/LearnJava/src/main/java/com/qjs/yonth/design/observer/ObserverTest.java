package com.qjs.yonth.design.observer;

public class ObserverTest {
	
	    public static void main(String[] args) {
	    	WeatherData war=new WeatherData();
	    	CurrentConditionsDisplay ob=new CurrentConditionsDisplay(war);
	    	Aobserver a=new Aobserver(war);
	    	war.SetMeasurements(1, 2, 3);

		}
}
