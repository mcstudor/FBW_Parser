package sbw.project.cli.parser;

import sbw.project.cli.CommandLineInterface;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.parser.cmdstategy.*;

import java.text.ParseException;

public class CommandParser {
	private CommandChooser commandChooser;
	private String command;

	public CommandParser(ActionSet actionSet, String command){
		this.commandChooser = new CommandChooser(actionSet);
		this.command = command.trim();
	}

	public static void main(String[] args){
		CommandLineInterface cli = new CommandLineInterface();
		cli.execute();
	}

	//Pulls comments, splits command, and calls single parser
	public void parse() throws ParseException {
		removeComments();
		if(!multiParse()){
			singleParse();
		}
	}

	//Strips comments off the end
	private void removeComments(){
		if(command.contains("//"))
			command = command.substring(0, command.indexOf("//"));
	}


	//this is where the parsing really begins
	private void singleParse() throws ParseException{
		CommandChoice choice = commandChooser.chooseCommand(command);
		choice.runCommand();
	}


	//Breaks up command into smaller command parts and calls them from left to right
	//While this is recursive, the subcommands should not have ";" in them after split()
	private boolean multiParse() throws ParseException{
		if(!command.contains(";")){
			return false;
		} else {
			String[] multiCommand = command.split(";");
			for(String s: multiCommand){
				CommandParser commandParser =
						new CommandParser(commandChooser.getActionSet(), s);
				commandParser.parse();
			}
			return true;
		}
	}


}
