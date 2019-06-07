package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoDeflectRudder;
import sbw.architecture.datatype.Angle;

public class CommandDoRudder extends CommandChoice {

	CommandDoRudder(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> DEFLECT RUDDER <angle> LEFT|RIGHT

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier id = Validate.makeIdentifier(arr[1]);
		Angle a = Validate.makeAngle(arr[4]);
		/*boolean isRight = true;
		if (arr[5].equals("LEFT")) isRight = false;
		*/
		//Replaced with
		boolean isRight = arr[5].equalsIgnoreCase("RIGHT");
		CommandDoDeflectRudder cd = new CommandDoDeflectRudder(id, a, isRight);
		ab.submitCommand(cd);

	}
}
