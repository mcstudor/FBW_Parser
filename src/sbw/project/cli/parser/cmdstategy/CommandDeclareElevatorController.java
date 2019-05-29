package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandDeclareElevatorController extends CommandChoice {

	CommandDeclareElevatorController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);
		Identifier elevatorID1 = Validate.makeIdentifier(args[6]);
		Identifier elevatorID2 = Validate.makeIdentifier(args[7]);

		this.actionSet.getActionStructural().doDeclareElevatorController(controllerID, elevatorID1, elevatorID2);
	}
}
