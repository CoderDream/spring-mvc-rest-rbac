package com.coderdream.util;

public class Permission {

	/**
	 * @author liangrui
	 * @qq 1067165280 这种算法的一个优点是速度快
	 */

	/******************************************
	 * 这是做测试相当于从数据库里取出的权限值 /一般根据一个模块id 取出它的crud 值就可以了
	 * 
	 * 删除A---0 修改A---1 添加A---2 删除B---3 修改B---4 添加B---5 ...... 理论上可以有N个操作
	 * 
	 * 用户有权限：添加A---2;删除B---3;修改B---4 2的2次方+2的3次方+2的4次方=28purview权限值
	 * 
	 *******************************************/

	static int purview = 28;
	static int BdelPermi = 3;// 删除B=3
	static int BaddPermi = 5;// 添加B=5
	static int BupdaetPermi = 5;// 修改B==4

	public static void main(String[] args) {
		// 根据用户拥有的权限值，和功能模块的权限值来判断 用户是否拥有该操作模块的权限
		isPermission(purview, BdelPermi, BaddPermi, BupdaetPermi);

		/**
		 * purview 用户当前权限值
		 * 
		 * newValue 权限值 flag= true 为增加，false 删除
		 */

		int modePermValue = 3; // 相关模块的id 这里做测试 就省略

		// 删除B---3 这里做测除测试
		int newValue = 3;
		boolean flag = false;

		// 更改用户的权限
		purview = setPermission(purview, modePermValue, newValue, flag);

		System.out.println("-------------修改权限后------------------------");
		// 再一次查询相关权限
		isPermission(purview, BdelPermi, BaddPermi, BupdaetPermi);

		// 添加B---5 这里做为用户增加一个权限
		newValue = 5;
		flag = true;
		// 更改用户的权限
		purview = setPermission(purview, modePermValue, newValue, flag);

		System.out.println("-------------修改权限后------------------------");
		// 再一次查询相关权限
		isPermission(purview, BdelPermi, BaddPermi, BupdaetPermi);
	}

	private static void isPermission(int purview, int BdelPermi, int BaddPermi,
			int BupdaetPermi) {
		// 通过移位得到权限的二进制码
		int Bdel = 1 << BdelPermi;
		int Badd = 1 << BaddPermi;
		int Bupd = 1 << BupdaetPermi;

		// 也可以写成
		/*
		 * int Bdel=(int)Math.pow(2, BdelPermi); int Badd=(int)Math.pow(2,
		 * BaddPermi); int Bupd=(int)Math.pow(2, BupdaetPermi);
		 */

		// System.out.println("删除b权限取次方后的结果:"+Bdel);
		// System.out.println("添加b权限取次方后的结果:"+Badd);
		/**
		 * 1000=8=Bdel &11100=28=用户的权限值 ------- 01000=8结果
		 * (1000=1000)8==8用户拥有删除b的权限
		 * 
		 */

		// System.out.println(Integer.toBinaryString(28));

		boolean permission;
		// 能过用户拥有的权限值 &（与） 功能模块的权限值的二进制 运算的结果和 ==功能模块的权限值 做比较判断
		// true 用权限 false 为无权限
		System.out.println("是否有删除b权限操作权限: " + ((purview & Bdel) == Bdel));
		System.out.println("是否有添加b权限操作权限: " + ((purview & Badd) == Badd));

		// 判断是否有多个权限
		permission = (purview & (Bdel)) == (purview & (Badd)) ? true : false;
		System.out.println("是否同时有添加b和 删除b 操作:" + permission);

		permission = (purview & (Bupd)) == (purview & (Badd)) ? true : false;
		System.out.println("是否同时有修改b和 删除b 操作:" + permission);
	}

	/**
	 * 更改用户的权限 modelID 这里应该到数据库去查询作为条件 这里省略，明白就好 这里主要是为了测试，实际应用时应该传入的都是相关对象数据
	 */
	private static int setPermission(int purview, int modelID, int newValue,
			boolean flag) {

		// 通移位得到操作权限码
		int temp = 1 << newValue;

		if (flag) {// 增加
			// 与当前权限进行或操作
			purview = purview | temp;

		} else {// 删除
				// 先取反 再和当前权限进行与操作
			temp = ~temp;
			purview = temp & purview;
		}

		// 返回当前用户拥用的结果根限
		return purview;
	}
}
