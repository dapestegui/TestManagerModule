package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public class OxidizeGlucose extends Oxidize{

	protected LaboratoryTest executeInternal(LaboratoryTest laboratoryTest) {
		laboratoryTest = super.executeInternal(laboratoryTest);
		laboratoryTest.getSample().setStatus(laboratoryTest.getSample().getStatus() + " + Glucose Oxidized");
		return laboratoryTest;
	}
}
