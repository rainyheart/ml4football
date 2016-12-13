package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Images implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String path;
    	@Column
private String foreignId;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getPath(){
        return path;
     }
     
      public void setPath(String path){
        this.path = path;
     }
    
     

		public String getForeignId(){
        return foreignId;
     }
     
      public void setForeignId(String foreignId){
        this.foreignId = foreignId;
     }
    
     


}