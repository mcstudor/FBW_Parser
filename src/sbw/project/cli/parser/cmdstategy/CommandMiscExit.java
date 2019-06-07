package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoExit;

public class CommandMiscExit extends CommandChoice {

	CommandMiscExit(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {

		
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoExit cde = new CommandDoExit();
		am.submitCommand(cde);
	}
}
