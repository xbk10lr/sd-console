package com.itcast.servlets;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		StuDB s=new StuDB();
//		List a=s.getAllStu(2, 10);
//		for (int i = 0; i < a.size(); i++) {
//			Stu ss=(Stu)a.get(i);
//			System.out.print(ss.getStuNum()+" ");
//			System.out.println(ss.getStuName());
//		}
		
//		boolean f=s.addStu(new Stu(1,101,"smith","femail",18,"123456"));
//		System.out.println(f);
		
//		boolean f=s.delStu(13);
//		System.out.println(f);
		
		boolean f=s.uptStu(11,new Stu(1,101,"lily","mail",19,"123456"));
		System.out.println(f);
	}
	
}
