package sbw.project.cli.parser.cmdStrategy;

import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.ActionStructural;

public class CommandCommit extends CommandChoice {

	CommandCommit(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException{

		ActionStructural as = this.actionSet.getActionStructural();
		as.doCommit();
	}
}
