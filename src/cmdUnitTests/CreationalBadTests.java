package cmdUnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import sbw.project.cli.CommandLineInterface;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
class CreationalBadTests {
	private CommandLineInterface cli;
	@BeforeEach
	void setup(){
		cli = new CommandLineInterface();
	}
		/*
		commands.add("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ENGINE e01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE NOSE GEAR ng01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE MAIN GEAR mg01 WITH SPEED 5 ACCELERATION 1");
		*/

	@Test
	@DisplayName("Creational Bad ID")
	void createBadIdTest(){
		ArrayList<String> commands = new ArrayList<>();
		//may contain _ but may not start with
		commands.add("CREATE RUDDER _r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR _ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON _a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP _sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP _ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ENGINE _e01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE NOSE GEAR _ng01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE MAIN GEAR _mg01 WITH SPEED 5 ACCELERATION 1");

		//must not start with number
		commands.add("CREATE RUDDER 321r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR 321ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON 321a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP 321sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP 321ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ENGINE 321e01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE NOSE GEAR 321ng01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE MAIN GEAR 321mg01 WITH SPEED 5 ACCELERATION 1");

		//must not contain special chars
		commands.add("CREATE RUDDER $@#r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR $@#ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON $@#a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP $@#sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP $@#ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ENGINE $@#e01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE NOSE GEAR $@#ng01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE MAIN GEAR $@#mg01 WITH SPEED 5 ACCELERATION 1");

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
	@DisplayName("Creational ID Duplication")
	void createDupIdTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ENGINE e01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE NOSE GEAR ng01 WITH SPEED 5 ACCELERATION 1");
		commands.add("CREATE MAIN GEAR mg01 WITH SPEED 5 ACCELERATION 1");


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
	@DisplayName("Acceleration Out of Bounds")
	void createAccOOBTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION -1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION -1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION -1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED 5 ACCELERATION -1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED 5 ACCELERATION -1");
		commands.add("CREATE ENGINE e01 WITH SPEED 5 ACCELERATION -1");
		commands.add("CREATE NOSE GEAR ng01 WITH SPEED 5 ACCELERATION -1");
		commands.add("CREATE MAIN GEAR mg01 WITH SPEED 5 ACCELERATION -1");


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
	@DisplayName("Acceleration Non-Numeral Value")
	void createAccNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT 45 SPEED 5 ACCELERATION dfe");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED 3.4 ACCELERATION vds");
		commands.add("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED 3 ACCELERATION dva");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED 5 ACCELERATION verw");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED 5 ACCELERATION verwv");
		commands.add("CREATE ENGINE e01 WITH SPEED 5 ACCELERATION asv");
		commands.add("CREATE NOSE GEAR ng01 WITH SPEED 5 ACCELERATION dev");
		commands.add("CREATE MAIN GEAR mg01 WITH SPEED 5 ACCELERATION devg");


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
	@DisplayName("Angle Out of Bounds")
	void createAngleOOBTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT -45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT -45 SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP -45 DOWN -45 SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT -45 SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT -45 SPEED 5 ACCELERATION 1");



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
	@DisplayName("Angle Non-Numeral Value")
	void createAngleNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT adfae SPEED 5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT agd SPEED 3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP ewg DOWN dfa SPEED 3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT gfv SPEED 5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT dge SPEED 5 ACCELERATION 1");


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
	@DisplayName("Speed Out of Bounds")
	void createSpeedOOBTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT 45 SPEED -5 ACCELERATION 1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED -3.4 ACCELERATION 1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED -3 ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED -5 ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED -5 ACCELERATION 1");
		commands.add("CREATE ENGINE e01 WITH SPEED -5 ACCELERATION 1");
		commands.add("CREATE NOSE GEAR ng01 WITH SPEED -5 ACCELERATION 1");
		commands.add("CREATE MAIN GEAR mg01 WITH SPEED -5 ACCELERATION 1");



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
	@DisplayName("Speed Non-Numeral Value")
	void createSpeedNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("CREATE RUDDER r01 WITH LIMIT 45 SPEED dfa ACCELERATION 1");
		commands.add("CREATE ELEVATOR ev01 WITH LIMIT 45 SPEED vde ACCELERATION 1.2");
		commands.add("CREATE AILERON a01 WITH LIMIT UP 45 DOWN 45 SPEED gdw ACCELERATION 1");
		commands.add("CREATE SPLIT FLAP sf01 WITH LIMIT 45 SPEED vds ACCELERATION 1");
		commands.add("CREATE FOWLER FLAP ff01 WITH LIMIT 45 SPEED vsa ACCELERATION 1");
		commands.add("CREATE ENGINE e01 WITH SPEED dvs ACCELERATION 1");
		commands.add("CREATE NOSE GEAR ng01 WITH SPEED avs ACCELERATION 1");
		commands.add("CREATE MAIN GEAR mg01 WITH SPEED dve ACCELERATION 1");


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
}
