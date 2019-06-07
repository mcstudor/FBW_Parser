package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSetEnginePowerSingle;
import sbw.architecture.datatype.Power;

public class CommandDoEnginePowerSingle extends CommandChoice {

	CommandDoEnginePowerSingle(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id1> SET POWER <power> ENGINE <id2>

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier idController = Validate.makeIdentifier(arr[1]);
		Power p = Validate.makePower(arr[4]);
		Identifier idEngine = Validate.makeIdentifier(arr[6]);

		CommandDoSetEnginePowerSingle cd = new CommandDoSetEnginePowerSingle(idController, p, idEngine);
		ab.submitCommand(cd);
	}
}
