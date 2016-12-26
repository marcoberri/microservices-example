package it.marcoberri.ms.common.model;

public class BaseReponseSimpleObject {

	public Boolean operation = true;
	public String message;
	public InfoRestModel info;

	public Boolean getOperation() {
		return operation;
	}

	public void setOperation(Boolean operation) {
		this.operation = operation;
	}

	public InfoRestModel getInfo() {
		return info;
	}

	public void setInfo(InfoRestModel info) {
		this.info = info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
