package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

import java.util.Date;
import java.util.UUID;

public abstract class AbstractOperation implements Operation{

	UUID id = UUID.randomUUID();
	Date startDate = null;
	Date endDate = null;


	public UUID getId(){
		return id;
	}

	public Date getStartTime(){
		return startDate;
	}

	public Date getEndTime(){
		return endDate;
	}

	public LaboratoryTest execute(LaboratoryTest laboratoryTest){

		startDate = new Date();
		System.out.println("Operation started at: " + startDate);
		laboratoryTest = executeInternal(laboratoryTest);
		endDate = new Date();
		System.out.println("Operation ended at: " + startDate);
		return  laboratoryTest;
	}

	protected abstract LaboratoryTest executeInternal (LaboratoryTest laboratoryTest);
}
