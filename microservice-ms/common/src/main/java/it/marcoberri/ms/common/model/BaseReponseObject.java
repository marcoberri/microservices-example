package it.marcoberri.ms.common.model;

import java.io.Serializable;
import java.util.List;

public class BaseReponseObject<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4518857892162532929L;
	
	public Boolean operation = true;
	public List<T> resultlist;
	public T resultsingle;
	public String error;
	public String[] errorlist;
	//public InfoRestModel info;

	public Boolean getOperation() {
		return operation;
	}

	public void setOperation(Boolean operation) {
		this.operation = operation;
	}

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public T getResultsingle() {
		return resultsingle;
	}

	public void setResultsingle(T resultsingle) {
		this.resultsingle = resultsingle;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String[] getErrorlist() {
		return errorlist;
	}

	public void setErrorlist(String[] errorlist) {
		this.errorlist = errorlist;
	}

	//public InfoRestModel getInfo() {
		//return info;
//	}

//	public void setInfo(InfoRestModel info) {
	//	this.info = info;
//	}

}
