package com.skillstorm.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Objects;



public class ReimbursementStatus implements Serializable {
	
	private int statusId;
	private String status;
	
	
	public ReimbursementStatus() {
		super();
	}
	
	
	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}


	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", status=" + status + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(status, statusId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		return Objects.equals(status, other.status) && statusId == other.statusId;
	}


}
