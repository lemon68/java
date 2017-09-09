package org.jjly.framework.orm;

import java.io.Serializable;

public abstract class LongIdEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
