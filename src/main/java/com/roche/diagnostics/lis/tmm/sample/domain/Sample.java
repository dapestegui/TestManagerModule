package com.roche.diagnostics.lis.tmm.sample.domain;

import java.math.BigInteger;


public class Sample {

	BigInteger id;
	String status = "None";

	public Sample(BigInteger id){
		this.id = id;
	}

	public BigInteger getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}

}
