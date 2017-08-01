package com.sam.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardUtil {

	public static int getInt(String message){
	try{	Scanner scanner= new Scanner(System.in);
		System.out.println(message);
		return scanner.nextInt();
	} catch (Exception e) {
		throw new InputMismatchException();
	}
	}
	public static String getStr(String message){
		Scanner scanner= new Scanner(System.in);
		System.out.println(message);
		return scanner.nextLine().trim();
	}
}
