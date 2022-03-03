package com.roche.diagnostics.lis.tmm.domain.operation;

import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public class OxidizeGlucose extends Oxidize{
	@Override
	public LaboratoryTest execute(LaboratoryTest laboratoryTest) {
		laboratoryTest = super.execute(laboratoryTest);
		laboratoryTest.getSample().setStatus(laboratoryTest.getSample().getStatus() + " + Glucose Oxidized");
		return laboratoryTest;
	}
}
