package sbw.project.cli.parser.cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StructuralGoodTests {

	/*
		This version of the test look at values that are acceptable
	 */
	public static CommandLineInterface cli = new CommandLineInterface();

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@BeforeAll
	public static void setup() throws FileNotFoundException{
		File file = new File("src/sbw/project/cli/parser/cmdUnitTests/structSetup.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			try {
				cli.processInput(line);
			} catch(RuntimeException e){
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

	@Test
	@DisplayName("Declare Rudder Good Form")
	public void commandDeclareRudderTest(){
		cli.processInput("DECLARE RUDDER CONTROLLER rc1 WITH RUDDER r01");
	}

	@Test
	@DisplayName("Declare Elevator Good Form")
	public void commandDeclareElevatorTest(){
		cli.processInput("DECLARE ELEVATOR CONTROLLER evc1 WITH ELEVATORS ev01 ev02");
	}

	@Test
	@DisplayName("Declare Aileron Min Good Form")
	public void commandDeclareAileronMinTest(){
		cli.processInput("DECLARE AILERON CONTROLLER ac1 WITH AILERONS a01 a11 PRIMARY a01");
	}

	@Test
	@DisplayName("Declare Aileron w/slave Good Form")
	public void commandDeclareAileronSlaveTest(){
		cli.
		processInput("DECLARE AILERON CONTROLLER ac2 WITH AILERONS a02 a12 PRIMARY a02 SLAVE a12 TO a02 BY 50 PERCENT");
	}

	@Test
	@DisplayName("Declare Aileron w/all Good Form")
	public void commandDeclareAileronAllTest(){
		cli.
		processInput("DECLARE AILERON CONTROLLER ac3 WITH AILERONS a03 a04 a13 a14 PRIMARY a03 SLAVE a04 TO a03 BY 75 PERCENT SLAVE a13 TO a14 BY 75 PERCENT");
	}

	@Test
	@DisplayName("Declare Flap Min Good Form")
	public void commandDeclareFlapMinTest(){
		cli.processInput("DECLARE FLAP CONTROLLER fc1 WITH FLAPS sf01 sf11");
	}

	@Test
	@DisplayName("Declare Flap All Good Form")
	public void commandDeclareFlapAllTest(){
		cli.processInput("DECLARE FLAP CONTROLLER fc2 WITH FLAPS sf02 ff01 ff11 sf12");
	}

	@Test
	@DisplayName("Declare Engine Min Good Form")
	public void commandDeclareEngineMinTest(){
		cli.processInput("DECLARE ENGINE CONTROLLER ec1 WITH ENGINE e01");
	}

	@Test

	@DisplayName("Declare Engine Min Good Form")
	public void commandDeclareEngineAllTest(){
		cli.processInput("DECLARE ENGINE CONTROLLER ec2 WITH ENGINES e02 e03");
	}


	@Test
	@DisplayName("Declare Gear Good Form")
	public void commandDeclareGearTest(){
		cli.processInput("DECLARE GEAR CONTROLLER gc1 WITH GEAR NOSE ng01 MAIN mg01 mg11");
	}

	@Test

	@DisplayName("Declare Bus Good Form")
	public void commandDeclareBusTest(){
		cli.processInput("DECLARE BUS bs1 WITH CONTROLLER gc_test ec_test");
	}

	@Test
	@AfterAll
	@DisplayName("Commit Good Form")
	public static void commandCommitTest(){
		cli.processInput("COMMIT");
	}





}
