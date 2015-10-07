/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ketayao.ketacustom.entity.Idable;

@Entity
@Table(name="tzzj_main_opinion")
public class Opinion implements Idable<String>{
    
	/**
	 * id*****
	 */
	@Id
    @Column(nullable=false, length=32)
    private String id;
    
	/**
	 * 问题来源
	 */
    @Column(length=32)
    private String problemSource;
    
	/**
	 * 姓名
	 */
    @Column(length=32)
    private String name;
    
	/**
	 * 地址
	 */
    @Column(length=200)
    private String address;
    
	/**
	 * 手机
	 */
    @Column(length=32)
    private String phone;
    
	/**
	 * 状态更新时间*****
	 */
    @Column(length=7)
	@Temporal(TemporalType.TIMESTAMP)
    private Date reportTime;
    
	/**
	 * 要求反馈时间（必填）*****
	 */
    @Column(length=7)
	@Temporal(TemporalType.TIMESTAMP)
    private Date feedbackTime;
    
	/**
	 * 受理时间（系统时间）*****
	 */
    @Column(length=7)
	@Temporal(TemporalType.TIMESTAMP)
    private Date acceptTime;
    
	/**
	 * E-MAIL
	 */
    @Column(length=32)
    private String email;
    
	/**
	 * 范围（必填）
	 */
    @Column(length=32)
    private String scope;
    
	/**
	 * 行业类型ID（必填）下拉列表选择*****
	 */
    @Column(length=32)
    private String guildTypeId;
    
	/**
	 * 业务单位ID（必填）下拉列表选择*****
	 */
    @Column(length=32)
    private String guildUnitId;
    
	/**
	 * 反应内容（必填）
	 */
    @Column(length=4000)
    private String reportConts;
    
	/**
	 * 备注
	 */
    @Column(length=2000)
    private String rmks;
    
	/**
	 * 受理员（必填）*****
	 */
    @Column(length=32)
    private String acceptUserid;
    
	/**
	 * 处理时限=受理时间-要求反馈时间(小时)(暂未使用)*****
	 */
    @Column(length=22)
    private Long handleTime;
    
	/**
	 * 单位处理反馈人id***
	 */
    @Column(length=100)
    private String unitUserid;
    
	/**
	 * 值班长立案id*******
	 */
    @Column(length=32)
    private String doingUserid;
    
	/**
	 * 是否重新派单（1：是，0不是）****
	 */
    @Column(length=32)
    private String essayFirst;
    
	/**
	 * 舆情级别(一级到四级)下拉列表选择*****
	 */
    @Column(length=32)
    private String opinionRank;
    
	/**
	 * 当前状态(已派单:1； 已驳回:2；正常受理:3；超时受理:4；无效：0)*****
	 */
    @Column(length=32)
    private String opinionStatus;
    
	/**
	 * 111
	 */
    @Column(length=7)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
	/**
	 * 公众客户端舆情id、问题id*****
	 */
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PUB_OPINION_ID",referencedColumnName="id", unique = true)
    private PubOpinion pubopinion;
    
	/**
	 * 核查附件id
	 */
    @Column(length=1000)
    private String checkAId;
    
	/**
	 * 核查备注****
	 */
    @Column(length=100)
    private String checkRmk;
    
	/**
	 * 核查结果****
	 */
    @Column(length=1000)
    private String checkResult;
    
	/**
	 * 核查人员id*****
	 */
    @Column(length=32)
    private String checkUserid;
    
	/**
	 * 单位处理附件id***
	 */
    @Column(length=1)
    private String handleAId;
    
	/**
	 * 单位处理结果*****
	 */
    @Column(length=2000)
    private String handleResult;
    
	/**
	 * @param id the id to set
	 */
    public void setId(String id){
       this.id = id;
    }
    
    /**
     * @return the id 
     */
    public String getId(){
       return this.id;
    }
	
	/**
	 * @param problemSource the problemSource to set
	 */
    public void setProblemSource(String problemSource){
       this.problemSource = problemSource;
    }
    
    /**
     * @return the problemSource 
     */
    public String getProblemSource(){
       return this.problemSource;
    }
	
	/**
	 * @param name the name to set
	 */
    public void setName(String name){
       this.name = name;
    }
    
