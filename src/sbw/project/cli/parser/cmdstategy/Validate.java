package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Acceleration;
import sbw.architecture.datatype.Angle;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Percent;
import sbw.architecture.datatype.Position;
import sbw.architecture.datatype.Power;
import sbw.architecture.datatype.Rate;
import sbw.architecture.datatype.Speed;
import sbw.architecture.datatype.Position.E_Position;

public class Validate {
	
	
	static Acceleration makeAcceleration(String s) {
		// a nonnegative real in appropriate units per clock tick
		// verify s is a nonnegative real - TODO 
		double d = Double.parseDouble(s);
		Acceleration a = new Acceleration(d);
		return a;	
	}
	
	static Angle makeAngle(String s) {
		// a nonnegative real in degrees
		double d = Double.parseDouble(s);
		Angle a = new Angle(d);
		return a;
	}
	
	static Identifier makeIdentifier(String s) {
		// an arbitrary alphanumeric identifier
		// validate that string is a proper Java variable - TODO
		Identifier i = new Identifier(s);
		return i;
		
	}
	
	static Percent makePercent(String s) {
		// a real in percent [0,100]
		Double d = Double.parseDouble(s);
		Percent p = new Percent(d);
		return p;
		
	}
	
	static Position makePosition(String s) {
		// a closed set of flap positions [up,1,2,3,4]
		
		if (isValidFlapPosition(s)) {
			E_Position i = null; // verify E_Position is in enum - TODO
			Position p = new Position(i);
			return p;
		} else {
			System.out.println("makePosition format incorrect");
		}
		return null;
	}
	


	static Power makePower(String s) {
		// a real in percent [0,100]
		// validate range of double and that s is a double
		if (isValidRealPercent(s)) {
			double d = Double.parseDouble(s);
			Power p = new Power(d);
			return p;
		} else {
			System.out.println("makePower format incorrect");
		}
		return null;

	}

	static Rate makeRate(String s) {
		// a positive integer clock rate
		
		if (isPositiveInteger(s)) {
			int i = Integer.parseInt(s);
			Rate r = new Rate(i);
			return r;
		} else {
			System.out.println("Command format incorrect");
		}
		return null;
	}
	
	static Speed makeSpeed(String s) {
		// a positive real in appropriate units per clock tick
		// validate that d is a positive real - TODO
		double d = Double.parseDouble(s);
		Speed speed = new Speed(d);
		return speed;
	}
	
	
	static boolean isInteger(String s) {
		
		try {
			int num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;

	}
	
	static boolean isPositiveInteger(String s) {
		
		int num;
		
		try {
			num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		
		if (num > 0) return true;
		else return false;
		
	}
	
	static boolean isValidRealPercent(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	static boolean isValidFlapPosition(String s) {
		// TODO Auto-generated method stub
		return false;
	}
}
