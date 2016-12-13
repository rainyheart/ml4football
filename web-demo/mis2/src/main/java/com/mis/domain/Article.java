package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String subject;
    	@Column
private String content;
    	@Column
private Date createDate;
    	
    	@OneToOne()
    	@JoinColumn(name = "create_by")
    	private User createBy;
    	@Column
private Date updateDate;
    	@OneToOne()
    	@JoinColumn(name = "update_by")
private User updateBy;
    	@Column
private int status;
    	@Column
private String author;
    	@Column
private Date publishDate;
    	@Column
private String periodicals;
    	@Column
private String dataAnalyzeId;
    

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
    
     

		public Date getCreateDate(){
        return createDate;
     }
     
      public void setCreateDate(Date createDate){
        this.createDate = createDate;
     }
    
     

		public User getCreateBy(){
        return createBy;
     }
     
      public void setCreateBy(User createBy){
        this.createBy = createBy;
     }
    
     

		public Date getUpdateDate(){
        return updateDate;
     }
     
      public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
     }
    
     

		public User getUpdateBy(){
        return updateBy;
     }
     
      public void setUpdateBy(User updateBy){
        this.updateBy = updateBy;
     }
    
     

		public int getStatus(){
        return status;
     }
     
      public void setStatus(int status){
        this.status = status;
     }
    
     

		public String getAuthor(){
        return author;
     }
     
      public void setAuthor(String author){
        this.author = author;
     }
    
     

		public Date getPublishDate(){
        return publishDate;
     }
     
      public void setPublishDate(Date publishDate){
        this.publishDate = publishDate;
     }
    
     

		public String getPeriodicals(){
        return periodicals;
     }
     
      public void setPeriodicals(String periodicals){
        this.periodicals = periodicals;
     }
    
     

		public String getDataAnalyzeId(){
        return dataAnalyzeId;
     }
     
      public void setDataAnalyzeId(String dataAnalyzeId){
        this.dataAnalyzeId = dataAnalyzeId;
     }
    
     


}