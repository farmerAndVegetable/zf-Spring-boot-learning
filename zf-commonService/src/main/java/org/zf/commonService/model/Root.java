package org.zf.commonService.model;


import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
@XStreamAlias("root")
public class Root<T> {
	
	@XStreamAlias("head")
	private Head head;
	
	@XStreamImplicit(itemFieldName="body")
	private List<T> body;
	
	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public List<T> getBody() {
		return body;
	}

	public void setBody(List<T> body) {
		this.body = body;
	}
	
	

}
