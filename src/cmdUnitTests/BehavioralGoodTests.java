package cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BehavioralGoodTests {
	private static CommandLineInterface cli;

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@BeforeEach
	void setup() throws FileNotFoundException {
		cli = new CommandLineInterface();
		File file = new File("src/cmdUnitTests/behaveSetup.txt");
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
	@DisplayName("Do Deflect Rudder Good Form")
	void doDeflectRudderTest(){
		cli.processInput("DO rc1 DEFLECT RUDDER 45 LEFT");
		cli.processInput("DO rc1 DEFLECT RUDDER 45 RIGHT");
	}

	@Test
	@DisplayName("Do Deflect Elevator Good Form")
	void doDeflectElevatorTest(){
		cli.processInput("DO evc1 DEFLECT ELEVATOR 45 UP");
		cli.processInput("DO evc1 DEFLECT ELEVATOR 45 DOWN");
	}

	@Test
	@DisplayName("Do Deflect Ailerons Good Form")
	void doDeflectAileronsTest(){
		cli.processInput("DO ac1 DEFLECT AILERONS 45 UP");
		cli.processInput("DO ac1 DEFLECT AILERONS 45 DOWN");
	}

	@Test
	@DisplayName("Do Speed Brake Good Form")
	void doSpeedBrakeTest(){
		cli.processInput("DO ac1 SPEED BRAKE ON");
		cli.processInput("DO ac1 SPEED BRAKE OFF");
	}

	@Test
	@DisplayName("Do Deflect Flap Good Form")
	void doDeflectFlapTest(){
		cli.processInput("DO fc1 DEFLECT FLAP UP");
		cli.processInput("DO fc1 DEFLECT FLAP 1");
		cli.processInput("DO fc1 DEFLECT FLAP 2");
		cli.processInput("DO fc1 DEFLECT FLAP 3");
		cli.processInput("DO fc1 DEFLECT FLAP 4");

	}

	@Test
	@DisplayName("Do Set Power Good Form")
	void doSetPowerTest(){
		cli.processInput("DO ec1 SET POWER 50");
		cli.processInput("DO ec1 SET POWER 0");
		cli.processInput("DO ec1 SET POWER 100");
		cli.processInput("DO ec1 SET POWER 50.5");
		cli.processInput("DO ec1 SET POWER 50 ENGINE e01");
		cli.processInput("DO ec1 SET POWER 0 ENGINE e01");
		cli.processInput("DO ec1 SET POWER 100 ENGINE e01");
		cli.processInput("DO ec1 SET POWER 50.5 ENGINE e01");
	}

	@Test
	@DisplayName("Do Set Gear Good Form")
	void doSetGearTest(){
		cli.processInput("DO gc1 GEAR UP");
		cli.processInput("DO gc1 GEAR DOWN");
	}

	@Test
	@DisplayName("Halt Good Form")
	void haltTest(){
		cli.processInput("HALT ec1");
	}




}
