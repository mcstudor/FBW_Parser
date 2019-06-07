package cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

import java.util.ArrayList;

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
		ArrayList<String> commands = new ArrayList<>();
		commands.add("create rudder r55 with limit 45 speed 5 acceleration 1");
		commands.add("Create Rudder R56 With Limit 45 Speed 5 Acceleration 1");
		commands.add("CrEaTe RuDdEr R57 WiTh LiMiT 45 SpEeD 5 AcCeLeRaTiOn 1");
		commands.add("create rudder r01 with limit 45 speed 5 acceleration 1");
		commands.add("create rudder r02 with limit 45 speed 5 acceleration 1");
		commands.add("create elevator ev01 with limit 45 speed 3.4 acceleration 1.2");
		commands.add("create elevator ev02 with limit 45 speed 3.4 acceleration 1.2");
		commands.add("create aileron a01 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a02 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a11 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a12 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a03 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a04 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a13 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create aileron a14 with limit up 45 down 45 speed 3 acceleration 1");
		commands.add("create split flap sf01 with limit 45 speed 5 acceleration 1");
		commands.add("create split flap sf02 with limit 45 speed 5 acceleration 1");
		commands.add("create split flap sf11 with limit 45 speed 5 acceleration 1");
		commands.add("create split flap sf12 with limit 45 speed 5 acceleration 1");
		commands.add("create fowler flap ff01 with limit 45 speed 5 acceleration 1");
		commands.add("create fowler flap ff11 with limit 45 speed 5 acceleration 1");
		commands.add("create engine e01 with speed 5 acceleration 1");
		commands.add("create engine e02 with speed 5 acceleration 1");
		commands.add("create engine e03 with speed 5 acceleration 1");
		commands.add("create nose gear ng01 with speed 5 acceleration 1");
		commands.add("create main gear mg01 with speed 5 acceleration 1");
		commands.add("create main gear mg11 with speed 5 acceleration 1");
		commands.add("declare rudder controller rc1 with rudder r01");
		commands.add("declare elevator controller evc1 with elevators ev01 ev02");
		commands.add("declare aileron controller ac1 with ailerons a01 a11 primary a01");
		commands.add("declare aileron controller ac2 with ailerons a02 a12 primary a02 slave a12 to a02 by 50 percent");
		commands.add("declare aileron controller ac3 with ailerons a03 a04 a13 a14 primary a03 slave a04 to a03 by 75 percent slave a13 to a14 by 75 percent");
		commands.add("declare flap controller fc1 with flaps sf01 sf11");
		commands.add("declare flap controller fc2 with flaps sf02 ff01 ff11 sf12");
		commands.add("declare engine controller ec1 with engine e01");
		commands.add("declare engine controller ec2 with engines e02 e03");
		commands.add("declare gear controller gc1 with gear nose ng01 main mg01 mg11");
		commands.add("declare bus bs1 with controller rc1 ec1 evc1 gc1");
		commands.add("declare bus bs2 with controllers fc1 fc2 ac1 ac2 ac3");
		commands.add("commit");
		commands.add("do rc1 deflect rudder 45 left");
		commands.add("do rc1 deflect rudder 45 right");
		commands.add("do evc1 deflect elevator 45 up");
		commands.add("do evc1 deflect elevator 45 down");
		commands.add("do ac1 deflect ailerons 45 up");
		commands.add("do ac1 deflect ailerons 45 down");
		commands.add("do ac1 speed brake on");
		commands.add("do ac1 speed brake off");
		commands.add("do fc1 deflect flap up");
		commands.add("do fc1 deflect flap 3");
		commands.add("do ec1 set power 50");
		commands.add("do ec1 set power 50 engine e01");
		commands.add("do gc1 gear up");
		commands.add("do gc1 gear down");
		commands.add("halt ec1");
		commands.add("@clock 5");
		commands.add("@clock pause");
		commands.add("@clock resume");
		commands.add("@clock update");
		commands.add("@clock");
		commands.add("@run \"src/test/testfile.txt\"");
		commands.add("@exit");
		commands.add("@wait 30");

		for(String s: commands){
			cli.processInput(s);
		}
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
