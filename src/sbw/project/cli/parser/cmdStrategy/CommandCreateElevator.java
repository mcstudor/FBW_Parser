package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

public class CommandCreateElevator extends CommandChoice {

	CommandCreateElevator(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[2]);
		Angle angle = Validate.makeAngle(args[5]);
		Speed speed = Validate.makeSpeed(args[7]);
		Acceleration acc = Validate.makeAcceleration(args[9]);

		this.actionSet.getActionCreational().doCreateElevator(id, angle, speed, acc);
	}
}
