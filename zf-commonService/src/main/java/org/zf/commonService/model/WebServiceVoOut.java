package org.zf.commonService.model;
import java.util.List;

/**
 * Created by Administrator on 2017/04/20.
 */
public class WebServiceVoOut<T> {
    private Head head;

    private List<T> detail;

    private List<Object> body;
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<T> getDetail() {
        return detail;
    }

    public void setDetail(List<T> detail) {
        this.detail = detail;
    }

	public List<Object> getBody() {
		return body;
	}

	public void setBody(List<Object> body) {
		this.body = body;
	}

  
}
