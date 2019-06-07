package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoHalt;

public class CommandHalt extends CommandChoice {

	CommandHalt(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// HALT <id>
		
		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = new Identifier(arr[1]);
		CommandDoHalt cd = new CommandDoHalt(id);
		ab.submitCommand(cd);
	}
}
