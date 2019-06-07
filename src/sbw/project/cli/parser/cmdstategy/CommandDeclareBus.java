package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

import java.util.ArrayList;

public class CommandDeclareBus extends CommandChoice {

	CommandDeclareBus(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		String[] args = this.command.split(" ");
		Identifier busID = Validate.makeIdentifier(args[2]);
		ArrayList<Identifier> controllerIDs = new ArrayList<>();
		for(int i = 5; i<args.length; i++) {
			controllerIDs.add(Validate.makeIdentifier(args[i]));
		}
		this.actionSet.getActionStructural().doDeclareBus(busID, controllerIDs);
	}
}
