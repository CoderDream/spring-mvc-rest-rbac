package com.coderdream.util;

public class GetBin {
	/**
	 * @param 根据权限值来进行位运算，二进制进多少位
	 */
	public static void main(String[] args) {
		int val = 3;
		// System.out.println(Integer.toBinaryString(val));
		// 32位来运算的，前面的0这里省略
		System.out.println(1 << 0);// 01<<0=01=1
		System.out.println(1 << 1);// 01<<1=010=2
		System.out.println(1 << 2);// 01<<2=0100=4
		System.out.println(1 << 3);// 01<<3=01000=8
		System.out.println(1 << 4);// 01<<4=010000=16
		System.out.println(1 << 5);// 一直断续.......
		System.out.println(1 << 6);
		System.out.println(1 << 7);
		System.out.println(1 << 8);
		System.out.println(1 << 9);
		System.out.println(1 << 10);
		System.out.println(1 << 11);
	}

}
