package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

public class CommandCreateEngine extends CommandChoice {
	CommandCreateEngine(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[2]);
		Speed speed = Validate.makeSpeed(args[5]);
		Acceleration acc = Validate.makeAcceleration(args[7]);

		this.actionSet.getActionCreational().doCreateEngine(id, speed, acc);
	}
}
