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

import java.text.ParseException;

public class Validate {
	
	
	static Acceleration makeAcceleration(String s) {
		// a nonnegative real in appropriate units per clock tick
		// verify s is a nonnegative real

		if (isNonNegativeReal(s)) {
			double d = Double.parseDouble(s);
			Acceleration a = new Acceleration(d);
			return a;
		} else {
			throw new NumberFormatException("makeAcceleration format incorrect");
		}


	}


	static Angle makeAngle(String s) {
		// a nonnegative real in degrees
		if (isNonNegativeRealDegrees(s)) {
			double d = Double.parseDouble(s);
			Angle a = new Angle(d);
			return a;
		} else {
			throw new NumberFormatException("makeAngle format incorrect");
		}

	}
	
	static Identifier makeIdentifier(String s) {
		// an arbitrary alphanumeric identifier
		// validate that string is a proper Java variable - TODO
		Identifier i = new Identifier(s);
		return i;
		
	}
	
	static Percent makePercent(String s) {
		// a real in percent [0,100]

		if (isValidRealPercent(s)) {
			double d = Double.parseDouble(s);
			Percent p = new Percent(d);
			return p;
		} else {
			System.out.println("makePercent format incorrect");
		}
		return null;
	}
	
	static Position makePosition(String s) {
		// a closed set of flap positions [up,1,2,3,4] UP, ONE, etc
		if (isValidFlapPosition(s)) {

			Position.E_Position i = null;
			
			if (s.equals("UP")) {
				i  = E_Position.UP;
			} else if (s.equals("1")) {
				i = E_Position.ONE;
			} else if (s.equals("2")) {
				i = E_Position.TWO;
			} else if (s.equals("3")) {
				i = E_Position.THREE;
			} else if (s.equals("4")) {
				i = E_Position.FOUR;
			} else {
				throw new NumberFormatException("makePosition: Invalid Flap position.");
			}

			Position p = new Position(i);
			return p;
		} else {
			throw new NumberFormatException("makePosition: Invalid Flap position.");
		}

	}
	

	static Power makePower(String s) {
		// a real in percent [0,100]
		// validate range of double and that s is a double
		if (isValidRealPercent(s)) {
			double d = Double.parseDouble(s);
			Power p = new Power(d);
			return p;
		} else {
			throw new NumberFormatException("makePower format incorrect");
		}

	}

	static Rate makeRate(String s) {
		// a positive integer clock rate
		
		if (isPositiveInteger(s)) {
			int i = Integer.parseInt(s);
			Rate r = new Rate(i);
			return r;
		} else {
			throw new NumberFormatException("makeRate format incorrect");
		}

	}

	static Speed makeSpeed(String s) {
		// a positive real in appropriate units per clock tick

		if (isPositiveReal(s)) {
			double d = Double.parseDouble(s);
			Speed speed = new Speed(d);
			return speed;
		} else {
			throw new NumberFormatException("makeSpeed: not a positive real");
		}

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
			if (num > 0) return true;
			else {
				throw new NumberFormatException("Error in isPositiveInteger - not a positive integer");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error in isPositiveInteger - not a positive integer");
			return false;
		}
		


		
	}

	static boolean isPositiveReal(String s) {

		try {
			double d = Double.parseDouble(s);
			if (d > 0) {
				return true;
			} else {
				throw new NumberFormatException("Error in isPositiveReal - not a positive real");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error in isPositiveReal - not a positive real");
			return false;
		}

	}

	private static boolean isNonNegativeReal(String s) {

		try {
			double d = Double.parseDouble(s);
			if (d >= 0) {
				return true;
			} else {
				throw new NumberFormatException("Error in isNonNegativeReal - not a nonnegative real");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error in isNonNegativeReal - not a nonnegative real");
			return false;
		}
	}

	private static boolean isNonNegativeRealDegrees(String s) {

		try {
			double d = Double.parseDouble(s);
			if ((d >= 0) && (d <= 360)) {
				return true;
			} else {
				throw new NumberFormatException("Error in isNonNegativeRealDegrees - not a nonnegative real in degrees");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error in isNonNegativeRealDegrees - not a nonnegative real in degrees");
			return false;
		}
	}

	
	static boolean isValidRealPercent(String s) {

		try {
			double d = Double.parseDouble(s);
			if ((d >= 0) && (d <= 100)) {
				return true;
			} else {
				throw new NumberFormatException("Error in isValidRealPercent - not a valid real percent.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error in isValidRealPercent - not a valid real percent.");
			return false;
		}

	}
	
	static boolean isValidFlapPosition(String s) {
		// UP, 1, 2, 3, 4 - 0, 1, 2, 3, 4 ordinals
		int num;
		if (s.equals("UP")) num = 0;
		else num = Integer.parseInt(s);
		for (Position.E_Position p : Position.E_Position.values()) {
			//System.out.println("valid position: " + p.ordinal());

			if (p.ordinal() == num) {
				return true;
			}
		}
		System.out.println("Error in isValidFlapPosition - not a valid position.");
		return false;
	}
}
