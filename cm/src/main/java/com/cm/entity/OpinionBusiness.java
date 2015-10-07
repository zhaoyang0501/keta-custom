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
@Table(name="tzzj_opinion_business")
public class OpinionBusiness implements Idable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 案件表id
	 */
    @Column(length=32)
    private String mainOpinionId;
    
	/**
	 * 操作用户
	 */
    @Column(length=32)
    private String actionUserid;
    
	/**
	 * 动作
	 */
    @Column(length=65535)
    private String actionName;
    
	/**
	 * 备注内容
	 */
    @Column(length=65535)
    private String actionConts;
    
	/**
	 * 操作时间
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
	/**
	 * 附件id
	 */
    @Column(length=65535)
    private String aId;
    
	/**
	 * 是否超时
	 */
    @Column(length=32)
    private String r2;
    
	/**
	 * 是否有效
	 */
    @Column(length=1)
    private String isValid;
    
	/**
	 * @param id the id to set
	 */
    public void setId(Long id){
       this.id = id;
    }
    
    /**
     * @return the id 
     */
    public Long getId(){
       return this.id;
    }
	
	/**
	 * @param mainOpinionId the mainOpinionId to set
	 */
    public void setMainOpinionId(String mainOpinionId){
       this.mainOpinionId = mainOpinionId;
    }
    
    /**
     * @return the mainOpinionId 
     */
    public String getMainOpinionId(){
       return this.mainOpinionId;
    }
	
	/**
	 * @param actionUserid the actionUserid to set
	 */
    public void setActionUserid(String actionUserid){
       this.actionUserid = actionUserid;
    }
    
    /**
     * @return the actionUserid 
     */
    public String getActionUserid(){
       return this.actionUserid;
    }
	
	/**
	 * @param actionName the actionName to set
	 */
    public void setActionName(String actionName){
       this.actionName = actionName;
    }
    
    /**
     * @return the actionName 
     */
    public String getActionName(){
       return this.actionName;
    }
	
	/**
	 * @param actionConts the actionConts to set
	 */
    public void setActionConts(String actionConts){
       this.actionConts = actionConts;
    }
    
    /**
     * @return the actionConts 
     */
    public String getActionConts(){
       return this.actionConts;
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
	 * @param r2 the r2 to set
	 */
    public void setR2(String r2){
       this.r2 = r2;
    }
    
    /**
     * @return the r2 
     */
    public String getR2(){
       return this.r2;
    }
	
	/**
	 * @param isValid the isValid to set
	 */
    public void setIsValid(String isValid){
       this.isValid = isValid;
    }
    
    /**
     * @return the isValid 
     */
    public String getIsValid(){
       return this.isValid;
    }
}
