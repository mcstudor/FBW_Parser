package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

public class CommandCreateRudder extends CommandChoice {

	CommandCreateRudder(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[2]);
		Angle angle = Validate.makeAngle(args[5]);
		Speed speed = Validate.makeSpeed(args[7]);
		Acceleration acc = Validate.makeAcceleration(args[9]);

		this.actionSet.getActionCreational().doCreateRudder(id, angle, speed, acc);
	}

}
