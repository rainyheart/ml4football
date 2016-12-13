package com.mis.domain;

import java.util.List;

public class BioCategoryVo extends BioCategory {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BioCategory> bioCategoryList;

	public List<BioCategory> getBioCategoryList() {
		return bioCategoryList;
	}

	public void setBioCategoryList(List<BioCategory> bioCategoryList) {
		this.bioCategoryList = bioCategoryList;
	}

     


}