package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoExit;

import java.text.ParseException;

public class CommandMiscExit extends CommandChoice {

	public CommandMiscExit(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		System.out.println(this.command);
		
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoExit cde = new CommandDoExit();
		am.submitCommand(cde);
	}
}
