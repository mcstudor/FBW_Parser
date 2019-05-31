package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Rate;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.ActionStructural;
import sbw.project.cli.action.command.misc.CommandDoClockUpdate;
import sbw.project.cli.action.command.misc.CommandDoSetClockRate;
import sbw.project.cli.action.command.misc.CommandDoSetClockRunning;
import sbw.project.cli.action.command.misc.CommandDoShowClock;

import java.text.ParseException;

public class CommandMiscClock extends CommandChoice {

	public CommandMiscClock(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		System.out.println(this.command);
		
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoShowClock cdsc = new CommandDoShowClock();
		am.submitCommand(cdsc);
	}
}
