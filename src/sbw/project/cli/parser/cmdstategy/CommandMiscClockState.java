package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoClockUpdate;
import sbw.project.cli.action.command.misc.CommandDoSetClockRunning;


import java.text.ParseException;

public class CommandMiscClockState extends CommandChoice {

	public CommandMiscClockState(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();

		switch (arr[1]) {
		case "PAUSE":
			CommandDoSetClockRunning cdscr1 = new CommandDoSetClockRunning(false);
			am.submitCommand(cdscr1);
			break;
		case "RESUME":
			CommandDoSetClockRunning cdscr2 = new CommandDoSetClockRunning(true);
			am.submitCommand(cdscr2);
			break;
		case "UPDATE":
			CommandDoClockUpdate cdcu = new CommandDoClockUpdate();
			am.submitCommand(cdcu);
			break;
		default:
			System.out.println("Clock command not found.");

		}
	}
}
