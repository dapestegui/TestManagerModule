package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

import java.util.Date;
import java.util.UUID;


public interface Operation {

	LaboratoryTest execute(LaboratoryTest laboratoryTest);

	Date getStartTime();

	Date getEndTime();

	UUID getId();
}
