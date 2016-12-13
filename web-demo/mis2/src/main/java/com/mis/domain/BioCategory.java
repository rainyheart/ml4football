package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BioCategory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String bioCatName;
	@Column
	private String bioCatDes;
	@Column
	private int bioParentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBioCatName() {
		return bioCatName;
	}

	public void setBioCatName(String bioCatName) {
		this.bioCatName = bioCatName;
	}

	public String getBioCatDes() {
		return bioCatDes;
	}

	public void setBioCatDes(String bioCatDes) {
		this.bioCatDes = bioCatDes;
	}

	public int getBioParentId() {
		return bioParentId;
	}

	public void setBioParentId(int bioParentId) {
		this.bioParentId = bioParentId;
	}

}