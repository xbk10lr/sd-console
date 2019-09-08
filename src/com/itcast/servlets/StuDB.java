package com.itcast.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StuDB {
	public Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://45.40.198.219:3306/test","uppdb","uppdb");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public  void closeRes(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void closeRes(Statement stmt,Connection conn){
		try {
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List getAllStu(int pg,int pgSize){
		List a=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			stmt=conn.createStatement();
			String sql="select * from stu limit " +(pg-1)*pgSize + "," +pgSize+";";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int stuId=rs.getInt(1);
				int stuNum=rs.getInt(2);
				String stuName=rs.getString(3);
				String stuSex=rs.getString(4);
				int stuAge=rs.getInt(5);
				String stuQQ=rs.getString(6);
				Stu ss=new Stu(stuId,stuNum,stuName,stuSex,stuAge,stuQQ);
				a.add(ss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeRes(rs, stmt, conn);
		}
		return a;
	}
	
	public boolean delStu(int id){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			stmt=conn.createStatement();
			String sql="delete from stu where stuId="+id+"";
			System.out.println(sql);
			int num=stmt.executeUpdate(sql);
			if(num>0){
				flag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeRes( stmt, conn);
		}
		return flag;
	}
	public boolean uptStu(int id,Stu s){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			stmt=conn.createStatement();
			String sql="update stu  set stuNum="+s.getStuNum()+",stuName='"+s.getStuName()+"',stuSex='"+s.getStuSex()+"',stuAge="+s.getStuAge()+",stuQQ='"+s.getStuQQ()+"' where stuId="+id+"";
			System.out.println(sql);
			int num=stmt.executeUpdate(sql);
			if(num>0){
				flag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeRes( stmt, conn);
		}
		return flag;
	}
	
	public boolean addStu(Stu s){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			stmt=conn.createStatement();
			String sql="insert into stu values(null,"+s.getStuNum()+",'"+s.getStuName()+"','"+s.getStuSex()+"',"+s.getStuAge()+",'"+s.getStuQQ()+"');";
			System.out.println(sql);
			int num=stmt.executeUpdate(sql);
			if(num>0){
				flag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeRes( stmt, conn);
		}
		return flag;
	}
	
	public int getNum(){
		int num=0;
		List a=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			stmt=conn.createStatement();
			String sql="select count(*) from stu";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				num=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeRes(rs, stmt, conn);
		}		
		return num;
	}

	
}
