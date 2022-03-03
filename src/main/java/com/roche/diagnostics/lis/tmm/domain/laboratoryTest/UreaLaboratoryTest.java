package com.roche.diagnostics.lis.tmm.domain.laboratoryTest;

public class UreaLaboratoryTest extends BiochemistryLaboratoryTest {

	LaboratoryTestNames testName = LaboratoryTestNames.UREA;

	@Override
	public LaboratoryTestNames getTestName() {
		return testName;
	}
}
