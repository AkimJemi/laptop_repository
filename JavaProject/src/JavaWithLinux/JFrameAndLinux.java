package JavaWithLinux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringJoiner;

import javax.swing.JFrame;

public class JFrameAndLinux extends JFrame {
	public static final String path_bash = "C:/Program Files/Git/git-bash.exe";

	// Create a file Output.txt where git-bash prints the results
	public static final String path_file_output_git_bash = "C:/Users/wowp1/Desktop/laptop_github/laptop_repository/JavaProject/linux/save.txt";
	public static final Integer ARGS_MAX_LENGTH = 2;

	public static void main(String[] args) {
		// Path to your repository
		String command = null, git_command = null, path_repository = null;
//				"cd C:/Users/wowp1/Desktop/laptop_github/laptop_repository/JavaProject";
		// Git command you want to run
		for (int i = 0; i < args.length; i++) {
			switch (i) {
			case 0:
				git_command = args[i];
				command = reset(git_command);
				;
				break;
			case 1:
				path_repository = args[i];
				command = path_repository + " && " + git_command + " > " + path_file_output_git_bash;
				break;
			case 2:
				System.out.println("args.length : %d [ max length : %d ] ".formatted(args.length, ARGS_MAX_LENGTH));
				return;
			}
			command = command + " > " + path_file_output_git_bash;
			System.out.println(command);
			String output = runCommand(path_bash, "-c", command);

		}
	}

	private static String reset(String git_command) {
		if (git_command.contains(LinuxCommandList.HISTORY)) {
			String str = "";
			int i = 0;
			if (LinuxCommandList.HISTORY.length() < git_command.length()) {
				while (true) {
					int num = git_command.indexOf(LinuxCommandList.HISTORY) + LinuxCommandList.HISTORY.length() + i + 1;
					System.out.println("true");
					char ch = git_command.charAt(num);
					if (Character.isDigit(ch)) {
						str = str + String.valueOf(ch);
						i++;
					} else {
						if (i == 0) {
							git_command = git_command.replace(LinuxCommandList.HISTORY,
									LinuxCommandList.HISTORY_REPLACE);
						}
						git_command = git_command.replace(LinuxCommandList.HISTORY, LinuxCommandList.HISTORY_REPLACE_WITH_NUM).replace(ch, ch);
						break;
					}
				}
			} else {
				git_command = git_command.replace(LinuxCommandList.HISTORY, LinuxCommandList.HISTORY_REPLACE);
			}
			System.out.println(git_command);
		}
		return git_command;

	}

	public static String runCommand(String... command) {
		ProcessBuilder pb = new ProcessBuilder(command);
		Process p;
		StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
		try {
			p = pb.start();

			final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			reader.lines().iterator().forEachRemaining(joiner::add);

			p.waitFor();
			p.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return joiner.toString();
	}

	public static String readFileTxt() {
		String data = null;
		try {
			File myObj = new File(path_file_output_git_bash);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(" --- An error occurred");
			e.printStackTrace();
		}
		return data;
	}

}
