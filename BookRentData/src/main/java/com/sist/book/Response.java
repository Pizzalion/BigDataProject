package com.sist.book;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//최상위 태그 명명
@XmlRootElement
public class Response {
	private Docs docs = new Docs();

	public Docs getDocs() {
		return docs;
	}
	@XmlElement
	public void setDocs(Docs docs) {
		this.docs = docs;
	}
}


