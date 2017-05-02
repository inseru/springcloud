package com.qjs.yonth.design.observer;

public interface ISubject {
	void RegisterObserver(IObserver o);//注册观察者
    void RemoveObserver(IObserver o);//删除观察者
    void NotifyObervers();//通知观察者
	
}
