package cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

public class GeneralGoodTests {
	private static CommandLineInterface cli;

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@BeforeEach
	void setup(){
		cli = new CommandLineInterface();
	}

	@Test
	@DisplayName("Case Sensitive Test")
	void genCaseTest(){
		cli.processInput("create rudder r55 with limit 45 speed 5 acceleration 1");
		cli.processInput("Create Rudder R56 With Limit 45 Speed 5 Acceleration 1");
		cli.processInput("CrEaTe RuDdEr R57 WiTh LiMiT 45 SpEeD 5 AcCeLeRaTiOn 1");
	}


	@Test
	@DisplayName("MultiCommand Test")
	void genMultiCmdTest(){
		cli.processInput("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1;" +
				" CREATE RUDDER r02 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		cli.processInput("CREATE RUDDER r03 WITH LIMIT 45 SPEED 5 ACCELERATION 1;" +
				" CREATE RUDDER r04 WITH LIMIT 45 SPEED 5 ACCELERATION 1;" +
				"CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2;" +
				"CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
	}

	@Test
	@DisplayName("Comment Test")
	void genCommentTest(){
		cli.processInput("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1" +
				" //This should be ignored" +
				"CREATE RUDDER r02 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		cli.processInput("//No command CREATE RUDDER r03 WITH LIMIT 45 SPEED 5 ACCELERATION 1;");
	}

	@Test
	@DisplayName("MultiCommand and Comment Test")
	void genMultiCmdWithCommentTest(){
		cli.processInput("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1;" +
				" CREATE RUDDER r02 WITH LIMIT 45 SPEED 5 ACCELERATION 1"
		+"//This should be ignored");
		cli.processInput("CREATE RUDDER r03 WITH LIMIT 45 SPEED 5 ACCELERATION 1;" +
				" CREATE RUDDER r04 WITH LIMIT 45 SPEED 5 ACCELERATION 1;" +
				"CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2;" +
				"// ignore this command CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
	}
}
