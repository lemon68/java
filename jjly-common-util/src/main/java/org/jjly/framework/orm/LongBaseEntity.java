package org.jjly.framework.orm;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jjly.framework.convertor.JacksonConvertorDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class LongBaseEntity extends LongIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@JsonSerialize(using = JacksonConvertorDateTime.class)
	protected Date addTime;

	@JsonSerialize(using = JacksonConvertorDateTime.class)
	protected Date modTime;

	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getModTime() {
		return this.modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
