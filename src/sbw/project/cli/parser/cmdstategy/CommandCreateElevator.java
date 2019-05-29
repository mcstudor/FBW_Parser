package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandCreateElevator extends CommandChoice {

	CommandCreateElevator(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[2]);
		Angle angle = Validate.makeAngle(args[5]);
		Speed speed = Validate.makeSpeed(args[7]);
		Acceleration acc = Validate.makeAcceleration(args[9]);

		this.actionSet.getActionCreational().doCreateElevator(id, angle, speed, acc);
	}
}
