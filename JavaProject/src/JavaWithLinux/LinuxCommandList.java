package JavaWithLinux;

public class LinuxCommandList {

	public final static String HISTORY = "history";
	public final static String HISTORY_REPLACE = "cat $HISTFILE | nl";
	public final static String HISTORY_REPLACE_WITH_NUM = HISTORY_REPLACE + " | tail -{num}";
	public final static String HISTORY_HEAD = "$HISTFILE | head -{num}";

}
