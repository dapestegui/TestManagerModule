package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public class HydrolyzeGlucose extends Hydrolyze{

	@Override
	public LaboratoryTest execute(LaboratoryTest test) {
		test.getSample().setStatus("Glucose Hydrolyzed");
		return test;
	}
}
