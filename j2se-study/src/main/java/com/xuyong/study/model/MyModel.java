package com.xuyong.study.model;

public class MyModel {
	
	private String name;
	private int sex;
	private double emplyee;
	
	// alt+shift+s o
	public MyModel(String name, int sex, double emplyee) {
		super();
		this.name = name;
		this.sex = sex;
		this.emplyee = emplyee;
	}

	// alt+shift+s r tab enter shift+tab enter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public double getEmplyee() {
		return emplyee;
	}

	public void setEmplyee(double emplyee) {
		this.emplyee = emplyee;
	}

}
