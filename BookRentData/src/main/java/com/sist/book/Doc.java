package com.sist.book;
import java.util.*;
import javax.xml.bind.annotation.XmlElement;
public class Doc {
	private int no;
	private String bookname,authors,publisher, publication_year;
	private double isbn13, class_no,loan_count; //#addtional_symbol,
	//private String bookImageURL;// not included in Doc
	
	//request value - 
	//#{start},#{end},#{gender},#{age},#{category}
//	Date start;
//	Date end;
	String startDt, endDt;
	int gender,age,category;
	String rentNo;
	
	public String getRentNo() {
		rentNo = no+startDt+gender+age+category+isbn13;
		return rentNo;
	}
	@XmlElement
	public void setRentNo(String rentNo) {
		this.rentNo = rentNo;
	}
	//	public Date getStart() {
//		return start;
//	}
//	public void setStart(Date start) {
//		this.start = start;
//	}
//	public Date getEnd() {
//		return end;
//	}
//	public void setEnd(Date end) {
//		this.end = end;
//	}
	public String getStartDt() {
		return startDt;
	}
	@XmlElement
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	
	public String getEndDt() {
		return endDt;
	}
	@XmlElement
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public int getGender() {
		return gender;
	}
	@XmlElement
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}
	public int getCategory() {
		return category;
	}
	@XmlElement
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	//
	public int getNo() {
		return no;
	}
	@XmlElement
	public void setNo(int no) {
		this.no = no;
	}
	public String getBookname() {
		return bookname;
	}
	@XmlElement
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthors() {
		return authors;
	}
	@XmlElement
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	@XmlElement
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublication_year() {
		return publication_year;
	}
	@XmlElement
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}
	public double getIsbn13() {
		return isbn13;
	}
	@XmlElement
	public void setIsbn13(double isbn13) {
		this.isbn13 = isbn13;
	}
	public double getClass_no() {
		return class_no;
	}
	@XmlElement
	public void setClass_no(double class_no) {
		this.class_no = class_no;
	}
	public double getLoan_count() {
		return loan_count;
	}
	@XmlElement
	public void setLoan_count(double loan_count) {
		this.loan_count = loan_count;
	}
//	public String getBookImageURL() {
//		return bookImageURL;
//	}
//	@XmlElement
//	public void setBookImageURL(String bookImageURL) {
//		this.bookImageURL = bookImageURL;
//	}
	
	
	
}
