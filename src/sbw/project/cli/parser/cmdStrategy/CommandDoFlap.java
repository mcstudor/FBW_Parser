package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSetFlaps;
import sbw.architecture.datatype.Position;

public class CommandDoFlap extends CommandChoice {

	CommandDoFlap(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> DEFLECT FLAP <position>

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = Validate.makeIdentifier(arr[1]);
		Position p = Validate.makePosition(arr[4]);
		CommandDoSetFlaps cd = new CommandDoSetFlaps(id, p);
		ab.submitCommand(cd);
	}
}
