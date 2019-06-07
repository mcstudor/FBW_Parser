package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSetEnginePowerAll;
import sbw.architecture.datatype.Power;

public class CommandDoEnginePowerAll extends CommandChoice {

	CommandDoEnginePowerAll(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> SET POWER <power>

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier idController = new Identifier(arr[1]);
		Power p = Validate.makePower(arr[4]);

		CommandDoSetEnginePowerAll cd = new CommandDoSetEnginePowerAll(idController, p);
		ab.submitCommand(cd);
	}
}
