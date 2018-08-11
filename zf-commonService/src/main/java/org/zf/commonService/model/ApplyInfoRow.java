package org.zf.commonService.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

import org.zf.commonService.annotation.Alias;

import net.sf.json.JSONObject;

/**
 * Title：bmis
 * Class：com.bmis.webservice.model.shulan.his
 * Comapny:杭州同烁信息技术有限公司
 *
 * @author：周陈伟
 * @version：2.5 CreateTime：2017/4/19 13:16
 * Modify log:
 * Description：
 * 用血申请信息
 */
@XStreamAlias("row")
public class ApplyInfoRow extends Body implements Serializable {
	
    private static final long serialVersionUID = 4288972819161783339L;

    @Alias(name = "ZZKSID")
    @XStreamAlias("ZZKSID")
    private String ZZKSID;
    
    @Alias(name = "ZZKSDM")
    @XStreamAlias("ZZKSDM")
    private String ZZKSDM;

	@XStreamAlias("ZZKSMC")
    private String ZZKSMC;
    
    @XStreamAlias("HZSRM2")
    private String HZSRM2;
    
    
    @XStreamAlias("HZSRM1")
    private String HZSRM1;
    
   
	
	

	public ApplyInfoRow(String zZKSID, String zZKSDM) {
		super();
		ZZKSID = zZKSID;
		ZZKSDM = zZKSDM;
	}


	public String getZZKSID() {
		return ZZKSID;
	}


	public void setZZKSID(String zZKSID) {
		ZZKSID = zZKSID;
	}


	public String getZZKSDM() {
		return ZZKSDM;
	}


	public void setZZKSDM(String zZKSDM) {
		ZZKSDM = zZKSDM;
	}


	public String getZZKSMC() {
		return ZZKSMC;
	}


	public void setZZKSMC(String zZKSMC) {
		ZZKSMC = zZKSMC;
	}


	public String getHZSRM2() {
		return HZSRM2;
	}


	public void setHZSRM2(String hZSRM2) {
		HZSRM2 = hZSRM2;
	}


	public String getHZSRM1() {
		return HZSRM1;
	}


	public void setHZSRM1(String hZSRM1) {
		HZSRM1 = hZSRM1;
	}


	public ApplyInfoRow() {
		super();
	}


	public static void main(String[] args) {
    	ApplyInfoRow applayInfo=new ApplyInfoRow();
    	JSONObject json = JSONObject.fromObject(applayInfo);
    	System.out.println(json);
    	
    }
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
}
