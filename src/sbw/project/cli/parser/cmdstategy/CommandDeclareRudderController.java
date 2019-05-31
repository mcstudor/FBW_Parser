package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandDeclareRudderController extends CommandChoice {

	CommandDeclareRudderController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);
		Identifier rudderID = Validate.makeIdentifier(args[6]);

		this.actionSet.getActionStructural().doDeclareRudderController(controllerID, rudderID);

	}
}
