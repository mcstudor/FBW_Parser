package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandDoEnginePowerSingle extends CommandChoice {

	public CommandDoEnginePowerSingle(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
	}
}
