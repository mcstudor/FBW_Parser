package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.action.command.behavioral.CommandDoSelectGear;

public class CommandDoGear extends CommandChoice {

	CommandDoGear(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws RuntimeException {
		// DO <id> GEAR UP|DOWN
		System.out.println(this.command);

		String[] arr = this.command.split(" ");
		ActionBehavioral ab = this.actionSet.getActionBehavioral();
		Identifier id = Validate.makeIdentifier(arr[1]);
		/*boolean isDown = true;
		if (arr[3].equals("UP")) isDown = false;
		 */
		//Replaced with
		boolean isDown =!(arr[3].equalsIgnoreCase("UP"));
		CommandDoSelectGear cd = new CommandDoSelectGear(id, isDown);
		ab.submitCommand(cd);
	}
}
