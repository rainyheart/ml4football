package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resource implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String resources;
    	@Column
private int roleId;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getResources(){
        return resources;
     }
     
      public void setResources(String resources){
        this.resources = resources;
     }
    
     

		public int getRoleId(){
        return roleId;
     }
     
      public void setRoleId(int roleId){
        this.roleId = roleId;
     }
    
     


}