package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Rate;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoClockUpdate;
import sbw.project.cli.action.command.misc.CommandDoSetClockRate;
import sbw.project.cli.action.command.misc.CommandDoSetClockRunning;
import sbw.project.cli.action.command.misc.CommandDoShowClock;

import java.text.ParseException;

public class CommandMiscClockRate extends CommandChoice {

	public CommandMiscClockRate(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		
		String[] arr = this.command.split(" ");
		
		Rate rate = Validate.makeRate(arr[1]);
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoSetClockRate cd = new CommandDoSetClockRate(rate);
		am.submitCommand(cd);

	}
}
