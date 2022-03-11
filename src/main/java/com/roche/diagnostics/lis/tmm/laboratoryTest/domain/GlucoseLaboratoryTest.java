package com.roche.diagnostics.lis.tmm.laboratoryTest.domain;

import org.springframework.stereotype.Component;

@Component
public class GlucoseLaboratoryTest extends BiochemistryLaboratoryTest {

	LaboratoryTestNames testName = LaboratoryTestNames.GLUCOSE;

	@Override
	public LaboratoryTestNames getTestName() {
		return testName;
	}
}
