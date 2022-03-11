package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import org.springframework.stereotype.Component;

@Component
public class OxidizeGlucose extends Oxidize<GlucoseLaboratoryTest> {

	protected GlucoseLaboratoryTest executeInternal(GlucoseLaboratoryTest laboratoryTest) {
		laboratoryTest = super.executeInternal(laboratoryTest);
		laboratoryTest.getSample().setStatus(laboratoryTest.getSample().getStatus() + " + Glucose Oxidized");
		return laboratoryTest;
	}
}
