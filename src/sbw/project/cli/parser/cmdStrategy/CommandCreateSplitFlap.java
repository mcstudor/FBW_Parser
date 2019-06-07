package sbw.project.cli.parser.cmdStrategy;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionSet;

public class CommandCreateSplitFlap extends CommandChoice {

    CommandCreateSplitFlap(ActionSet actionSet, String command) {
        super(actionSet, command);
    }

    @Override
    public void runCommand() throws RuntimeException {
        String[] args = this.command.split(" ");
        Identifier id = Validate.makeIdentifier(args[3]);
        Angle angle = Validate.makeAngle(args[6]);
        Speed speed = Validate.makeSpeed(args[8]);
        Acceleration acc = Validate.makeAcceleration(args[10]);

        this.actionSet.getActionCreational().doCreateFlap(id, false, angle, speed, acc);
    }
}

