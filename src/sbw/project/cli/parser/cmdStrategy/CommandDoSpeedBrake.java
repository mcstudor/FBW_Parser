package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoDeploySpeedBrake;

public class CommandDoSpeedBrake extends CommandChoice {

	CommandDoSpeedBrake(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> SPEED BRAKE ON|OFF
		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = Validate.makeIdentifier(arr[1]);

		/*boolean isDeployed = false;
		if (arr[4].equals("ON")) {
			isDeployed = true;
		} */
		//Replaced with
		boolean isDeployed = (arr[4].equalsIgnoreCase("ON"));

		CommandDoDeploySpeedBrake cd = new CommandDoDeploySpeedBrake(id, isDeployed);
		ab.submitCommand(cd);
	}
}
