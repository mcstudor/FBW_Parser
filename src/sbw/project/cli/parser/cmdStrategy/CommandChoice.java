package sbw.project.cli.parser.cmdStrategy;

import sbw.project.cli.action.ActionSet;

public abstract class CommandChoice {
	//var accessible to subclasses
	ActionSet actionSet;
	String command;
	CommandChoice(ActionSet actionSet, String command){
		this.actionSet = actionSet;
		this.command = command;
	}
	//put the magic here
	public abstract void runCommand() throws RuntimeException;
}
