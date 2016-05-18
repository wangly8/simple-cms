package com.cst.model;

public class TestUser {

	private String id;
	private String name;
	private String text;
	
 public TestUser(String id, String name, String text) {
    super();
    this.id = id;
    this.name = name;
    this.text = text;
}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
