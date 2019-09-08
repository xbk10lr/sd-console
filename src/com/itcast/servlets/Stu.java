package com.itcast.servlets;

public class Stu {
	private int stuId;
	private int stuNum;
	private String stuName;
	private String stuSex;
	private int stuAge;
	private String stuQQ;
	public Stu(int stuId, int stuNum, String stuName, String stuSex,
			int stuAge, String stuQQ) {
		super();
		this.stuId = stuId;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuQQ = stuQQ;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuQQ() {
		return stuQQ;
	}
	public void setStuQQ(String stuQQ) {
		this.stuQQ = stuQQ;
	}
	public Stu() {
	}
}
