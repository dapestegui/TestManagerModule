package com.roche.diagnostics.lis.tmm.laboratoryTest.domain;

public class GlucoseLaboratoryTest extends BiochemistryLaboratoryTest {

	LaboratoryTestNames testName = LaboratoryTestNames.GLUCOSE;

	@Override
	public LaboratoryTestNames getTestName() {
		return testName;
	}
}
