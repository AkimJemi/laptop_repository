package com.akim.main;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class FileController {

	public void getAllFileContent() {
		List<String> fileAllLines = Files.readAllLines(
				"C:\\Users\\wowp1\\Desktop\\laptop_github\\laptop_repository\\AkimJavaProject\\data\\file",
				Charset.forName("Shift-JIS"));
	}
}
