package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoHalt;

import java.text.ParseException;

public class CommandHalt extends CommandChoice {

	public CommandHalt(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command); // HALT <id>
		
		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = new Identifier(arr[1]);
		CommandDoHalt cd = new CommandDoHalt(id);
		ab.submitCommand(cd);
	}
}
