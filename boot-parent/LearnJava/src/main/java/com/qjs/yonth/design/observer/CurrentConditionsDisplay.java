package com.qjs.yonth.design.observer;

public class CurrentConditionsDisplay implements IObserver,IDisplayElement{
	 private float temperature;
     private float humidity;
     private ISubject weatherData;

     public CurrentConditionsDisplay(ISubject weatherData)
     {
         this.weatherData = weatherData;
         weatherData.RegisterObserver(this);
     }

     public void Update(float temperature, float humidity, float pressure)
     {
         this.temperature = temperature;
         this.humidity = humidity;
         Display();
     }
     public void Display()
     {
         System.out.println("--CurrentConditionsDisplay--"+"Current coditions: " + temperature + "F degress and " + humidity + "% humidity");
     }
}
