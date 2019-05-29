package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSelectGear;

import java.text.ParseException;

public class CommandDoGear extends CommandChoice {

	public CommandDoGear(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		// DO <id> GEAR UP|DOWN
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = Validate.makeIdentifier(arr[1]);
		boolean isDown = true;
		if (arr[3].equals("UP")) isDown = false;
		CommandDoSelectGear cd = new CommandDoSelectGear(id, isDown);
		ab.submitCommand(cd);
	}
}
