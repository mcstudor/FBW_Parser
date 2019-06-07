package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;



public class CommandCreateAileron extends CommandChoice{

    CommandCreateAileron(ActionSet actionSet, String command) {
        super(actionSet, command);
    }

    @Override
    public void runCommand() throws RuntimeException {
        String[] args = this.command.split(" ");
        Identifier id = Validate.makeIdentifier(args[2]);
        Angle limUp = Validate.makeAngle(args[6]);
        Angle limDown = Validate.makeAngle(args[8]);
        Speed speed = Validate.makeSpeed(args[10]);
        Acceleration acc = Validate.makeAcceleration(args[12]);
        this.actionSet.getActionCreational().doCreateAileron(id, limUp, limDown, speed, acc);
    }
}

