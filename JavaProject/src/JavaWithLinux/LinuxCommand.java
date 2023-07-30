package JavaWithLinux;

import java.util.ArrayList;

enum INTERNAL_COMMANDS_AND_BUILTINS {
	alias, at, atq, cat, chgrp, chmod, chmond, chown, date, df, du, echo, env, export, grep, history, ll, ls, man,
	mount, passwd, printenv, ps, sed, set, type, useradd, userdel, usermod, vi, which;
}

enum OPTION {
	a, A, b, B, c, C;
}

public class LinuxCommand {

	public ArrayList<String> get_INTERNAL_COMMANDS_AND_BUILTINS_List() {
		ArrayList<String> list = new ArrayList<>();
		for (INTERNAL_COMMANDS_AND_BUILTINS enumValue : INTERNAL_COMMANDS_AND_BUILTINS.values()) {
			list.add(enumValue.toString());
		}
		return list;
	}

}

enum Week2 {
	SUN("일"), MON("월"), TUE("화"), WED("수"), THU("목"), FRI("금"), SAT("토");

	final private String day;

	Week2(String day) {
		this.day = day;
	}

	String getDay() {
		return day;
	}

}
