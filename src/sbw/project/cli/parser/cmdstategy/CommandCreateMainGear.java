package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandCreateMainGear extends CommandChoice {
	CommandCreateMainGear(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[3]);
		Speed speed = Validate.makeSpeed(args[6]);
		Acceleration acc = Validate.makeAcceleration(args[8]);
		this.actionSet.getActionCreational().doCreateGearMain(id, speed, acc);
	}
}
