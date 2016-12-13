package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String roleName;
    	@Column
private String roleDesc;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getRoleName(){
        return roleName;
     }
     
      public void setRoleName(String roleName){
        this.roleName = roleName;
     }
    
     

		public String getRoleDesc(){
        return roleDesc;
     }
     
      public void setRoleDesc(String roleDesc){
        this.roleDesc = roleDesc;
     }
    
     


}