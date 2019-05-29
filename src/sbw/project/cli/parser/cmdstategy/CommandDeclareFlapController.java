package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;
import java.util.ArrayList;

public class CommandDeclareFlapController extends CommandChoice {

	CommandDeclareFlapController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);
		ArrayList<Identifier> flapIDs = new ArrayList<>();
		for(int i = 6; i<args.length; i++) {
			flapIDs.add(Validate.makeIdentifier(args[i]));
		}
		//TODO: this shouldn't let the flaps be different styles (fowler vs split)
		this.actionSet.getActionStructural().doDeclareFlapController(controllerID, flapIDs);
	}
}
