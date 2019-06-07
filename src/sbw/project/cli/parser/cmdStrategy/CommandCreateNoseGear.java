package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

public class CommandCreateNoseGear extends CommandChoice {
	CommandCreateNoseGear(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[3]);
		Speed speed = Validate.makeSpeed(args[6]);
		Acceleration acc = Validate.makeAcceleration(args[8]);
		this.actionSet.getActionCreational().doCreateGearNose(id, speed, acc);
	}
}
