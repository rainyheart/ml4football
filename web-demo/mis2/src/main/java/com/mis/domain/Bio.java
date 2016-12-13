package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String flmc;
    	@Column
private int tSwmcId;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getFlmc(){
        return flmc;
     }
     
      public void setFlmc(String flmc){
        this.flmc = flmc;
     }
    
     

		public int getTSwmcId(){
        return tSwmcId;
     }
     
      public void setTSwmcId(int tSwmcId){
        this.tSwmcId = tSwmcId;
     }
    
     


}