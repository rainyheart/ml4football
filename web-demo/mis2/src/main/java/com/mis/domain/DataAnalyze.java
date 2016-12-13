package com.mis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DataAnalyze implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String dataAnalyzeTitle;
	@Column
	private String dataAnalyzeLink;
	
	/**
	 * 
		@Column
		private int dataAnalyzeCatId;
	 */
	
	@OneToOne()
	@JoinColumn(name = "data_analyze_cat_id")
	private DataAnalyzeCategory dataAnalyzeCategory;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataAnalyzeTitle() {
		return dataAnalyzeTitle;
	}

	public void setDataAnalyzeTitle(String dataAnalyzeTitle) {
		this.dataAnalyzeTitle = dataAnalyzeTitle;
	}

	public String getDataAnalyzeLink() {
		return dataAnalyzeLink;
	}

	public void setDataAnalyzeLink(String dataAnalyzeLink) {
		this.dataAnalyzeLink = dataAnalyzeLink;
	}

	public DataAnalyzeCategory getDataAnalyzeCategory() {
		return dataAnalyzeCategory;
	}

	public void setDataAnalyzeCategory(DataAnalyzeCategory dataAnalyzeCategory) {
		this.dataAnalyzeCategory = dataAnalyzeCategory;
	}
	
	

}