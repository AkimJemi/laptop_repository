package JavaWithLinux;

public class test {
	public static void main(String[] args) {
		String text = "ssshistory 10 diesh";
		String str = "";
		int i = 0;
		while (true) {
			int num = text.indexOf(LinuxCommandList.HISTORY) + LinuxCommandList.HISTORY.length() + i + 1;
			char ch = text.charAt(num);
			if (Character.isDigit(ch)) {
				str = str + String.valueOf(ch);
				i++;
			} else
				break;

		}
		System.out.println(str);
		System.out.println(i);
	}
}
