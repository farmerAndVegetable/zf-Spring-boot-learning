package org.zf.commonService.hisWeb.imlp;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.zf.common.ConvertUtil;
import org.zf.commonService.constants.Constants;
import org.zf.commonService.hisWeb.QueryHisService;
import org.zf.commonService.model.Body;
import org.zf.commonService.model.Root;
import org.zf.commonService.model.WebServiceVoOut;
import org.zf.commonService.util.XmlUtil;




/**
 * Title：bmis
 * Class：com.bmis.webservice.service.impl
 * Comapny:杭州同烁软件信息技术有限公司
 *
 * @author：周陈伟
 * @version：2.5 CreateTime：2017/2/8 14:05
 * Modify log:
 * Description：
 */
@Service("queryHisService")
public class QueryHisServiceImpl <T extends Root> extends BaseImpl implements QueryHisService<T> {
	

    /**
     * webService 服务 向his系统取数据的通用接口
     * @param detailInputParam 入参
     * @param cls xml中的detail元素对应的bean
     * @param strTransId 交易代码
     * @return
     */
    @Override
    public WebServiceVoOut<T> qeuryListFromWebService(T inputParam, Class<T> cls, String strTransId,
                                                      String subElementStatus,List<String> subElementList) {
        WebServiceVoOut<T> result=new  WebServiceVoOut();
        T cl=null;
        try {
        	Document retDocument =(Document) returnXmlObject(inputParam,strTransId,subElementStatus,subElementList);
//        	cl=XmlUtil.toBean(retDocument.asXML(),cls);
        	
        	
            String xmlStr=xml();
        	cl=XmlUtil.toBean(xmlStr,cls);
        } catch (Exception e) {
           System.out.println("QueryHisServiceImpl===>method:" +
                    "qeuryListFromWebService Document Parse error! Model type is "
                    +cls.getClass().getSimpleName()+e);
        }
       if (cl.getBody()!=null){
    	   result.setBody(cl.getBody());
       }
        result.setHead(cl.getHead());

        return result;
    }
    
    

