package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoDeploySpeedBrake;
import sbw.project.cli.action.command.behavioral.CommandDoHalt;

import java.text.ParseException;

public class CommandDoSpeedBrake extends CommandChoice {

	public CommandDoSpeedBrake(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		// DO <id> SPEED BRAKE ON|OFF
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = Validate.makeIdentifier(arr[1]);

		boolean isDeployed = false;
		if (arr[4].equals("ON")) {
			isDeployed = true;
		}

		CommandDoDeploySpeedBrake cd = new CommandDoDeploySpeedBrake(id, isDeployed);
		ab.submitCommand(cd);
	}
}
