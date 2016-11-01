package it.marcoberri.ms.common.model;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long lastModifyby;
	private Date lastModifyTs;
	
	private Long createdby;
	private Date createTs = new Date();
	
	
	private Date enabledFrom = new Date();
	private Date enabledTo;
	public Long getLastModifyby() {
		return lastModifyby;
	}
	public void setLastModifyby(Long lastModifyby) {
		this.lastModifyby = lastModifyby;
	}
	public Date getLastModifyTs() {
		return lastModifyTs;
	}
	public void setLastModifyTs(Date lastModifyTs) {
		this.lastModifyTs = lastModifyTs;
	}
	public Long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}
	public Date getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	public Date getEnabledFrom() {
		return enabledFrom;
	}
	public void setEnabledFrom(Date enabledFrom) {
		this.enabledFrom = enabledFrom;
	}
	public Date getEnabledTo() {
		return enabledTo;
	}
	public void setEnabledTo(Date enabledTo) {
		this.enabledTo = enabledTo;
	}

	
	
}