package com.qjs.yonth.design.observer;

import java.util.ArrayList;

/**
 * 天气实现类
 * @author Administrator
 *
 */
public class WeatherData implements ISubject{
	 private ArrayList<IObserver> observers;
     private float temperature;
     private float humidity;
     private float pressure;

     public WeatherData()
     {
         observers = new ArrayList();//初始化obervers，用来存储注册的观察者
     }

     /// <summary>
     /// 注册观察者
     /// </summary>
     /// <param name="o"></param>
     public void RegisterObserver(IObserver o)
     {
         observers.add(o);
     }

    /// <summary>
    /// 删除观察者
     /// </summary>
     /// <param name="o"></param>
     public void RemoveObserver(IObserver o)
    {
         int i = observers.indexOf(o);
         if (i >= 0)
             observers.remove(o);
     }

     /// <summary>
     /// 通知观察者
     /// </summary>
     public void NotifyObervers(){
         for(IObserver o : observers){
             o.Update(temperature, humidity, pressure);
         }
     }

     /// <summary>
     /// 当从气象站得到更新观测值时，通知观察者
     /// </summary>
     public void MeasurementsChanged()
     {
         NotifyObervers();
     }


     /// <summary>
     ///
     /// </summary>
     /// <param name="temperature"></param>
     /// <param name="humidity"></param>
    /// <param name="pressure"></param>
     public void SetMeasurements(float temperature, float humidity, float pressure)
     {
         this.temperature = temperature;
         this.humidity = humidity;
         this.pressure = pressure;
         MeasurementsChanged();
     }
}
