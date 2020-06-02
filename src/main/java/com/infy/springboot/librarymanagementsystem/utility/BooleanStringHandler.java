package com.infy.springboot.librarymanagementsystem.utility;

public class BooleanStringHandler {
	
	public static String booleanToString(Boolean bool) {
		String s = bool?"Yes":"No";
		return s;
	}
}
