package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSetEnginePowerSingle;
import sbw.architecture.datatype.Power;

import java.text.ParseException;

public class CommandDoEnginePowerSingle extends CommandChoice {

	public CommandDoEnginePowerSingle(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		// DO <id1> SET POWER <power> ENGINE <id2>
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier idController = Validate.makeIdentifier(arr[1]);
		Power p = Validate.makePower(arr[4]);
		Identifier idEngine = Validate.makeIdentifier(arr[6]);

		CommandDoSetEnginePowerSingle cd = new CommandDoSetEnginePowerSingle(idController, p, idEngine);
		ab.submitCommand(cd);
	}
}
