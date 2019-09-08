package com.itcast.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StuAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String flag=request.getParameter("flag");
		StuDB tt=new StuDB();
		
		if(flag.equals("getAllStu")){
			String pg=request.getParameter("page");
			String pgSize=request.getParameter("rows");
			if(null==pg||"".equals(pg)){
				pg="1";
			}
			if(null==pgSize||"".equals(pgSize)){
				pgSize="10";
			}
			List a=tt.getAllStu(Integer.parseInt(pg), Integer.parseInt(pgSize));
			int num=tt.getNum();
			Map m=new HashMap();
			m.put("total", num);
			m.put("rows", a);
			JSONArray js=JSONArray.fromObject(m);
			System.out.println(js);
			String j=js.toString();
			String jz=j.substring(1, j.length()-1);
			System.out.println(jz);
			out.println(jz);
		}
		if(flag.equals("addStu")){
			String id=request.getParameter("stuId");
			String num=request.getParameter("stuNum");
			String name=request.getParameter("stuName");
			String sex=request.getParameter("stuSex");
			String age=request.getParameter("stuAge");
			String qq=request.getParameter("stuQQ");
			Stu s=new Stu(1,Integer.parseInt(num),name,sex,Integer.parseInt(age),qq);
			boolean f=tt.addStu(s);
			Map m=new HashMap();
			if(f){
				m.put("result","true");
			}else{
				m.put("msg","save error");
			}
			JSONObject js=JSONObject.fromObject(m);
			System.out.println(js);
			out.println(js);
		}
		if(flag.equals("delStu")){
			String id=request.getParameter("id");
			boolean f=tt.delStu(Integer.parseInt(id));
			Map m=new HashMap();
			if(f){
				m.put("result","true");
			}else{
				m.put("msg","del Error");
			}
			JSONObject js=JSONObject.fromObject(m);
			System.out.println(js);
			out.println(js);
		}
		if(flag.equals("uptStu")){
			String id=request.getParameter("id");
			String num=request.getParameter("stuNum");
			String name=request.getParameter("stuName");
			String sex=request.getParameter("stuSex");
			String age=request.getParameter("stuAge");
			String qq=request.getParameter("stuQQ");
			Stu s=new Stu(Integer.parseInt(id),Integer.parseInt(num),name,sex,Integer.parseInt(age),qq);
			boolean f=tt.uptStu(Integer.parseInt(id), s);
			Map m=new HashMap();
			if(f){
				m.put("result","true");
			}else{
				m.put("result","false");
			}
			JSONObject js=JSONObject.fromObject(m);
			System.out.println(js);
			out.println(js);
		}
		out.flush();
		out.close();
	}
	
}
