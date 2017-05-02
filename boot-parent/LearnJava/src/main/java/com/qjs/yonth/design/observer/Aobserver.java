package com.qjs.yonth.design.observer;

public class Aobserver implements IObserver ,IDisplayElement{
	 private float temperature;
     private float humidity;
     private float pressure;
     private ISubject weatherData;
     
     public Aobserver(ISubject weatherData){
    	 this.weatherData=weatherData;
    	 weatherData.RegisterObserver(this);
     }

	@Override
	public void Display() {
		System.out.println("--Aobserver---"+temperature+","+humidity+","+pressure);
		
	}

	@Override
	public void Update(float temp, float humidity, float pressure) {
		this.temperature = temperature;
        this.humidity = humidity;
        this.pressure=pressure;
        Display();
	}
     
     
     
}
