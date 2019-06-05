package cmdUnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import sbw.project.cli.CommandLineInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StructuralBadTests {
	private static CommandLineInterface cli;
	/*
	This class is looking for commands that should fail. Most likely corner cases.
	 */

	@BeforeEach
	void setup() throws FileNotFoundException {
		cli = new CommandLineInterface();
		File file = new File("src/cmdUnitTests/structSetup.txt");
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
	@DisplayName("Declare Controller ID Duplication Bad Form")
	void commandDeclareIdDupTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DECLARE RUDDER CONTROLLER rc1 WITH RUDDER r01");
		commands.add("DECLARE ELEVATOR CONTROLLER evc1 WITH ELEVATORS ev01 ev02");
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS a01 a11 PRIMARY a01");
		commands.add("DECLARE FLAP CONTROLLER fc1 WITH FLAPS sf01 sf11");
		commands.add("DECLARE ENGINE CONTROLLER ec1 WITH ENGINE e01");
		commands.add("DECLARE GEAR CONTROLLER gc1 WITH GEAR NOSE ng01 MAIN mg01 mg11");
		commands.add("DECLARE BUS bs1 WITH CONTROLLER rc1 ec1 evc1 gc1");

		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			cli.processInput(s);
			exs.add(() ->
					assertThrows(RuntimeException.class,
							()->cli.processInput(s),
							"")
			);
		}
		Assertions.assertAll(exs);
	}

	@Test
	@DisplayName("Declare Bad Controller ID")
	void commandDeclareBadCtlIDTest(){
			ArrayList<String> commands = new ArrayList<>();
		commands.add("DECLARE RUDDER CONTROLLER _rc01 WITH RUDDER r01");
		commands.add("DECLARE ELEVATOR CONTROLLER _evc1 WITH ELEVATORS ev01 ev02");
		commands.add("DECLARE AILERON CONTROLLER _ac1 WITH AILERONS a01 a11 PRIMARY a01");
		commands.add("DECLARE FLAP CONTROLLER _fc1 WITH FLAPS sf01 sf11");
		commands.add("DECLARE ENGINE CONTROLLER _ec1 WITH ENGINE e01");
		commands.add("DECLARE GEAR CONTROLLER _gc1 WITH GEAR NOSE ng01 MAIN mg01 mg11");
		commands.add("DECLARE BUS _bs1 WITH CONTROLLER rc1 ec1 evc1 gc1");
		commands.add("DECLARE RUDDER CONTROLLER 324rc1 WITH RUDDER r01");
		commands.add("DECLARE ELEVATOR CONTROLLER 43evc1 WITH ELEVATORS ev01 ev02");
		commands.add("DECLARE AILERON CONTROLLER 234ac1 WITH AILERONS a01 a11 PRIMARY a01");
		commands.add("DECLARE FLAP CONTROLLER 5fc1 WITH FLAPS sf01 sf11");
		commands.add("DECLARE ENGINE CONTROLLER 43ec1 WITH ENGINE e01");
		commands.add("DECLARE GEAR CONTROLLER 32gc1 WITH GEAR NOSE ng01 MAIN mg01 mg11");
		commands.add("DECLARE BUS 432bs1 WITH CONTROLLER rc1 ec1 evc1 gc1");
		commands.add("DECLARE RUDDER CONTROLLER %$rc1 WITH RUDDER r01");
		commands.add("DECLARE ELEVATOR CONTROLLER %^$evc1 WITH ELEVATORS ev01 ev02");
		commands.add("DECLARE AILERON CONTROLLER ^$ac1 WITH AILERONS a01 a11 PRIMARY a01");
		commands.add("DECLARE FLAP CONTROLLER $^fc1 WITH FLAPS sf01 sf11");
		commands.add("DECLARE ENGINE CONTROLLER ^#ec1 WITH ENGINE e01");
		commands.add("DECLARE GEAR CONTROLLER &%^gc1 WITH GEAR NOSE ng01 MAIN mg01 mg11");
		commands.add("DECLARE BUS @#bs1 WITH CONTROLLER rc1 ec1 evc1 gc1");
			ArrayList<Executable> exs = new ArrayList<>();
			for(String s: commands){
				exs.add(() ->
						assertThrows(RuntimeException.class,
								()->cli.processInput(s),
								"")
				);
			}
			Assertions.assertAll(exs);

	}


	@Test
	@DisplayName("Declare Bad Component ID")
	void commandDeclareBadCompIDTest(){

		ArrayList<String> commands = new ArrayList<>();
		commands.add("DECLARE RUDDER CONTROLLER rc1 WITH RUDDER _r01");
		commands.add("DECLARE ELEVATOR CONTROLLER evc1 WITH ELEVATORS _ev01 _ev02");
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS _a01 _a11 PRIMARY _a01");
		commands.add("DECLARE FLAP CONTROLLER fc1 WITH FLAPS _sf01 _sf11");
		commands.add("DECLARE ENGINE CONTROLLER ec1 WITH ENGINE _e01");
		commands.add("DECLARE GEAR CONTROLLER gc1 WITH GEAR NOSE _ng01 MAIN _mg01 _mg11");
		commands.add("DECLARE BUS bs1 WITH CONTROLLER _rc1 _ec1 _evc1 _gc1");
		commands.add("DECLARE RUDDER CONTROLLER rc1 WITH RUDDER 232r01");
		commands.add("DECLARE ELEVATOR CONTROLLER evc1 WITH ELEVATORS 231ev01 23ev02");
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS 23a01 23a11 PRIMARY 23a01");
		commands.add("DECLARE FLAP CONTROLLER fc1 WITH FLAPS 23sf01 42sf11");
		commands.add("DECLARE ENGINE CONTROLLER ec1 WITH ENGINE 23e01");
		commands.add("DECLARE GEAR CONTROLLER gc1 WITH GEAR NOSE 42ng01 MAIN 24mg01 45mg11");
		commands.add("DECLARE BUS bs1 WITH CONTROLLER 52rc1 43ec1 21evc1 32gc1");
		commands.add("DECLARE RUDDER CONTROLLER rc1 WITH RUDDER %$#r01");
		commands.add("DECLARE ELEVATOR CONTROLLER evc1 WITH ELEVATORS %$#ev01 %$#ev02");
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS %$#a01 %$#a11 PRIMARY %$#a01");
		commands.add("DECLARE FLAP CONTROLLER fc1 WITH FLAPS %$#sf01 %$#sf11");
		commands.add("DECLARE ENGINE CONTROLLER ec1 WITH ENGINE %$#e01");
		commands.add("DECLARE GEAR CONTROLLER gc1 WITH GEAR NOSE %$#ng01 MAIN %$#mg01 %$#mg11");
		commands.add("DECLARE BUS bs1 WITH CONTROLLER %$#rc1 %$#ec1 %$#evc1 %$#gc1");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(RuntimeException.class,
							()->cli.processInput(s),
							"")
			);
		}
		Assertions.assertAll(exs);
	}


	@Test
	@DisplayName("Declare Aileron Duplication Test")
	void declareAileronDupTests(){

		ArrayList<String> commands = new ArrayList<>();
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS a01 a01 PRIMARY a01");
		commands.add("DECLARE AILERON CONTROLLER ac2 WITH AILERONS a02 a02 PRIMARY a02 SLAVE a02 TO a02 BY 50 PERCENT");
		commands.add("DECLARE AILERON CONTROLLER ac3 WITH AILERONS a03 a03 a03 a03 PRIMARY a03 SLAVE a03 TO a03 BY 75 PERCENT SLAVE a03 TO a03 BY 75 PERCENT");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(RuntimeException.class,
							()->cli.processInput(s),
							"")
			);
		}
		Assertions.assertAll(exs);
	}

	@Test
	@DisplayName("Declare Odd Number Test")
	void declareOddTests(){

		ArrayList<String> commands = new ArrayList<>();
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS a01 a02 a03 PRIMARY a01");
		commands.add("DECLARE AILERON CONTROLLER ac1 WITH AILERONS a11 a12 a13 PRIMARY a01");
		commands.add("DECLARE FLAP CONTROLLER fc1 WITH FLAPS sf01");
		commands.add("DECLARE FLAP CONTROLLER fc2 WITH FLAPS sf02 ff01 ff11");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(RuntimeException.class,
							()->cli.processInput(s),
							"")
			);
		}
		Assertions.assertAll(exs);
	}
		/*
		This one doesn't work either?
	@Test
	@DisplayName("Declare Aileron Cycle Test")
	void declareAileronCycleTests(){

		ArrayList<String> commands = new ArrayList<>();
		commands.add("DECLARE AILERON CONTROLLER ac2 WITH AILERONS a01 a02 PRIMARY a01 SLAVE a01 TO a02 BY 50 PERCENT");
		commands.add("DECLARE AILERON CONTROLLER ac3 WITH AILERONS a03 a04 a13 a14 PRIMARY a03 SLAVE a04 TO a03 BY 75 PERCENT SLAVE a13 TO a04 BY 75 PERCENT");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(RuntimeException.class,
							()->cli.processInput(s),
							"")
			);
		}
		Assertions.assertAll(exs);
	}

		 */


}
