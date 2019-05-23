package sbw.project.cli.parser.cmdstategy;

import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public abstract class CommandChoice {
	//var accessible to subclasses
	protected ActionSet actionSet;
	protected String command;
	protected CommandChoice(ActionSet actionSet, String command){
		this.actionSet = actionSet;
		this.command = command;
	}
	//put the magic here
	public abstract void runCommand() throws ParseException;
}
