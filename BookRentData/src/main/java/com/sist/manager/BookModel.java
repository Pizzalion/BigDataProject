package com.sist.manager;

import java.net.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sist.book.*;

public class BookModel {
	private BookDAO dao=new BookDAO();
	public static void main(String[] args) {
		BookModel nm = new BookModel();
		
//		nm.dao.bookDrop();
		
		
		String[] groupStart = {"2017-01-01"};//,"2017-02-01","2017-03-01","2017-04-01","2017-05-01","2017-06-01"};
		String start= "2017-01-01";
		String[] groupEnd = {"2017-01-31"};//,"2017-02-28","2017-03-31","2017-04-30","2017-05-31","2017-06-30"};
		String end= "2017-01-31";
		int[] groupGender = {0,1};
		int[] groupAge = {6,8,14,20,30,40,50,60};
		int[] groupKdc = {0,1,2,3,4,5,6,7,8,9};
		int gender=0;
		int age=8; 
		int kdc=1;
		for( int i=0; i< groupStart.length;i++ ) {
			start = groupStart[i];
			end=groupEnd[i];
			for(int j=0;j<2;j++) {
				gender=groupGender[j];
				for(int k=0;k<groupAge.length;k++) {
					age=groupAge[k];
					for(int l=0;l<groupKdc.length;l++) {
						kdc=groupKdc[l];
						//num+=1;
						nm.bookData(start,end,gender,age,kdc);
					}
				}
			}
		}	
		System.out.println("insert end..");
			
	}
	
	public void bookData(String start,String end,int gender,int age,int kdc){
		List<Doc> list = new ArrayList<Doc>();
		try {
			String key = "f9a9c5d3f3df31dec7e11362dcfd5be83cfb63a1df229f783a4dee29878a260e";
			
			String strUrl = "http://data4library.kr/api/loanItemSrch?authKey="+key
					+ "&startDt="+start+"&endDt="+end+"&gender="+gender+"&age="+age+"&kdc="+kdc;
			
			System.out.println(strUrl);	
			//
			URL url = new URL(strUrl);
			JAXBContext jc=JAXBContext.newInstance(Response.class);//root class
			Unmarshaller un =jc.createUnmarshaller();// <-> object 클래스를 xml로
			Response rss = (Response)un.unmarshal(url);
			list=rss.getDocs().getDoc();//.getChannel().getItem();
			
			if(list.isEmpty()){
				System.out.println("no data");	
			}
			
			
			for(Doc i :list) {
				//System.out.println(i.getBookname());
				i.setStartDt(start);
				//System.out.println(i.getStartDt());
				i.setEndDt(end);
				i.setGender(gender);
				i.setAge(age);
				i.setCategory(kdc);
				
				dao.bookInsert(i);
				
				//System.out.println("inserting well..");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	

	
}