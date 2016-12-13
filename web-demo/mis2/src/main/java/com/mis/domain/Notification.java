package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String subject;
    	@Column
private String content;
    	@Column
private String status;
    	@Column
private Date createDate;
    	@Column
private Date updateDate;
    	@Column
private int createBy;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getSubject(){
        return subject;
     }
     
      public void setSubject(String subject){
        this.subject = subject;
     }
    
     

		public String getContent(){
        return content;
     }
     
      public void setContent(String content){
        this.content = content;
     }
    
     

		public String getStatus(){
        return status;
     }
     
      public void setStatus(String status){
        this.status = status;
     }
    
     

		public Date getCreateDate(){
        return createDate;
     }
     
      public void setCreateDate(Date createDate){
        this.createDate = createDate;
     }
    
     

		public Date getUpdateDate(){
        return updateDate;
     }
     
      public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
     }
    
     

		public int getCreateBy(){
        return createBy;
     }
     
      public void setCreateBy(int createBy){
        this.createBy = createBy;
     }
    
     


}