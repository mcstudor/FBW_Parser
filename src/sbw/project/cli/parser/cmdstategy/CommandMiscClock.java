package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoShowClock;

public class CommandMiscClock extends CommandChoice {

	CommandMiscClock(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {

		
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoShowClock cdsc = new CommandDoShowClock();
		am.submitCommand(cdsc);
	}
}
