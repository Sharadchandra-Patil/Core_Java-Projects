package com.app.utils;

public class UniqueAccountNumberGenerator {

	public static int accNum = 111000;

	public static int uniqueAccountNumberGenerator() {
		return ++accNum;

	}
}
