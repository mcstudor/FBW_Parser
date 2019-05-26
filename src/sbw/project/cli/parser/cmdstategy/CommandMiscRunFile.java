package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoRunCommandFile;

import java.text.ParseException;

public class CommandMiscRunFile extends CommandChoice {

	public CommandMiscRunFile(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		
		String[] arr = this.command.split(" ");
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoRunCommandFile cd = new CommandDoRunCommandFile(arr[1]);
		am.submitCommand(cd);
	}
}
