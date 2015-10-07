/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ketayao.ketacustom.entity.Idable;

@Entity
@Table(name="t_company")
public class Company implements Idable<String>{
    
	@Id
    @Column(length=32,name="COMPANY_ID")
    private String id;
    
	/**
	 * 
	 */
    @Column(length=64)
    private String companyName;
    
	/**
	 * 
	 */
    @Column(length=200)
    private String address;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String companyPerson;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String orgCode;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String mobile;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String companyType;
    
	/**
	 * 
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String portraiture;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String email;
    
	/**
	 * 
	 */
    @Column(length=65535)
    private String rmks;
    
	/**
	 * 
	 */
    @Column(length=200)
    private String areaSelf;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String companyRank;
    
	/**
	 * 
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String contactsname;
    
	/**
	 * 
	 */
    @Column(length=100)
    private String companyUrl;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName4;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone4;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName5;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String area;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone5;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName6;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone6;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName7;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone7;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName8;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone8;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName3;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone3;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String userName2;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String telephone2;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String qzyld;
    
	/**
	 * 
	 */
    @Column(length=32)
    private String qfgld;
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param companyName the companyName to set
	 */
    public void setCompanyName(String companyName){
       this.companyName = companyName;
    }
    
    /**
     * @return the companyName 
     */
    public String getCompanyName(){
       return this.companyName;
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
	 * @param companyPerson the companyPerson to set
	 */
    public void setCompanyPerson(String companyPerson){
       this.companyPerson = companyPerson;
    }
    
    /**
     * @return the companyPerson 
     */
    public String getCompanyPerson(){
       return this.companyPerson;
    }
	
	/**
	 * @param orgCode the orgCode to set
	 */
    public void setOrgCode(String orgCode){
       this.orgCode = orgCode;
    }
    
    /**
     * @return the orgCode 
     */
    public String getOrgCode(){
       return this.orgCode;
    }
	
	/**
	 * @param telephone the telephone to set
	 */
    public void setTelephone(String telephone){
       this.telephone = telephone;
    }
    
    /**
     * @return the telephone 
     */
    public String getTelephone(){
       return this.telephone;
    }
	
	/**
	 * @param mobile the mobile to set
	 */
    public void setMobile(String mobile){
       this.mobile = mobile;
    }
    
    /**
     * @return the mobile 
     */
    public String getMobile(){
       return this.mobile;
    }
	
	/**
	 * @param companyType the companyType to set
	 */
    public void setCompanyType(String companyType){
       this.companyType = companyType;
    }
    
    /**
     * @return the companyType 
     */
    public String getCompanyType(){
       return this.companyType;
    }
	
	/**
	 * @param registerTime the registerTime to set
	 */
    public void setRegisterTime(Date registerTime){
       this.registerTime = registerTime;
    }
    
    /**
     * @return the registerTime 
     */
    public Date getRegisterTime(){
       return this.registerTime;
    }
	
	/**
	 * @param portraiture the portraiture to set
	 */
    public void setPortraiture(String portraiture){
       this.portraiture = portraiture;
    }
    
    /**
     * @return the portraiture 
     */
    public String getPortraiture(){
       return this.portraiture;
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
	 * @param areaSelf the areaSelf to set
	 */
    public void setAreaSelf(String areaSelf){
       this.areaSelf = areaSelf;
    }
    
    /**
     * @return the areaSelf 
     */
    public String getAreaSelf(){
       return this.areaSelf;
    }
	
	/**
	 * @param companyRank the companyRank to set
	 */
    public void setCompanyRank(String companyRank){
       this.companyRank = companyRank;
    }
    
    /**
     * @return the companyRank 
     */
    public String getCompanyRank(){
       return this.companyRank;
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
	 * @param contactsname the contactsname to set
	 */
    public void setContactsname(String contactsname){
       this.contactsname = contactsname;
    }
    
    /**
     * @return the contactsname 
     */
    public String getContactsname(){
       return this.contactsname;
    }
	
	/**
	 * @param companyUrl the companyUrl to set
	 */
    public void setCompanyUrl(String companyUrl){
       this.companyUrl = companyUrl;
    }
    
    /**
     * @return the companyUrl 
     */
    public String getCompanyUrl(){
       return this.companyUrl;
    }
	
	/**
	 * @param userName4 the userName4 to set
	 */
    public void setUserName4(String userName4){
       this.userName4 = userName4;
    }
    
    /**
     * @return the userName4 
     */
    public String getUserName4(){
       return this.userName4;
    }
	
	/**
	 * @param telephone4 the telephone4 to set
	 */
    public void setTelephone4(String telephone4){
       this.telephone4 = telephone4;
    }
    
    /**
     * @return the telephone4 
     */
    public String getTelephone4(){
       return this.telephone4;
    }
	
	/**
	 * @param userName5 the userName5 to set
	 */
    public void setUserName5(String userName5){
       this.userName5 = userName5;
    }
    
    /**
     * @return the userName5 
     */
    public String getUserName5(){
       return this.userName5;
    }
	
	/**
	 * @param area the area to set
	 */
    public void setArea(String area){
       this.area = area;
    }
    
    /**
     * @return the area 
     */
    public String getArea(){
       return this.area;
    }
	
	/**
	 * @param telephone5 the telephone5 to set
	 */
    public void setTelephone5(String telephone5){
       this.telephone5 = telephone5;
    }
    
    /**
     * @return the telephone5 
     */
    public String getTelephone5(){
       return this.telephone5;
    }
	
	/**
	 * @param userName6 the userName6 to set
	 */
    public void setUserName6(String userName6){
       this.userName6 = userName6;
    }
    
    /**
     * @return the userName6 
     */
    public String getUserName6(){
       return this.userName6;
    }
	
	/**
	 * @param telephone6 the telephone6 to set
	 */
    public void setTelephone6(String telephone6){
       this.telephone6 = telephone6;
    }
    
    /**
     * @return the telephone6 
     */
    public String getTelephone6(){
       return this.telephone6;
    }
	
	/**
	 * @param userName7 the userName7 to set
	 */
    public void setUserName7(String userName7){
       this.userName7 = userName7;
    }
    
    /**
     * @return the userName7 
     */
    public String getUserName7(){
       return this.userName7;
    }
	
	/**
	 * @param telephone7 the telephone7 to set
	 */
    public void setTelephone7(String telephone7){
       this.telephone7 = telephone7;
    }
    
    /**
     * @return the telephone7 
     */
    public String getTelephone7(){
       return this.telephone7;
    }
	
	/**
	 * @param userName8 the userName8 to set
	 */
    public void setUserName8(String userName8){
       this.userName8 = userName8;
    }
    
    /**
     * @return the userName8 
     */
    public String getUserName8(){
       return this.userName8;
    }
	
	/**
	 * @param telephone8 the telephone8 to set
	 */
    public void setTelephone8(String telephone8){
       this.telephone8 = telephone8;
    }
    
    /**
     * @return the telephone8 
     */
    public String getTelephone8(){
       return this.telephone8;
    }
	
	/**
	 * @param userName3 the userName3 to set
	 */
    public void setUserName3(String userName3){
       this.userName3 = userName3;
    }
    
    /**
     * @return the userName3 
     */
    public String getUserName3(){
       return this.userName3;
    }
	
	/**
	 * @param telephone3 the telephone3 to set
	 */
    public void setTelephone3(String telephone3){
       this.telephone3 = telephone3;
    }
    
    /**
     * @return the telephone3 
     */
    public String getTelephone3(){
       return this.telephone3;
    }
	
	/**
	 * @param userName2 the userName2 to set
	 */
    public void setUserName2(String userName2){
       this.userName2 = userName2;
    }
    
    /**
     * @return the userName2 
     */
    public String getUserName2(){
       return this.userName2;
    }
	
	/**
	 * @param telephone2 the telephone2 to set
	 */
    public void setTelephone2(String telephone2){
       this.telephone2 = telephone2;
    }
    
    /**
     * @return the telephone2 
     */
    public String getTelephone2(){
       return this.telephone2;
    }
	
	/**
	 * @param qzyld the qzyld to set
	 */
    public void setQzyld(String qzyld){
       this.qzyld = qzyld;
    }
    
    /**
     * @return the qzyld 
     */
    public String getQzyld(){
       return this.qzyld;
    }
	
	/**
	 * @param qfgld the qfgld to set
	 */
    public void setQfgld(String qfgld){
       this.qfgld = qfgld;
    }
    
    /**
     * @return the qfgld 
     */
    public String getQfgld(){
       return this.qfgld;
    }
}
