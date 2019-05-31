package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;
import java.text.ParseException;

public class CommandCreateEngine extends CommandChoice {
	CommandCreateEngine(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier id = Validate.makeIdentifier(args[2]);
		Speed speed = Validate.makeSpeed(args[5]);
		Acceleration acc = Validate.makeAcceleration(args[7]);

		this.actionSet.getActionCreational().doCreateEngine(id, speed, acc);
	}
}
