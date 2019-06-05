package cmdUnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import sbw.project.cli.CommandLineInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BehavioralBadTests {
	private static CommandLineInterface cli;

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

	/*
		commands.add("DO rc1 DEFLECT RUDDER 45 LEFT");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 UP");
		commands.add("DO ac1 DEFLECT AILERONS 45 UP");
		commands.add("DO ac1 SPEED BRAKE ON");
		commands.add("DO fc1 DEFLECT FLAP UP");
		commands.add("DO ec1 SET POWER 50");
		commands.add("DO gc1 GEAR UP");

	 */


	/*
	This doesn't work. I think the arch is throwing an assertion error, but won't let me catch it through the CLI
	@Test
	@DisplayName("Do Controller ID Non-Exist Bad Form")
	public void commandDeclareIdDupTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO DNE_rc1 DEFLECT RUDDER 45 LEFT");
		commands.add("DO DNE_evc1 DEFLECT ELEVATOR 45 UP");
		commands.add("DO DNE_ac1 DEFLECT AILERONS 45 UP");
		commands.add("DO DNE_ac1 SPEED BRAKE ON");
		commands.add("DO DNE_fc1 DEFLECT FLAP UP");
		commands.add("DO DNE_ec1 SET POWER 50");
		commands.add("DO DNE_gc1 GEAR UP");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}

	 */

	@Test
	@DisplayName("Do Controller ID Bad Form")
	void commandDoBadIDTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO _rc1 DEFLECT RUDDER 45 LEFT");
		commands.add("DO _evc1 DEFLECT ELEVATOR 45 UP");
		commands.add("DO _ac1 DEFLECT AILERONS 45 UP");
		commands.add("DO _ac1 SPEED BRAKE ON");
		commands.add("DO _fc1 DEFLECT FLAP UP");
		commands.add("DO _ec1 SET POWER 50");
		commands.add("DO _gc1 GEAR UP");
		commands.add("HALT _gc1");

		commands.add("DO 324rc1 DEFLECT RUDDER 45 LEFT");
		commands.add("DO 324evc1 DEFLECT ELEVATOR 45 UP");
		commands.add("DO 324ac1 DEFLECT AILERONS 45 UP");
		commands.add("DO 324ac1 SPEED BRAKE ON");
		commands.add("DO 324fc1 DEFLECT FLAP UP");
		commands.add("DO 324ec1 SET POWER 50");
		commands.add("DO 324gc1 GEAR UP");
		commands.add("HALT 324gc1");
		commands.add("DO $#$rc1 DEFLECT RUDDER 45 LEFT");
		commands.add("DO $#$evc1 DEFLECT ELEVATOR 45 UP");
		commands.add("DO $#$ac1 DEFLECT AILERONS 45 UP");
		commands.add("DO $#$ac1 SPEED BRAKE ON");
		commands.add("DO $#$fc1 DEFLECT FLAP UP");
		commands.add("DO $#$ec1 SET POWER 50");
		commands.add("DO $#$gc1 GEAR UP");
		commands.add("HALT $#$gc1");

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
	@DisplayName("Do Angle Out of Bounds Bad Form")
	void commandDoAngleOOBTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO rc1 DEFLECT RUDDER -45 LEFT");
		commands.add("DO evc1 DEFLECT ELEVATOR -45 UP");
		commands.add("DO ac1 DEFLECT AILERONS -45 UP");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}

	@Test
	@DisplayName("Do Angle Non-Numeral Bad Form")
	void commandDoAngleNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO rc1 DEFLECT RUDDER asdv LEFT");
		commands.add("DO evc1 DEFLECT ELEVATOR dve UP");
		commands.add("DO ac1 DEFLECT AILERONS dfg UP");
		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}

	@Test
	@DisplayName("Do Position Out of Bounds Bad Form")
	void commandDoPosOOBTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO fc1 DEFLECT FLAP -1");
		commands.add("DO fc1 DEFLECT FLAP LEFT");
		commands.add("DO fc1 DEFLECT FLAP $#%");
		commands.add("DO fc1 DEFLECT FLAP 554");

		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}

	@Test
	@DisplayName("Do Power Out of Bounds Bad Form")
	void commandDoPowerOOBTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO ec1 SET POWER -50");
		commands.add("DO ec1 SET POWER 150");
		commands.add("DO ec1 SET POWER -50 ENGINE e01");
		commands.add("DO ec1 SET POWER 150 ENGINE e01");

		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}

	@Test
	@DisplayName("Do Power Non-Numeral Bad Form")
	void commandDoPowerNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO ec1 SET POWER adv");
		commands.add("DO ec1 SET POWER $#%");
		commands.add("DO ec1 SET POWER avx ENGINE e01");
		commands.add("DO ec1 SET POWER $%# ENGINE e01");

		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}
	@Test
	@DisplayName("Do Binary Choice Bad Form")
	void commandDoBinChoiceTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("DO rc1 DEFLECT RUDDER 45 UP");
		commands.add("DO rc1 DEFLECT RUDDER 45 LEFT RIGHT");
		commands.add("DO rc1 DEFLECT RUDDER 45 UP");
		commands.add("DO rc1 DEFLECT RUDDER 45 DOWN");
		commands.add("DO rc1 DEFLECT RUDDER 45 0");
		commands.add("DO rc1 DEFLECT RUDDER 45 1");
		commands.add("DO rc1 DEFLECT RUDDER 45 $$#%#");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 UP DOWN");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 LEFT");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 RIGHT");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 0");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 1");
		commands.add("DO evc1 DEFLECT ELEVATOR 45 #@$");
		commands.add("DO ac1 DEFLECT AILERONS 45 UP DOWN");
		commands.add("DO ac1 DEFLECT AILERONS 45 LEFT");
		commands.add("DO ac1 DEFLECT AILERONS 45 RIGHT");
		commands.add("DO ac1 DEFLECT AILERONS 45 0");
		commands.add("DO ac1 DEFLECT AILERONS 45 1");
		commands.add("DO ac1 DEFLECT AILERONS 45 $#$");
		commands.add("DO ac1 SPEED BRAKE ON OFF");
		commands.add("DO ac1 SPEED BRAKE 0");
		commands.add("DO ac1 SPEED BRAKE 1");
		commands.add("DO ac1 SPEED BRAKE $%#$");
		commands.add("DO gc1 GEAR UP DOWN");
		commands.add("DO gc1 GEAR RIGHT");
		commands.add("DO gc1 GEAR LEFT");
		commands.add("DO gc1 GEAR 0");
		commands.add("DO gc1 GEAR 1");
		commands.add("DO gc1 GEAR %^$%");


		ArrayList<Executable> exs = new ArrayList<>();
		for(String s: commands){
			exs.add(() ->
					assertThrows(Throwable.class,
							()->cli.processInput(s),
							"")
			);

		}
		Assertions.assertAll(exs);
	}




}
