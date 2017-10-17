package com.sist.book;

import java.net.InetSocketAddress;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


import java.util.*;

//mongoDB

public class BookDAO {
	private MongoClient mc; //connection
	private DB db; 			  //ORCL
	private DBCollection dbc;//table
	
	public BookDAO(){
		try {
			mc = new MongoClient(new ServerAddress(new InetSocketAddress("211.238.142.23", 27017)));
//			port 변경가능 : sudo nano mongodb.conf
//			mc = new MongoClient(localhost, 1521 - oracle);
			db=mc.getDB("mydb"); //database
			dbc=db.getCollection("bookRent"); //create table movie
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void bookDrop(){
		dbc.drop();
	}
	
	public void bookInsert(Doc vo){
		try {
//			mongoDB -> json type : insert({no:1,...}) 의 {}을 만들어준다.
			BasicDBObject obj= new BasicDBObject();
//			put {key, value} 입력순서 = 컬럼순서
			/*
			 #{rentNo},#{no},#{bookname},#{isbn13},#{class_no},#{loan_count},
#{startDt},#{endDt},#{gender},#{age},#{category})
			 */
			
			
			obj.put("no", vo.getNo());
			
			obj.put("startDt", vo.getStartDt());
			obj.put("gender", vo.getGender());
			obj.put("age", vo.getAge());
			obj.put("category", vo.getCategory());
			obj.put("isbn13", vo.getIsbn13());
			obj.put("bookname", vo.getBookname());
			obj.put("rentNo", vo.getRentNo());
			obj.put("loan_count", vo.getLoan_count());
			
			dbc.insert(obj);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	/*
	public List<Doc> movieAllData(){
		List<Doc> list = new ArrayList<Doc>();
		try {
			//select * from movie orderby mno asc;
			//-1 : desc , 1: asc
			DBCursor cursor = dbc.find().sort(new BasicDBObject("mno",1));
			while(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject)cursor.next();
				Doc vo = new Doc();
				vo.setMno(obj.getInt("mno"));
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	*/
}
