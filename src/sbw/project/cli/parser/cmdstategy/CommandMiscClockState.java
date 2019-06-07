package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoClockUpdate;
import sbw.project.cli.action.command.misc.CommandDoSetClockRunning;

public class CommandMiscClockState extends CommandChoice {

	CommandMiscClockState(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {

		String[] arr = this.command.split(" ");
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();


		if (arr[1].equalsIgnoreCase("PAUSE")) {
			CommandDoSetClockRunning cdscr1 = new CommandDoSetClockRunning(false);
			am.submitCommand(cdscr1);
		} else if (arr[1].equalsIgnoreCase("RESUME")) {
			CommandDoSetClockRunning cdscr2 = new CommandDoSetClockRunning(true);
			am.submitCommand(cdscr2);
		} else if (arr[1].equalsIgnoreCase("UPDATE")) {
			CommandDoClockUpdate cdcu = new CommandDoClockUpdate();
			am.submitCommand(cdcu);
		} else
			throw new RuntimeException("Clock command not found.");


	}
}
