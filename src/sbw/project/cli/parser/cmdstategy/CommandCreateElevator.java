package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandCreateElevator extends CommandChoice {

	protected CommandCreateElevator(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		//do the stuff
		System.out.println(this.command);
	}
}
