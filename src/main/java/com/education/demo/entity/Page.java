package com.education.demo.entity;

import java.util.List;
import java.util.Map;

public class Page {
	
	private int records;
	
	private long totalPage;
	
	private int page;
	
	private int rows;
	
	private List gridObjectData;
	
	private List<Map<String, Object>> gridMapData;
	
	private int first;
	
	public int getFirst() {
		this.first = (getPage() - 1) * getRows();
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List getGridObjectData() {
		return gridObjectData;
	}

	public void setGridObjectData(List gridObjectData) {
		this.gridObjectData = gridObjectData;
	}

	public List<Map<String, Object>> getGridMapData() {
		return gridMapData;
	}

	public void setGridMapData(List<Map<String, Object>> gridMapData) {
		this.gridMapData = gridMapData;
	}

}
