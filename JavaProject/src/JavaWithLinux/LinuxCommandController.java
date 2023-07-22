package JavaWithLinux;

import javax.swing.JFrame;

public class LinuxCommandController extends JFrame {
	public static final String path_bash = "C:/Program Files/Git/git-bash.exe";

	// Create a file Output.txt where git-bash prints the results
	public static final String path_file_output_git_bash = "C:/Users/wowp1/Desktop/laptop_github/laptop_repository/JavaProject/linux/save.txt";
	public static final Integer ARGS_MAX_LENGTH = 2;

	public void main(String[] args) {
		// Path to your repository
		String command = null, git_command = null, path_repository = null;
		// Git command you want to run
		for (int i = 0; i < args.length; i++) {
			switch (i) {
			case 0:
				git_command = args[i];
				command = reset(git_command);
				break;
			case 1:
				path_repository = args[i];
				command = path_repository + " && " + git_command + " > " + path_file_output_git_bash;
				break;
			case 2:
				System.out.println("args.length : %d [ max length : %d ] ".formatted(args.length, ARGS_MAX_LENGTH));
				return;
			}
			command = command + " >> " + path_file_output_git_bash;
			runCommand(path_bash, "-c", command);
			System.out.println("command : " + command);
		}
	}

	private String reset(String git_command) {
		try {
			if (git_command.trim().equals(LinuxCL.HISTORY)) {
				git_command = git_command.replace(LinuxCL.HISTORY, LinuxCL.HISTORY_REPLACE);
			} else if (git_command.contains(LinuxCL.HISTORY_WITH_SPACE)) {
				int num = LinuxCL.HISTORY_WITH_SPACE.length();
				boolean condition1 = git_command.length() >= num;
				boolean condition2 = Character.isDigit((char) git_command.charAt(num));
				if (condition1 && condition2) {
					git_command = git_command.replace(LinuxCL.HISTORY_WITH_SPACE,
							LinuxCL.HISTORY_REPLACE_WITH_NUM);
				} else {
					git_command = git_command.replace(LinuxCL.HISTORY_WITH_SPACE,
							LinuxCL.HISTORY_REPLACE);
				}
			}
			return git_command;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void runCommand(String... command) {
		Process p;
		try {
			p = new ProcessBuilder(command).start();
			p.waitFor();
			p.destroy();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
