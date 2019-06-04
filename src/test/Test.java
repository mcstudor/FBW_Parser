package test;

import sbw.project.cli.CommandLineInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args ) throws FileNotFoundException {
		File file = new File("src/test/cmds.txt");
		//File file = new File("src/test/csTests.txt");

		CommandLineInterface cli = new CommandLineInterface();

		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			try {
				cli.processInput(line);
			} catch (Exception e){
				System.out.println("Exception: " + e.getMessage());
			}
		}
		sc.close();
	}
}
