package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Rate;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoWait;

import java.text.ParseException;

public class CommandMiscWait extends CommandChoice {

	public CommandMiscWait(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		
		String[] arr = this.command.split(" ");
		
		if (Validate.isInteger(arr[1])) {
			int num = Integer.parseInt(arr[1]);
			Rate rate = new Rate(num);
			ActionMiscellaneous am = this.actionSet.getActionMiscellaneous();
			CommandDoWait cd = new CommandDoWait(rate);
			am.submitCommand(cd);
		}
	}
}
