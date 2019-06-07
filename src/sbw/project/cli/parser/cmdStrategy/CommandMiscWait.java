package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.Rate;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.misc.CommandDoWait;

public class CommandMiscWait extends CommandChoice {

	CommandMiscWait(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		
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
