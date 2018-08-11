package org.zf.commonService.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Created by Administrator on 2017/04/19.
 */
@XStreamAlias("body")
public class  Body<T> extends Root<T>   {
	
	@XStreamImplicit(itemFieldName="Detail")
	private List<T> detail;
	

	@XStreamImplicit(itemFieldName="row")
	private List<T> row;
	
	
	public List<T> getDetail() {
		return detail;
	}

	public void setDetail(List<T> detail) {
		this.detail = detail;
	}
	public void setDetail(T detailSingle) {
		List<T> list=new ArrayList<T>();
		list.add(detailSingle);
		this.detail = list;
	}

	public List<T> getRow() {
		return row;
	}

	public void setRow(List<T> row) {
		this.row = row;
	}
	
	
	
	
	
}
