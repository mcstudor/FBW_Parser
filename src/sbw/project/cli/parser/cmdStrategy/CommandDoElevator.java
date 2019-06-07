package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoDeflectElevator;
import sbw.architecture.datatype.Angle;

public class CommandDoElevator extends CommandChoice {

	CommandDoElevator(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> DEFLECT ELEVATOR <angle> UP|DOWN

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier idController = new Identifier(arr[1]);
		Angle a = Validate.makeAngle(arr[4]);
		/*boolean isDown = true;
		if (arr[5].equals("UP")) isDown = false;
		*/
		boolean isDown = arr[5].equalsIgnoreCase("DOWN");
		CommandDoDeflectElevator cd = new CommandDoDeflectElevator(idController, a, isDown);
		ab.submitCommand(cd);
	}
}
