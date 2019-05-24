package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.*;

public class CommandChooser {
	private ActionSet actionSet;
	private ArrayList<Pattern> patterns;
	//The string regex that needs to be complied into a pattern

	private static final String ID = "[a-zA-Z0-9]+";
	private static final String ID_ONEPLUS = "(" + ID + "\\s?)+";
	private static final String REAL_NO = "[0-9]+(\\.[0-9]+)?";
	private static final String FILENAME = "";
	private static final String INT = "[0-9]+";
	private static final String POS = "[(up)1234]";
	private static final String SPEED_ACC = " SPEED " + REAL_NO + " ACCELERATION " + REAL_NO;
	private static final String LIM_SPEED_ACC = " WITH LIMIT " + REAL_NO + SPEED_ACC;


	private static final String[] COMMAND_PATTERNS = {
			//CREATIONAL COMMANDS
			"CREATE RUDDER " + ID + LIM_SPEED_ACC,
			"CREATE ELEVATOR " + ID + LIM_SPEED_ACC,
			"CREATE AILERON " + ID + " WITH LIMIT UP " + REAL_NO + " DOWN " + REAL_NO + SPEED_ACC,
			"CREATE SPLIT FLAP " + ID + LIM_SPEED_ACC,
			"CREATE FOWLER FLAP " + ID + LIM_SPEED_ACC,
			"CREATE ENGINE " + ID + " WITH" + SPEED_ACC,
			"CREATE NOSE GEAR " + ID + " WITH" + SPEED_ACC,
			"CREATE MAIN GEAR " + ID + " WITH" + SPEED_ACC,

			//STRUCTURAL COMMANDS
			"DECLARE RUDDER CONTROLLER " + ID + " WITH RUDDER " + ID,
			"DECLARE ELEVATOR CONTROLLER " + ID + " WITH ELEVATORS " + ID + " " + ID,
			"DECLARE AILERON CONTROLLER " + ID + " WITH AILERONS " + ID_ONEPLUS + " PRIMARY " + ID +
					"( SLAVE " + ID + " TO " + ID + " BY " + REAL_NO + " PERCENT)*",
			"DECLARE FLAP CONTROLLER " + ID + " WITH FLAPS " + ID_ONEPLUS,
			"DECLARE ENGINE CONTROLLER " + ID + " WITH ENGINE[S]? " + ID_ONEPLUS,
			"DECLARE GEAR CONTROLLER " + ID + " WITH GEAR NOSE " + ID + " MAIN " + ID + " " + ID,
			"DECLARE BUS " + ID + " WITH CONTROLLER[S]? " + ID_ONEPLUS,
			"COMMIT",

			//BEHAVIORAL COMMANDS
			"DO " + ID + " DEFLECT RUDDER " + REAL_NO + "((LEFT)|(RIGHT))",
			"DO " + ID + " DEFLECT ELEVATOR " + REAL_NO + " ((UP)|(DOWN))",
			"DO " + ID + " DEFLECT AILERONS " + REAL_NO + " ((UP)|(DOWN))",
			"DO " + ID + " SPEED BREAK ((ON)|(OFF))",
			"DO " + ID + " DEFLECT FLAP " + POS,
			"DO " + ID + " SET POWER " + REAL_NO,
			"DO " + ID + " SET POWER " + REAL_NO + " ENGINE " + ID,
			"DO " + ID + " GEAR ((UP)|(DOWN))",
			"HALT " + ID,

			//MISC COMMANDS
			"@CLOCK " + INT,
			"@CLOCK ((PAUSE)|(RESUME)|(UPDATE))",
			"@CLOCK",
			"@RUN \"" + FILENAME + "\"",
			"@EXIT",
			"@WAIT " + INT

	};

	public CommandChooser(ActionSet actionSet){
		this.actionSet = actionSet;
		patterns = new ArrayList<>();
		initialize();
	}

	public ActionSet getActionSet() {
		return actionSet;
	}

	private void initialize(){
		//complies patterns
		for(String s: COMMAND_PATTERNS){
			patterns.add(Pattern.compile(s, Pattern.CASE_INSENSITIVE));
		}
	}


	public CommandChoice chooseCommand(String command) throws ParseException {
		CommandChoice choice = null;
		//checks each pattern to find out if the command matches it.
		//if found, the number of the command's position (which is static) is passed to the get command;
		//if the command does not, throw exception
		for(int i = 0; i<patterns.size(); i++){
			Matcher matcher = patterns.get(i).matcher(command);
			if(matcher.matches()){
				return getCommand(i, command);
			}
		}
		if(choice==null)
			throw new ParseException("String did not match pattern", -1);
		//this should be unreachable, but compiler doesn't like that.
		return choice;
	}

	private CommandChoice getCommand(int i, String command) throws ParseException {
		switch (i){
			case 0:
				return new CommandCreateRudder(actionSet, command);
			case 1:
				return new CommandCreateElevator(actionSet, command);
			case 2:
				//Create aileron
				return new CommandDefault(actionSet, command);
			case 3:
				//Create split flap
				return new CommandDefault(actionSet, command);
			case 4:
				//Create fowler flap
				return new CommandDefault(actionSet, command);
			case 5:
				//Create engine
				return new CommandDefault(actionSet, command);
			case 6:
				//Create nose gear
				return new CommandDefault(actionSet, command);
			case 7:
				//create main gear
				return new CommandDefault(actionSet, command);
			case 8:
				//Declare rudder controller
				return new CommandDefault(actionSet, command);
			case 9:
				//Declare elevator controller
				return new CommandDefault(actionSet, command);
			case 10:
				//Declare aileron controller
				return new CommandDefault(actionSet, command);
			case 11:
				//Declare flap controller
				return new CommandDefault(actionSet, command);
			case 12:
				//declare engine controller
				return new CommandDefault(actionSet, command);
			case 13:
				//declare gear controller
				return new CommandDefault(actionSet, command);
			case 14:
				//declare bus
				return new CommandDefault(actionSet, command);
			case 15:
				//commit
				return new CommandDefault(actionSet, command);
			case 16:
				//do rudder
				return new CommandDefault(actionSet, command);
			case 17:
				//do elevator
				return new CommandDefault(actionSet, command);
			case 18:
				//do ailerons
				return new CommandDefault(actionSet, command);
			case 19:
				//do speed brake
				return new CommandDefault(actionSet, command);
			case 20:
				//do flap
				return new CommandDefault(actionSet, command);
			case 21:
				//do engine power all
				return new CommandDefault(actionSet, command);
			case 22:
				//do engine power single
				return new CommandDefault(actionSet, command);
			case 23:
				//do gear
				return new CommandDefault(actionSet, command);
			case 24:
				//halt
				return new CommandDefault(actionSet, command);
			case 25:
				//@clock <rate>
				return new CommandDefault(actionSet, command);
			case 26:
				//@clock <optn>
				return new CommandDefault(actionSet, command);
			case 27:
				//@clock
				return new CommandDefault(actionSet, command);
			case 28:
				//@run file
				return new CommandDefault(actionSet, command);
			case 29:
				//@exit
				return new CommandDefault(actionSet, command);
			case 30:
				//@wait
				return new CommandDefault(actionSet, command);
			default:
				throw new ParseException("Value out of bounds", -1);

		}

	}


}
