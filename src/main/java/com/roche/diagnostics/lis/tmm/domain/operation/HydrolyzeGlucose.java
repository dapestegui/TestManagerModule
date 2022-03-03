package com.roche.diagnostics.lis.tmm.domain.operation;

import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public class HydrolyzeGlucose extends Hydrolyze{

	@Override
	public LaboratoryTest execute(LaboratoryTest test) {
		test.getSample().setStatus("Glucose Hydrolyzed");
		return test;
	}
}