    /**
     *
     * @param obj 入参数据类型
     * @param strTransId  TransId	交易代码
     * @return
     */
    private  Object returnXmlObject(T obj,String strTransId,String subElementStatus,List<String> subElementList ){

        Document document = getHeadDocument(strTransId,null,null);
        if(Constants.XMLDOMSTATUS_ROOT.equals(subElementStatus)){
            getElement(document,obj);
        }else if (Constants.XMLDOMSTATUS_BODY.equals(subElementStatus)){
            getElement(document,obj,"body");
        }else if (Constants.XMLDOMSTATUS_SUBS.equals(subElementStatus)){
            getElement(document,obj,subElementList);
        }else{
            throw  new NullPointerException("method:returnXmlObject's inputparam (subElementStatus) must be " +
                    "one of the XMLDOMSTATUS_ROOT and XMLDOMSTATUS_BODY and XMLDOMSTATUS_BODY");

        }
        /*Holder<String> retXml = new Holder<String>();
        Holder<Integer> flag = new Holder<Integer>();
        service.getEtrackInterfaceSoap().etrackProcInterface(document.asXML(),retXml,flag);
        return retXml.value;
        System.out.println(document.asXML());*/
        return document;
    }
    private Document getHeadDocument(String strTransId,String mac,String name){
        Document document = (Document) DocumentHelper.createDocument();
        Element root =  document.addElement("root");
        Element head = root.addElement("head");
        Element transId = head.addElement("TransId");
        transId.addText(strTransId);
        Element sourceType = head.addElement("SourceType");
        sourceType.addText("1910");
        Element sourceIp = head.addElement("SourceIp");
        sourceIp.addText("");
        Element sourceMac = head.addElement("SourceMac");
        sourceMac.addText(ConvertUtil.null2String(mac));
        Element sourceName = head.addElement("SourceName");
        sourceName.addText(ConvertUtil.null2String(name));
        return document;
    }
    
    
    private String xml(){
   /* 	
   	 String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
             "<root>\n" +
             "\t<head>\n" +
             "\t\t<ErrCode>0</ErrCode>\n" +
             "     <ErrMsg>s_ok</ErrMsg>\n" +
             "\t</head>\n" +
             "      <body>\n" +
             "          <ZZKSID>303</ZZKSID>\n" +
             "        <ZZKSDM>1202</ZZKSDM>\n" +
             "        <ZZKSMC>zhang1</ZZKSMC>\n" +
             "        <HZSRM1>DNKBQ</HZSRM1>\n" +
             "        <HZSRM2>DMTUA</HZSRM2>\n" +
             "     </body> \n" +
             "\n" +
             "\t<body>\n" +
             "          <ZZKSID>303</ZZKSID>\n" +
             "        <ZZKSDM>1202</ZZKSDM>\n" +
             "        <ZZKSMC>zhang2</ZZKSMC>\n" +
             "        <HZSRM1>DNKBQ</HZSRM1>\n" +
             "        <HZSRM2>DMTUA</HZSRM2>\n" +
             "     </body> \n" +
             "\t  <body>\n" +
             "          <ZZKSID>303</ZZKSID>\n" +
             "        <ZZKSDM>1202</ZZKSDM>\n" +
             "        <ZZKSMC>zhang3</ZZKSMC>\n" +
             "        <HZSRM1>DNKBQ</HZSRM1>\n" +
             "        <HZSRM2>DMTUA</HZSRM2>\n" +
             "     </body> \n" +
             "\t \n"  +
             "</root>";*/
    	
   /*	 String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                 "<root>\n" +
                 "\t<head>\n" +
                 "\t\t<ErrCode>0</ErrCode>\n" +
                 "     <ErrMsg>s_ok</ErrMsg>\n" +
                 "\t</head>\n" +
                 "<body>\n" +
                 "      <Detail>\n" +
                 "          <ZZKSID>303</ZZKSID>\n" +
                 "        <ZZKSDM>1202</ZZKSDM>\n" +
                 "        <ZZKSMC>zhang1</ZZKSMC>\n" +
                 "        <HZSRM1>DNKBQ</HZSRM1>\n" +
                 "        <HZSRM2>DMTUA</HZSRM2>\n" +
                 "     </Detail> \n" +
                 "\n" +
                 "\t<Detail>\n" +
                 "          <ZZKSID>303</ZZKSID>\n" +
                 "        <ZZKSDM>1202</ZZKSDM>\n" +
                 "        <ZZKSMC>zhang2</ZZKSMC>\n" +
                 "        <HZSRM1>DNKBQ</HZSRM1>\n" +
                 "        <HZSRM2>DMTUA</HZSRM2>\n" +
                 "     </Detail> \n" +
                 "\t  <Detail>\n" +
                 "          <ZZKSID>303</ZZKSID>\n" +
                 "        <ZZKSDM>1202</ZZKSDM>\n" +
                 "        <ZZKSMC>zhang3</ZZKSMC>\n" +
                 "        <HZSRM1>DNKBQ</HZSRM1>\n" +
                 "        <HZSRM2>DMTUA</HZSRM2>\n" +
                 "     </Detail> \n" +
                 "\t \n" +
                 "</body>\n" +
                 "</root>";*/
    	
    	 String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                 "<root>\n" +
                 "\t<head>\n" +
                 "\t\t<ErrCode>0</ErrCode>\n" +
                 "     <ErrMsg>s_ok</ErrMsg>\n" +
                 "\t</head>\n" +
                 "<body>\n" +
                 "      <row>\n" +
                 "          <ZZKSID>303</ZZKSID>\n" +
                 "        <ZZKSDM>1202</ZZKSDM>\n" +
                 "        <ZZKSMC>zhang1</ZZKSMC>\n" +
                 "        <HZSRM1>DNKBQ</HZSRM1>\n" +
                 "        <HZSRM2>DMTUA</HZSRM2>\n" +
                 "     </row> \n" +
                 "\n" +
                 "\t<row>\n" +
                 "          <ZZKSID>303</ZZKSID>\n" +
                 "        <ZZKSDM>1202</ZZKSDM>\n" +
                 "        <ZZKSMC>zhang2</ZZKSMC>\n" +
                 "        <HZSRM1>DNKBQ</HZSRM1>\n" +
                 "        <HZSRM2>DMTUA</HZSRM2>\n" +
                 "     </row> \n" +
                 "\t  <row>\n" +
                 "          <ZZKSID>303</ZZKSID>\n" +
                 "        <ZZKSDM>1202</ZZKSDM>\n" +
                 "        <ZZKSMC>zhang3</ZZKSMC>\n" +
                 "        <HZSRM1>DNKBQ</HZSRM1>\n" +
                 "        <HZSRM2>DMTUA</HZSRM2>\n" +
                 "     </row> \n" +
                 "\t \n" +
                 "</body>\n" +
                 "</root>";
    	
		return xmlStr;
    }

}
