package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.AileronSlaveMix;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Percent;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;
import java.util.ArrayList;

public class CommandDeclareAileronController extends CommandChoice {

	CommandDeclareAileronController(ActionSet actionSet, String command) {
		super(actionSet, command);
	}

	@Override
	public void runCommand() throws ParseException {
		System.out.println(this.command);
		String[] args = this.command.split(" ");
		Identifier controllerID = Validate.makeIdentifier(args[3]);

		ArrayList<Identifier> aileronIDs = new ArrayList<>();
		int i = 6;
		while(args[i].compareToIgnoreCase("PRIMARY")!=0) {
			aileronIDs.add(Validate.makeIdentifier(args[i]));
			i++;
		}
		i++;
		Identifier aileronPrim = Validate.makeIdentifier(args[i]);
		ArrayList<AileronSlaveMix> slaveMixes = new ArrayList<>();
		while(i<args.length-1){
			i = i+2;
			Identifier idSlave = Validate.makeIdentifier(args[i]);
			i = i+2;
			Identifier idMaster = Validate.makeIdentifier(args[i]);
			i = i+2;
			Percent percent = Validate.makePercent(args[i]);
			slaveMixes.add(new AileronSlaveMix(idMaster, idSlave, percent));
			i++;
		}
		this.actionSet.getActionStructural().
		doDeclareAileronController(controllerID, aileronIDs, aileronPrim, slaveMixes);
	}
}
