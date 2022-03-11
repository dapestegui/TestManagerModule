package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import org.springframework.stereotype.Component;

@Component
public class HydrolyzeGlucose extends Hydrolyze<GlucoseLaboratoryTest> {

	protected GlucoseLaboratoryTest executeInternal(GlucoseLaboratoryTest test) {
		test.getSample().setStatus("Glucose Hydrolyzed");
		return test;
	}
}
