package com.todo.model;

import java.time.LocalDate;

public class Todos {
	private Long id;
	private String title;
	private String description;
	private boolean status;
	private LocalDate target_date;
	private String username;
	
	public Todos() {
		
	}

	public Todos(Long id, String title, String description, boolean status, LocalDate target_date, String username) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.target_date = target_date;
		this.username = username;
	}

	public Todos(String title, String description, boolean status, LocalDate target_date, String username) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.target_date = target_date;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getTarget_date() {
		return target_date;
	}

	public void setTarget_date(LocalDate target_date) {
		this.target_date = target_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	// if two objects are equal their hashcode must always be equal
	// and these methods make sure the hashcode of Todos objects are equal
	@Override
	public int hashCode() {
		final int prime =31;
		int result =1;
		result =prime *result+(int) (id^(id>>>32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) 
			return true;
		
		if(obj==null) 
			return false;
			
		if(getClass() !=obj.getClass()) 
			return false;
			
		Todos other =(Todos) obj;
		if(id!=other.id) 
			return false;
		return true;
	}
}
	
