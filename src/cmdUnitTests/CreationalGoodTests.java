package cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

class CreationalGoodTests {
	private CommandLineInterface cli;

	@Rule
	private ExpectedException expected = ExpectedException.none();
	@BeforeEach
	void setup(){
		cli = new CommandLineInterface();
	}
	@Test
	@DisplayName("Create Aileron Good Form")
	void commandCreateAileronTest(){
		cli.processInput("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Elevator Good Form")
	void commandCreateElevatorTest(){
		cli.processInput("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
	}

	@Test
	@DisplayName("Create Engine Good Form")
	void commandCreateEngineTest(){
		cli.processInput("CREATE ENGINE e01 WITH SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Fowler Flap Good Form")
	void commandCreateFowlerTest(){
		cli.processInput("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Split Flap Good Form")
	void commandCreateSplitTest(){
		cli.processInput("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Main Gear Good Form")
	void commandCreateMainTest(){
		cli.processInput("CREATE MAIN GEAR mg01 WITH SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Nose Gear Good Form")
	void commandCreateNoseTest(){
		cli.processInput("CREATE NOSE GEAR ng01 WITH SPEED 5 ACCELERATION 1");
	}

	@Test
	@DisplayName("Create Rudder Good Form")
	void commandCreateRudderTest(){
		cli.processInput("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
	}

}
