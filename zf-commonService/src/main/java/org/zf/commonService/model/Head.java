package org.zf.commonService.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("head")
public class Head  {
	 /**
     * 错误码
     */
    @XStreamAlias("ErrCode")
    private String errCode;
    /**
     * 错误信息
     */
    @XStreamAlias("ErrMsg")
    private String errMsg;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
    
    

}
