package sbw.project.cli.parser.cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

public class CreationalTests {
	public static CommandLineInterface cli = new CommandLineInterface();

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	@DisplayName("Create Aileron Good Form")
	public void commandCreateAileronTest(){
		cli.processInput("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Elevator Good Form")
	public void commandCreateElevatorTest(){
		cli.processInput("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
	}

	@Test
	@DisplayName("Create Engine Good Form")
	public void commandCreateEngineTest(){
		cli.processInput("CREATE ENGINE e01 WITH SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Fowler Flap Good Form")
	public void commandCreateFowlerTest(){
		cli.processInput("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Split Flap Good Form")
	public void commandCreateSplitTest(){
		cli.processInput("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Main Gear Good Form")
	public void commandCreateMainTest(){
		cli.processInput("CREATE MAIN GEAR mg01 WITH SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Nose Gear Good Form")
	public void commandCreateNoseTest(){
		cli.processInput("CREATE NOSE GEAR ng01 WITH SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Rudder Good Form")
	public void commandCreateRudderTest(){
		cli.processInput("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
	}

}
