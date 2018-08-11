package org.zf.commonService.hisWeb.imlp;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.dom4j.Document;
import org.dom4j.Element;
import org.zf.common.ConvertUtil;
import org.zf.commonService.annotation.Alias;

/**
 * Title：bmis
 * Class：com.bmis.webservice.service.impl
 * Comapny:杭州同烁信息技术有限公司
 *
 * @author：周陈伟
 * @version：2.5 CreateTime：2017/4/19 14:36
 * Modify log:
 * Description：
 */
public class BaseImpl {
    @Resource(name = "org.apache.cxf.jaxws.context.WebServiceContextImpl")
    private WebServiceContext context;

    /**
     * 创建XML仅有root元素
     */
    protected void getElement(Document document, Object object){
        getElement(document, object,"");
    }
    /**
     * 创建XML在root元素内添加了一个body子元素
     */
    protected void getElement(Document document, Object object,String body){
        if (!body.isEmpty()) {
            List<String> bodyList = new ArrayList<String>();
            bodyList.add(body);
            getElement(document, object, bodyList);
        }else{
            throw  new NullPointerException("addElement's inputparam can't be null or ‘ ’");
        }

    }
    /**
     * 创建XML，循环添加子元素
     */
    protected void getElement(Document document, Object object,List<String> subElements){
        Element maxInnerElement=document.getRootElement();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            if(!subElements.isEmpty()){
                for (String subElement:subElements) {
                    maxInnerElement=maxInnerElement.addElement(subElement);
                }
            }
            for (Field field : fields) {
                String propertyName = field.getName();
                boolean isAccess = field.isAccessible();
                Alias alias = (Alias) field.getAnnotation(Alias.class);
                field.setAccessible(true);
                String value = ConvertUtil.null2String(field.get(object));
                if(alias!=null){
                    propertyName = alias.name();
                    Element element = maxInnerElement.addElement(propertyName);
                    element.addText(value);
                }
                field.setAccessible(isAccess);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
