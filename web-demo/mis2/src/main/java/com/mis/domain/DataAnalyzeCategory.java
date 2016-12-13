package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DataAnalyzeCategory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String analyzeTypeName;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getAnalyzeTypeName(){
        return analyzeTypeName;
     }
     
      public void setAnalyzeTypeName(String analyzeTypeName){
        this.analyzeTypeName = analyzeTypeName;
     }
    
     


}