    /**
     * @return the name 
     */
    public String getName(){
       return this.name;
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
	 * @param phone the phone to set
	 */
    public void setPhone(String phone){
       this.phone = phone;
    }
    
    /**
     * @return the phone 
     */
    public String getPhone(){
       return this.phone;
    }
	
	/**
	 * @param reportTime the reportTime to set
	 */
    public void setReportTime(Date reportTime){
       this.reportTime = reportTime;
    }
    
    /**
     * @return the reportTime 
     */
    public Date getReportTime(){
       return this.reportTime;
    }
	
	/**
	 * @param feedbackTime the feedbackTime to set
	 */
    public void setFeedbackTime(Date feedbackTime){
       this.feedbackTime = feedbackTime;
    }
    
    /**
     * @return the feedbackTime 
     */
    public Date getFeedbackTime(){
       return this.feedbackTime;
    }
	
	/**
	 * @param acceptTime the acceptTime to set
	 */
    public void setAcceptTime(Date acceptTime){
       this.acceptTime = acceptTime;
    }
    
    /**
     * @return the acceptTime 
     */
    public Date getAcceptTime(){
       return this.acceptTime;
    }
	
	/**
	 * @param email the email to set
	 */
    public void setEmail(String email){
       this.email = email;
    }
    
    /**
     * @return the email 
     */
    public String getEmail(){
       return this.email;
    }
	
	/**
	 * @param scope the scope to set
	 */
    public void setScope(String scope){
       this.scope = scope;
    }
    
    /**
     * @return the scope 
     */
    public String getScope(){
       return this.scope;
    }
	
	/**
	 * @param guildTypeId the guildTypeId to set
	 */
    public void setGuildTypeId(String guildTypeId){
       this.guildTypeId = guildTypeId;
    }
    
    /**
     * @return the guildTypeId 
     */
    public String getGuildTypeId(){
       return this.guildTypeId;
    }
	
	/**
	 * @param guildUnitId the guildUnitId to set
	 */
    public void setGuildUnitId(String guildUnitId){
       this.guildUnitId = guildUnitId;
    }
    
    /**
     * @return the guildUnitId 
     */
    public String getGuildUnitId(){
       return this.guildUnitId;
    }
	
	/**
	 * @param reportConts the reportConts to set
	 */
    public void setReportConts(String reportConts){
       this.reportConts = reportConts;
    }
    
    /**
     * @return the reportConts 
     */
    public String getReportConts(){
       return this.reportConts;
    }
	
	/**
	 * @param rmks the rmks to set
	 */
    public void setRmks(String rmks){
       this.rmks = rmks;
    }
    
    /**
     * @return the rmks 
     */
    public String getRmks(){
       return this.rmks;
    }
	
	/**
	 * @param acceptUserid the acceptUserid to set
	 */
    public void setAcceptUserid(String acceptUserid){
       this.acceptUserid = acceptUserid;
    }
    
    /**
     * @return the acceptUserid 
     */
    public String getAcceptUserid(){
       return this.acceptUserid;
    }
	
	/**
	 * @param handleTime the handleTime to set
	 */
    public void setHandleTime(Long handleTime){
       this.handleTime = handleTime;
    }
    
    /**
     * @return the handleTime 
     */
    public Long getHandleTime(){
       return this.handleTime;
    }
	
	/**
	 * @param unitUserid the unitUserid to set
	 */
    public void setUnitUserid(String unitUserid){
       this.unitUserid = unitUserid;
    }
    
    /**
     * @return the unitUserid 
     */
    public String getUnitUserid(){
       return this.unitUserid;
    }
	
	/**
	 * @param doingUserid the doingUserid to set
	 */
    public void setDoingUserid(String doingUserid){
       this.doingUserid = doingUserid;
    }
    
    /**
     * @return the doingUserid 
     */
    public String getDoingUserid(){
       return this.doingUserid;
    }
	
	/**
	 * @param essayFirst the essayFirst to set
	 */
    public void setEssayFirst(String essayFirst){
       this.essayFirst = essayFirst;
    }
    
    /**
     * @return the essayFirst 
     */
    public String getEssayFirst(){
       return this.essayFirst;
    }
	
	/**
	 * @param opinionRank the opinionRank to set
	 */
    public void setOpinionRank(String opinionRank){
       this.opinionRank = opinionRank;
    }
    
    /**
     * @return the opinionRank 
     */
    public String getOpinionRank(){
       return this.opinionRank;
    }
	
	/**
	 * @param opinionStatus the opinionStatus to set
	 */
    public void setOpinionStatus(String opinionStatus){
       this.opinionStatus = opinionStatus;
    }
    
    /**
     * @return the opinionStatus 
     */
    public String getOpinionStatus(){
       return this.opinionStatus;
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
	
	
	
	public PubOpinion getPubopinion() {
		return pubopinion;
	}

	public void setPubopinion(PubOpinion pubopinion) {
		this.pubopinion = pubopinion;
	}

	/**
	 * @param checkAId the checkAId to set
	 */
    public void setCheckAId(String checkAId){
       this.checkAId = checkAId;
    }
    
    /**
     * @return the checkAId 
     */
    public String getCheckAId(){
       return this.checkAId;
    }
	
	/**
	 * @param checkRmk the checkRmk to set
	 */
    public void setCheckRmk(String checkRmk){
       this.checkRmk = checkRmk;
    }
    
    /**
     * @return the checkRmk 
     */
    public String getCheckRmk(){
       return this.checkRmk;
    }
	
	/**
	 * @param checkResult the checkResult to set
	 */
    public void setCheckResult(String checkResult){
       this.checkResult = checkResult;
    }
    
    /**
     * @return the checkResult 
     */
    public String getCheckResult(){
       return this.checkResult;
    }
	
	/**
	 * @param checkUserid the checkUserid to set
	 */
    public void setCheckUserid(String checkUserid){
       this.checkUserid = checkUserid;
    }
    
    /**
     * @return the checkUserid 
     */
    public String getCheckUserid(){
       return this.checkUserid;
    }
	
	/**
	 * @param handleAId the handleAId to set
	 */
    public void setHandleAId(String handleAId){
       this.handleAId = handleAId;
    }
    
    /**
     * @return the handleAId 
     */
    public String getHandleAId(){
       return this.handleAId;
    }
	
	/**
	 * @param handleResult the handleResult to set
	 */
    public void setHandleResult(String handleResult){
       this.handleResult = handleResult;
    }
    
    /**
     * @return the handleResult 
     */
    public String getHandleResult(){
       return this.handleResult;
    }
}
