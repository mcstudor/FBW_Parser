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

class MiscBadTests {

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

	@Test
	@DisplayName("@Clock Rate Out of Bounds Bad Form")
	void miscClockOOBRateTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("@CLOCK -5");
		commands.add("@CLOCK .5");
		commands.add("@CLOCK 5.5");
		commands.add("@CLOCK 0");


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
	@DisplayName("@Clock Non-Numeral Bad Form")
	void miscClockNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("@CLOCK asdvd");
		commands.add("@CLOCK $#%#");
		commands.add("@CLOCK PAUSE RESUME");
		commands.add("@CLOCK PAUSE UPDATE");
		commands.add("@CLOCK PAUSE RESUME UPDATE");
		commands.add("@CLOCK RESUME UPDATE");



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
	@DisplayName("@Run Bad File Name")
	void miscRunBadFileNameTest(){
		cli = new CommandLineInterface();

		ArrayList<String> commands = new ArrayList<>();
		commands.add("@RUN src/sbw/project/cli/parser/cmdUnitTests/doesnotexist.txt");
		commands.add("@RUN \"\"");




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
	@DisplayName("@Wait Rate Out of Bounds Bad Form")
	void miscWaitOOBRateTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("@WAIT -5");
		commands.add("@WAIT .5");
		commands.add("@WAIT 5.5");
		commands.add("@WAIT 0");


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
	@DisplayName("@Clock Non-Numeral Bad Form")
	void miscWaitNonNumTest(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("@WAIT asdvd");
		commands.add("@WAIT $#%#");


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
