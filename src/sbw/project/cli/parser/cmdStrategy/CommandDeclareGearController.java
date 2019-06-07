package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

public class CommandDeclareGearController extends CommandChoice {

	CommandDeclareGearController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {

		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);
		Identifier noseGearID = Validate.makeIdentifier(args[7]);
		Identifier mainGearID1 = Validate.makeIdentifier(args[9]);
		Identifier mainGearID2 = Validate.makeIdentifier(args[10]);

		this.actionSet.getActionStructural().doDeclareGearController(controllerID, noseGearID, mainGearID1, mainGearID2);
	}
}
