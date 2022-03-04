package com.roche.diagnostics.lis.tmm.laboratoryTest.domain;

public class UreaLaboratoryTest extends BiochemistryLaboratoryTest {

	LaboratoryTestNames testName = LaboratoryTestNames.UREA;

	@Override
	public LaboratoryTestNames getTestName() {
		return testName;
	}
}
