package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoDeflectAilerons;
import sbw.architecture.datatype.Angle;

import java.text.ParseException;

public class CommandDoAilerons extends CommandChoice {

	public CommandDoAilerons(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> DEFLECT AILERONS <angle> UP|DOWN
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();

		Identifier idController = new Identifier(arr[1]);
		Angle a = Validate.makeAngle(arr[4]);
		boolean isDown = true;
		if (arr[5].equals("UP")) isDown = false;

		CommandDoDeflectAilerons cd = new CommandDoDeflectAilerons(idController, a, isDown);
		ab.submitCommand(cd);
	}
}
