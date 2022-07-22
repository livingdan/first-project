package com.skillstorm.beans;

import java.io.Serializable;
import java.util.Objects;

public class Expense implements Serializable{
	private int id;
	private String name;
	private String reason;
	private String notes;
	ReimbursementStatus status;

	public Expense() {
		super();
	}
	
	public Expense(String name, String reason, String notes) {
		super();
		this.name = name;
		this.reason = reason;
		this.notes = notes;
		this.status = new ReimbursementStatus();
	}
	
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", reason=" + reason + ", notes=" + notes + ", status=" + status
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, notes, reason, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(notes, other.notes)
				&& Objects.equals(reason, other.reason) && Objects.equals(status, other.status);
	}



}
