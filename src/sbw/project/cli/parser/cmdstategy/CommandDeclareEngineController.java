package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;
import java.util.ArrayList;

public class CommandDeclareEngineController extends CommandChoice {

	CommandDeclareEngineController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);
		ArrayList<Identifier> engineIDs = new ArrayList<>();
		for(int i = 6; i<args.length; i++) {
			engineIDs.add(Validate.makeIdentifier(args[i]));
		}
		this.actionSet.getActionStructural().doDeclareEngineController(controllerID, engineIDs);
	}
}
