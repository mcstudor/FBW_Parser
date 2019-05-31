package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoDeflectRudder;
import sbw.architecture.datatype.Angle;

import java.text.ParseException;

public class CommandDoRudder extends CommandChoice {

	public CommandDoRudder(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> DEFLECT RUDDER <angle> LEFT|RIGHT
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier id = Validate.makeIdentifier(arr[1]);
		Angle a = Validate.makeAngle(arr[4]);
		boolean isRight = true;
		if (arr[5].equals("LEFT")) isRight = false;

		CommandDoDeflectRudder cd = new CommandDoDeflectRudder(id, a, isRight);
		ab.submitCommand(cd);
	}
}
