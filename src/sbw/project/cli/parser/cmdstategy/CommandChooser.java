package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.*;

public class CommandChooser {
	private ActionSet actionSet;
	private ArrayList<Pattern> patterns;
	//The string regex that needs to be complied into a pattern
	private static final String[] COMMAND_PATTERNS = {
			"CREATE RUDDER [a-zA-Z0-9]+ WITH LIMIT [0-9\\.]+ SPEED [0-9\\.]+ ACCELERATION [0-9\\.]+",
			"CREATE ELEVATOR [a-zA-Z0-9]+ WITH LIMIT [0-9\\.]+ SPEED [0-9\\.]+ ACCELERATION [0-9\\.]+"};

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
				//Create Aileron
			case 3:
				//Create split flap
			case 4:
				//Create fowler flap
			case 5:
				//Create engine
			case 6:
				//Create nose gear
			case 7:
				//create main gear
			case 8:
				//Declare rudder controller
			case 9:
				//Declare elevator controller
			case 10:
				//Declare aileron controller
			case 11:
				//Declare flap controller
			case 12:
				//declare engine controller
			case 13:
				//declare gear controller
			case 14:
				//declare bus
			case 15:
				//commit
			case 16:
				//do rudder
			case 17:
				//do elevator
			case 18:
				//do ailerons
			case 19:
				//do speed brake
			case 20:
				//do flap
			case 21:
				//do engine power all
			case 22:
				//do engine power single
			case 23:
				//do gear
			case 24:
				//halt
			case 25:
				//@clock <rate>
			case 26:
				//@clock <optn>
			case 27:
				//@clock
			case 28:
				//@run file
			case 29:
				//@exit
			default:
				throw new ParseException("Value out of bounds", -1);

		}

	}


}
