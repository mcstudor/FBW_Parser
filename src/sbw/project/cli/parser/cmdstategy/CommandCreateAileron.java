package sbw.project.cli.parser.cmdstategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

import java.text.ParseException;

public class CommandCreateAileron extends CommandChoice{

    CommandCreateAileron(ActionSet actionSet, String command) {
        super(actionSet, command);
    }

    @Override
    public void runCommand() throws ParseException {
        System.out.println(this.command);
        String[] args = this.command.split(" ");
        Identifier id = Validate.makeIdentifier(args[2]);
        Angle limUp = Validate.makeAngle(args[6]);
        Angle limDown = Validate.makeAngle(args[8]);
        Speed speed = Validate.makeSpeed(args[10]);
        Acceleration acc = Validate.makeAcceleration(args[12]);
        this.actionSet.getActionCreational().doCreateAileron(id, limUp, limDown, speed, acc);
    }
}

