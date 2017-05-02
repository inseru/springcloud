package com.qjs.yonth.design.builder;

public class SaxAirShipDirector implements AirShipDirector {
	private AirShipBuilder builder;

	public SaxAirShipDirector(AirShipBuilder builder) {
		super();
		this.builder = builder;
	}

	public AirShip directorAirShip() {
		Engine e = builder.engineBuilder();
		Seat s = builder.seatBuilder();
		AirShip air = new AirShip();
		air.setEngine(e);
		air.setSeat(s);
		return air;
	}

}
