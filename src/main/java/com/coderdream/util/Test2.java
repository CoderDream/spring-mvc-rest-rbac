package com.coderdream.util;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

	// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27
	// 28 29 30 31 32 33 34
	public static void main(String[] args) {
		String str = "12C2";
		int i = Integer.parseInt(str, 16);
		String str2 = Integer.toBinaryString(i);
		System.out.println(str2);

		// HexToDec("1e6f");
	}

	/**
	 * 将十六进制的字符串转化为十进制的数值
	 */
	public static long HexToDec(String hexStr) {
		Map<String, Integer> hexMap = prepareData(); // 先准备对应关系数据
		int length = hexStr.length();
		long result = 0L; // 保存最终的结果
		for (int i = 0; i < length; i++) {
			result += hexMap.get(hexStr.subSequence(i, i + 1))
					* Math.pow(16, length - 1 - i);
		}
		System.out.println("hexStr=" + hexStr + ",result=" + result);
		return result;
	}

	/**
	 * 准备十六进制字符对应关系。如("1",1)...("A",10),("B",11)
	 */
	private static HashMap<String, Integer> prepareData() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 1; i <= 9; i++) {
			hashMap.put(i + "", i);
		}
		hashMap.put("a", 10);
		hashMap.put("b", 11);
		hashMap.put("c", 12);
		hashMap.put("d", 13);
		hashMap.put("e", 14);
		hashMap.put("f", 15);
		return hashMap;
	}
}
