package com.model;

public class Cart {
   private int u_id;
   private int g_id;
	
	
	public Cart() {
	super();
}
	public Cart(int u_id, int g_id) {
	super();
	this.u_id = u_id;
	this.g_id = g_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	
	
	}
