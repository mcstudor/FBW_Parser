package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

public class CommandDeclareElevatorController extends CommandChoice {

	CommandDeclareElevatorController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);
		Identifier elevatorID1 = Validate.makeIdentifier(args[6]);
		Identifier elevatorID2 = Validate.makeIdentifier(args[7]);

		this.actionSet.getActionStructural().doDeclareElevatorController(controllerID, elevatorID1, elevatorID2);
	}
}
