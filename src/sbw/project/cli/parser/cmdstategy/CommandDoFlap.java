package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSetFlaps;
import sbw.architecture.datatype.Position;

import java.text.ParseException;

public class CommandDoFlap extends CommandChoice {

	public CommandDoFlap(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> DEFLECT FLAP <position>
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = Validate.makeIdentifier(arr[1]);
		Position p = Validate.makePosition(arr[4]);
		CommandDoSetFlaps cd = new CommandDoSetFlaps(id, p);
		ab.submitCommand(cd);
	}
}
