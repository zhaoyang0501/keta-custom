/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ketayao.ketacustom.entity.Idable;

@Entity
@Table(name="tzzj_pub_opinion")
public class PubOpinion implements Idable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 问题内容
	 */
    @Column(nullable=false, length=4000)
    private String conts;
    
	/**
	 * 创建时间
	 */
    @Column(nullable=false, length=7)
	@Temporal(TemporalType.DATE)
    private Date createTime;
    
	/**
	 * 创建用户id
	 */
    @Column(nullable=false, length=32)
    private String createUserid;
    
	/**
	 * 待受理403 已受理405 回退407   结束409
	 */
    @Column(nullable=false, length=32)
    private String status;
    
	/**
	 * 上传附件id
	 */
    @Column(length=100)
    private String aId;
    
	/**
	 * 回退内容
	 */
    @Column(length=4000)
    private String replyConts;
    
	/**
	 * 回复工作人员id
	 */
    @Column(length=32)
    private String replyUserid;
    
	/**
	 * 回复时间
	 */
    @Column(length=7)
	@Temporal(TemporalType.DATE)
    private Date replyTime;
    
	/**
	 * 舆情标题
	 */
    @Column(length=200)
    private String title;
    
	/**
	 * 案件大类id
	 */
    @Column(length=10,name="PARAM_TYPE_B")
    private String paramTypeB;
    
	/**
	 * 案件小类id
	 */
    @Column(length=10,name="PARAM_TYPE_S")
    private String paramTypeS;
    
	/**
	 * 所属中队id
	 */
    @Column(length=10)
    private String paramOrgId;
    
	/**
	 * 事件路段
	 */
    @Column(length=200)
    private String address;
    
	/**
	 * 位置gps
	 */
    @Column(length=200)
    private String lnglat;
    
	/**
	 * 问题来源id
	 */
    @Column(length=10)
    private String paramBacseid;
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param conts the conts to set
	 */
    public void setConts(String conts){
       this.conts = conts;
    }
    
    /**
     * @return the conts 
     */
    public String getConts(){
       return this.conts;
    }
	
	/**
	 * @param createTime the createTime to set
	 */
    public void setCreateTime(Date createTime){
       this.createTime = createTime;
    }
    
    /**
     * @return the createTime 
     */
    public Date getCreateTime(){
       return this.createTime;
    }
	
	/**
	 * @param createUserid the createUserid to set
	 */
    public void setCreateUserid(String createUserid){
       this.createUserid = createUserid;
    }
    
    /**
     * @return the createUserid 
     */
    public String getCreateUserid(){
       return this.createUserid;
    }
	
	/**
	 * @param status the status to set
	 */
    public void setStatus(String status){
       this.status = status;
    }
    
    /**
     * @return the status 
     */
    public String getStatus(){
       return this.status;
    }
	
	/**
	 * @param aId the aId to set
	 */
    public void setAId(String aId){
       this.aId = aId;
    }
    
    /**
     * @return the aId 
     */
    public String getAId(){
       return this.aId;
    }
	
	/**
	 * @param replyConts the replyConts to set
	 */
    public void setReplyConts(String replyConts){
       this.replyConts = replyConts;
    }
    
    /**
     * @return the replyConts 
     */
    public String getReplyConts(){
       return this.replyConts;
    }
	
	/**
	 * @param replyUserid the replyUserid to set
	 */
    public void setReplyUserid(String replyUserid){
       this.replyUserid = replyUserid;
    }
    
    /**
     * @return the replyUserid 
     */
    public String getReplyUserid(){
       return this.replyUserid;
    }
	
	/**
	 * @param replyTime the replyTime to set
	 */
    public void setReplyTime(Date replyTime){
       this.replyTime = replyTime;
    }
    
    /**
     * @return the replyTime 
     */
    public Date getReplyTime(){
       return this.replyTime;
    }
	
	/**
	 * @param title the title to set
	 */
    public void setTitle(String title){
       this.title = title;
    }
    
    /**
     * @return the title 
     */
    public String getTitle(){
       return this.title;
    }
	
	/**
	 * @param paramTypeB the paramTypeB to set
	 */
    public void setParamTypeB(String paramTypeB){
       this.paramTypeB = paramTypeB;
    }
    
    /**
     * @return the paramTypeB 
     */
    public String getParamTypeB(){
       return this.paramTypeB;
    }
	
	/**
	 * @param paramTypeS the paramTypeS to set
	 */
    public void setParamTypeS(String paramTypeS){
       this.paramTypeS = paramTypeS;
    }
    
    /**
     * @return the paramTypeS 
     */
    public String getParamTypeS(){
       return this.paramTypeS;
    }
	
	/**
	 * @param paramOrgId the paramOrgId to set
	 */
    public void setParamOrgId(String paramOrgId){
       this.paramOrgId = paramOrgId;
    }
    
    /**
     * @return the paramOrgId 
     */
    public String getParamOrgId(){
       return this.paramOrgId;
    }
	
	/**
	 * @param address the address to set
	 */
    public void setAddress(String address){
       this.address = address;
    }
    
    /**
     * @return the address 
     */
    public String getAddress(){
       return this.address;
    }
	
	/**
	 * @param lnglat the lnglat to set
	 */
    public void setLnglat(String lnglat){
       this.lnglat = lnglat;
    }
    
    /**
     * @return the lnglat 
     */
    public String getLnglat(){
       return this.lnglat;
    }
	
	/**
	 * @param paramBacseid the paramBacseid to set
	 */
    public void setParamBacseid(String paramBacseid){
       this.paramBacseid = paramBacseid;
    }
    
    /**
     * @return the paramBacseid 
     */
    public String getParamBacseid(){
       return this.paramBacseid;
    }
}
