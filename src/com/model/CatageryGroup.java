package com.model;

import java.util.List;

public class CatageryGroup {
	private int id;
	private String name;
	private List<Catagery> catageryList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Catagery> getCatageryList() {
		return catageryList;
	}
	public void setCatageryList(List<Catagery> catageryList) {
		this.catageryList = catageryList;
	}
}
