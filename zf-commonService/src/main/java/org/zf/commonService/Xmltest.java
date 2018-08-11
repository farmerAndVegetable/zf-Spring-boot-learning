package org.zf.commonService;


import java.util.ArrayList;
import java.util.List;

import org.zf.commonService.hisWeb.imlp.QueryHisServiceImpl;
import org.zf.commonService.model.ApplyInfoBody;
import org.zf.commonService.model.ApplyInfoDetail;
import org.zf.commonService.model.ApplyInfoRow;
import org.zf.commonService.model.Body;
import org.zf.commonService.model.WebServiceVoOut;


/**
 * Created by Administrator on 2017/04/19.
 */
public class Xmltest {
    public static void main(String[] args) {
        //String xmlStr="<?xml version='1.0' encoding='UTF-8'?><root><head><ErrCode>0</ErrCode><ErrMsg>s_ok</ErrMsg></head><body><Detail><ZZKSID>303</ZZKSID><ZZKSDM>1202</ZZKSDM><ZZKSMC>大内科病区</ZZKSMC><HZSRM1>DNKBQ</HZSRM1><HZSRM2>DMTUA</HZSRM2></Detail><Detail><ZZKSID>303</ZZKSID><ZZKSDM>1202</ZZKSDM><ZZKSMC>大内科病区</ZZKSMC><HZSRM1>DNKBQ</HZSRM1><HZSRM2>DMTUA</HZSRM2></Detail></body></root>";
        
    	/*
    	ApplyInfo applyInfo=new ApplyInfo("input_one","inptu_two");
    	QueryHisServiceImpl his=new QueryHisServiceImpl<ApplyInfo>();
    	his.qeuryListFromWebService(applyInfo,ApplyInfo.class, "1234", "body", null);*/
    	
    	
    	/*List<ApplyInfoDetail>listinfo=new ArrayList<ApplyInfoDetail>();
    	ApplyInfoDetail applyInfo=new ApplyInfoDetail("input_one","inptu_two");
    	QueryHisServiceImpl his=new QueryHisServiceImpl<ApplyInfoDetail>();
    	WebServiceVoOut<ApplyInfoDetail> wsv=his.qeuryListFromWebService(applyInfo,ApplyInfoDetail.class, "1234", "body", null);
    	
    	Body<ApplyInfoDetail> body = (Body<ApplyInfoDetail>) wsv.getBody().get(0);
    	List<ApplyInfoDetail>info2List=body.getDetail();
    	for (ApplyInfoDetail applyInfoDetail : info2List) {
			System.out.println(applyInfoDetail.getHZSRM1());
		}*/
	 
    	
    	ApplyInfoRow applyInfo=new ApplyInfoRow("input_one","inptu_two");
    	QueryHisServiceImpl his=new QueryHisServiceImpl<ApplyInfoRow>();
    	WebServiceVoOut<ApplyInfoRow> wsv=his.qeuryListFromWebService(applyInfo,ApplyInfoRow.class, "1234", "body", null);
    	Body<ApplyInfoRow> body = (Body<ApplyInfoRow>) wsv.getBody().get(0);
    	List<ApplyInfoRow>info2List=body.getRow();
    	for (ApplyInfoRow applyInfoDetail : info2List) {
			System.out.println(applyInfoDetail.getHZSRM1());
		}
    }
}
