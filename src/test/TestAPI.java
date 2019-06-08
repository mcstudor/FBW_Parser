package test;

import sbw.architecture.datatype.*;

public class TestAPI {

	public static void main(String [] args){
		try {
			testAllDataTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testAllDataTypes() throws Exception{

		//Valid
		Acceleration acceleration = new Acceleration(-50);
		Angle angle = new Angle(-50);
		Identifier identifier = new Identifier("___ED&");


		//Invalid
		//Percent percent = new Percent(101);
		//Percent percent2 = new Percent(-1);

		Position position = new Position(Position.E_Position.UP);

		//valid
		Power power = new Power(101);

		//invalid
		//Power power2 = new Power(-1);

		//valid
		Rate rate = new Rate(1);

		//invalid
		//Rate rate2 = new Rate(-1);

		//valid
		Speed speed = new Speed(0);
		Speed speed2 = new Speed(-50);

	}
}
