package cmdUnitTests;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;
import sbw.project.cli.CommandLineInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MiscGoodTests {
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
	@DisplayName("Misc Clock Rate Good Form")
	void miscClockRateTest(){
		cli.processInput("@CLOCK 5");
	}

	@Test
	@DisplayName("Misc Clock State Good Form")
	void miscClockStateTest(){
		cli.processInput("@CLOCK PAUSE");
		cli.processInput("@CLOCK RESUME");
		cli.processInput("@CLOCK UPDATE");
	}

	@Test
	@DisplayName("Misc Clock Report Good Form")
	void miscClockReportTest(){
		cli.processInput("@CLOCK");
	}

	@Test
	@DisplayName("Misc Exit Good Form")
	void miscExitTest(){
		cli.processInput("@EXIT");
	}

	@Test
	@DisplayName("Misc Wait Good Form")
	void miscWaitTest(){
		cli.processInput("@WAIT 30");
	}

	@Test
	@DisplayName("Misc Run Good Form")
	void miscRunTest(){
		ArrayList<String> commands = new ArrayList<>();
		ArrayList<Executable> exs = new ArrayList<>();
		commands.add("@RUN \"src/cmdUnitTests/testFile.txt\"");
		commands.add("@RUN \"src/cmdUnitTests/test File.txt\"");

		for(String s: commands){
			cli.processInput(s);
			exs.add(() ->
					assertDoesNotThrow(()->cli.processInput(s))
			);
		}
		Assertions.assertAll(exs);
	}





}
