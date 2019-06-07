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

class Validate {
	
	
	static Acceleration makeAcceleration(String s) {
		// a nonnegative real in appropriate units per clock tick
		// verify s is a nonnegative real

		if (isNonNegativeReal(s)) {
			double d = Double.parseDouble(s);
			Acceleration a = new Acceleration(d);
			return a;
		} else {
			throw new RuntimeException("Validate.makeAcceleration: incorrect format");
		}


	}


	static Angle makeAngle(String s) {
		// a nonnegative real in degrees

		if (isNonNegativeRealDegrees(s)) {
			double d = Double.parseDouble(s);
			Angle a = new Angle(d);
			return a;
		} else {
			throw new RuntimeException("Validate.makeAngle: incorrect format");
		}

	}

	
	static Identifier makeIdentifier(String s) {
		// an arbitrary alphanumeric identifier
		// validate that string is a proper Java variable

		if (Character.isDigit(s.charAt(0)) || (s.charAt(0) == '$')) {
			throw new RuntimeException("Validate.makeIdentifier: incorrect format");
		} else {
			Identifier i = new Identifier(s);
			return i;
		}
	}

	
	static Percent makePercent(String s) {
		// a real in percent [0,100]

		if (isValidRealPercent(s)) {
			double d = Double.parseDouble(s);
			Percent p = new Percent(d);
			return p;
		} else {
			throw new RuntimeException("Validate.makePercent incorrect format");
		}
	}

	
	static Position makePosition(String s) {
		// a closed set of flap positions [up,1,2,3,4] UP, ONE, etc
		if (isValidFlapPosition(s)) {

			Position.E_Position i;
			if(s.equalsIgnoreCase("UP"))
				i = E_Position.UP;
			else {
				switch (s) {
					case "1":
						i = E_Position.ONE;
						break;
					case "2":
						i = E_Position.TWO;
						break;
					case "3":
						i = E_Position.THREE;
						break;
					case "4":
						i = E_Position.FOUR;
						break;
					default:
						throw new RuntimeException("Validate.makePosition: Invalid Flap position.");
				}
			}

			Position p = new Position(i);
			return p;
		} else {
			throw new RuntimeException("Validate.makePosition: Invalid Flap position.");
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
			throw new RuntimeException("Validate.makePower incorrect format");
		}

	}


	static Rate makeRate(String s) {
		// a positive integer clock rate
		
		if (isPositiveInteger(s)) {
			int i = Integer.parseInt(s);
			Rate r = new Rate(i);
			return r;
		} else {
			throw new RuntimeException("Validate.makeRate incorrect format");
		}

	}


	static Speed makeSpeed(String s) {
		// a positive real in appropriate units per clock tick

		if (isPositiveReal(s)) {
			double d = Double.parseDouble(s);
			Speed speed = new Speed(d);
			return speed;
		} else {
			throw new RuntimeException("Validate.makeSpeed: incorrect format");
		}

	}


	static boolean isInteger(String s) {
		
		try {
			int num = Integer.parseInt(s);
		} catch (RuntimeException e) {
			throw new RuntimeException("Validate.isInteger - not an integer");
		}
		
		return true;

	}


	static boolean isPositiveInteger(String s) {
		
		int num;
		
		try {
			num = Integer.parseInt(s);
			if (num > 0) return true;
			else {
				throw new RuntimeException("Validate.isPositiveInteger - not a positive integer");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Validate.isPositiveInteger - not a positive integer");
		}

	}


	static boolean isPositiveReal(String s) {

		try {
			double d = Double.parseDouble(s);
			if (d > 0) {
				return true;
			} else {
				throw new RuntimeException("Validate.isPositiveReal - not a positive real");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Validate.isPositiveReal - not a positive real");
		}

	}


	static boolean isNonNegativeReal(String s) {

		try {
			double d = Double.parseDouble(s);
			if (d >= 0) {
				return true;
			} else {
				throw new RuntimeException("Validate.isNonNegativeReal - not a nonnegative real");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Validate.isNonNegativeReal - not a nonnegative real");
		}
	}


	static boolean isNonNegativeRealDegrees(String s) {

		try {
			double d = Double.parseDouble(s);
			if ((d >= 0) && (d <= 360)) {
				return true;
			} else {
				throw new RuntimeException("Validate.isNonNegativeRealDegrees - not a nonnegative real in degrees");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Validate.isNonNegativeRealDegrees - not a nonnegative real in degrees");
		}
	}

	
	static boolean isValidRealPercent(String s) {

		try {
			double d = Double.parseDouble(s);
			if ((d >= 0) && (d <= 100)) {
				return true;
			} else {
				throw new RuntimeException("Validate.isValidRealPercent - not a valid real percent.");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Validate.isValidRealPercent - not a valid real percent.");
		}

	}

	
	static boolean isValidFlapPosition(String s) {
		// UP, 1, 2, 3, 4 - 0, 1, 2, 3, 4 ordinals

		int num;
		if (s.equalsIgnoreCase("UP")) num = 0;
		else num = Integer.parseInt(s);

		for (Position.E_Position p : Position.E_Position.values()) {

			if (p.ordinal() == num) {
				return true;
			}
		}

		throw new RuntimeException("Validate.isValidFlapPosition - not a valid position");
	}

}
