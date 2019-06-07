package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Rate;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoSetClockRate;

public class CommandMiscClockRate extends CommandChoice {

	CommandMiscClockRate(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {

		String[] arr = this.command.split(" ");
		
		Rate rate = Validate.makeRate(arr[1]);
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
		CommandDoSetClockRate cd = new CommandDoSetClockRate(rate);
		am.submitCommand(cd);

	}
}
