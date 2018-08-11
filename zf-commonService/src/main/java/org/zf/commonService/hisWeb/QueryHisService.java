package org.zf.commonService.hisWeb;



import java.util.List;

import org.zf.commonService.model.WebServiceVoOut;

/**
 * Title：bmis
 * Class：com.bmis.webservice.service
 * Comapny:杭州同烁软件信息技术有限公司
 *
 * @author：周陈伟
 * @version：2.5 CreateTime：2017/2/8 14:09
 * Modify log:
 * Description：
 */
public interface QueryHisService <T>  {

    /**
     * webService 服务 向his系统取数据的通用接口
     * @param inputParam
     * @param cls
     * @param strTransId
     * @return
     */
    WebServiceVoOut<T> qeuryListFromWebService(T inputParam, Class<T> cls, String strTransId,
                                               String inputElemSta,List<String> inputElementList);

   
}
