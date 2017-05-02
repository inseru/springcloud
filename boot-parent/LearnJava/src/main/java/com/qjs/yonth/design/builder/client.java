package com.qjs.yonth.design.builder;

public class client {
	public static void main(String[] args) {
		AirShipDirector ship = new SaxAirShipDirector(new SaxAirShipBuilder());
		ship.directorAirShip();
	}
}
