package com.sam.util;

import java.util.Scanner;

public class KeyboardUtil {

	public static int getInt(String message){
		Scanner scanner= new Scanner();
		System.out.println(message);
		String str=scanner.next().trim();
		return Integer.parseInt(str);
	}
	public static String getStr(String message){
		Scanner scanner= new Scanner();
		System.out.println(message);
		return scanner.next().trim();
	}
}
