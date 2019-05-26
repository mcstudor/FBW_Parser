package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.ActionStructural;

import java.text.ParseException;

public class CommandCommit extends CommandChoice {

	public CommandCommit(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		
		ActionStructural as = this.actionSet.getActionStructural();
		as.doCommit();
	}
}
