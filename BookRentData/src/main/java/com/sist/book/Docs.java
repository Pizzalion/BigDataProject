package com.sist.book;

import java.util.*;
import javax.xml.bind.annotation.XmlElement;

public class Docs {
	private List<Doc> doc = new ArrayList<Doc>();

	public List<Doc> getDoc() {
		return doc;
	}
	@XmlElement
	public void setDoc(List<Doc> doc) {
		this.doc = doc;
	}
	
}
