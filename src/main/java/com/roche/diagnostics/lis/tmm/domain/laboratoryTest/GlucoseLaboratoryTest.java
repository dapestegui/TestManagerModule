package com.roche.diagnostics.lis.tmm.domain.laboratoryTest;

public class GlucoseLaboratoryTest extends BiochemistryLaboratoryTest {

	LaboratoryTestNames testName = LaboratoryTestNames.GLUCOSE;

	@Override
	public LaboratoryTestNames getTestName() {
		return testName;
	}
}
