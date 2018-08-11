package org.zf.commonService.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2017/04/19.
 */
@XStreamAlias("Detail")
public class WardInfoVoHis  {

    /**
     * 组织科室序号（入参）
     */
    @XStreamAlias("ZZKSID")
    private String zzksId;
    /**
     * 组织机构代码（入参）
     */
    @XStreamAlias("ZZKSDM")
    private String zzjgdm;

    /**
     * 组织科室名称
     */
    @XStreamAlias("ZZKSMC")
    private String zzksmc;
    /**
     * 是否作废判别
     */
    private String sszfpb;
    /**
     * 拼音码
     */
    @XStreamAlias("HZSRM1")
    private String hzsrm1;
    /**
     * 五笔码
     */
    @XStreamAlias("HZSRM2")
    private String hzsrm2;
    /**
     * 自定义码
     */
    private String 	Hzsrm3;

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getZzksId() {
        return zzksId;
    }

    public void setZzksId(String zzksId) {
        this.zzksId = zzksId;
    }

    public String getZzksmc() {
        return zzksmc;
    }

    public void setZzksmc(String zzksmc) {
        this.zzksmc = zzksmc;
    }

    public String getSszfpb() {
        return sszfpb;
    }

    public void setSszfpb(String sszfpb) {
        this.sszfpb = sszfpb;
    }

    public String getHzsrm1() {
        return hzsrm1;
    }

    public void setHzsrm1(String hzsrm1) {
        this.hzsrm1 = hzsrm1;
    }

    public String getHzsrm2() {
        return hzsrm2;
    }

    public void setHzsrm2(String hzsrm2) {
        this.hzsrm2 = hzsrm2;
    }

    public String getHzsrm3() {
        return Hzsrm3;
    }

    public void setHzsrm3(String hzsrm3) {
        Hzsrm3 = hzsrm3;
    }
}
