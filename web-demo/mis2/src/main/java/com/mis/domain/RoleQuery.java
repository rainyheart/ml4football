package com.mis.domain;

import com.mis.domain.Role;

public class RoleQuery extends Role {
	
			/**
            * @fields æ¯å¦æ¥è¯¢
            */
            String _search;
            /**
            * @fields å½åé¡µæ°
            */
            Integer page;
            /**
            *  @fields æ¯é¡µæ¡æ°
            */
            Integer rows;
            /**
            *
            */
            String sidx;
            /**
            * @field æåº
            */
            String sord;

            /**
            * @fields dicNameLike ç»å½åç§°æ¨¡ç³æ¥è¯¢
            */
            private String conditionSql;

            public String getConditionSql() {
            	return conditionSql;
            }

            public void setConditionSql(String conditionSql) {
            	this.conditionSql = conditionSql;
            }

            public String get_search() {
            	return _search;
            }

            public void set_search(String _search) {
            	this._search = _search;
            }

            public Integer getPage() {
            	return page;
            }

            public void setPage(Integer page) {
            	this.page = page;
            }

            public Integer getRows() {
            	return rows;
            }

            public void setRows(Integer rows) {
            	this.rows = rows;
            }

            public String getSidx() {
            	return sidx;
            }

            public void setSidx(String sidx) {
            	this.sidx = sidx;
            }

            public String getSord() {
            	return sord;
            }

            public void setSord(String sord) {
            	this.sord = sord;
            }

}