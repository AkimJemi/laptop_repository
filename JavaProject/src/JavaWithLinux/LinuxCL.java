package JavaWithLinux;

/**
 * 	LinuxCommandList
 * @author wowp1
 *
 */
public class LinuxCL {

	public final static String HISTORY = "history";
	public final static String HISTORY_WITH_SPACE = HISTORY + "\s";
	public final static String HISTORY_REPLACE = "cat $HISTFILE | nl";
	public final static String HISTORY_REPLACE_WITH_NUM = HISTORY_REPLACE + " | tail -";
	public final static String HISTORY_HEAD = "$HISTFILE | head -";

}
