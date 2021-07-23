package com.vacaciones.pro.dl.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RequestDTO {

	private Long id;
	private String requestStatus;
	private long qtyDias;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	private Long idCollaborator;

	@Temporal(TemporalType.DATE)
	private Date requestDayBegin;

	@Temporal(TemporalType.DATE)
	private Date requestDayEnd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Long getIdCollaborator() {
		return idCollaborator;
	}
	public void setIdCollaborator(Long idCollaborator) {
		this.idCollaborator = idCollaborator;
	}
	public Date getRequestDayBegin() {
		return requestDayBegin;
	}
	public void setRequestDayBegin(Date requestDayBegin) {
		this.requestDayBegin = requestDayBegin;
	}
	public Date getRequestDayEnd() {
		return requestDayEnd;
	}
	public void setRequestDayEnd(Date requestDayEnd) {
		this.requestDayEnd = requestDayEnd;
	}
	public long getQtyDias() {
		long diff =  getRequestDayEnd().getTime() - getRequestDayBegin().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void setQtyDias(long qtyDias) {
		this.qtyDias = qtyDias;
	}
	
	
	
}
