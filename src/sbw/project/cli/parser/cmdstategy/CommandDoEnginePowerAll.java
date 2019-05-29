package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSetEnginePowerAll;
import sbw.architecture.datatype.Power;
import java.text.ParseException;

public class CommandDoEnginePowerAll extends CommandChoice {

	public CommandDoEnginePowerAll(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		// DO <id> SET POWER <power>
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier idController = new Identifier(arr[1]);
		Power p = Validate.makePower(arr[4]);

		CommandDoSetEnginePowerAll cd = new CommandDoSetEnginePowerAll(idController, p);
		ab.submitCommand(cd);
	}
}
