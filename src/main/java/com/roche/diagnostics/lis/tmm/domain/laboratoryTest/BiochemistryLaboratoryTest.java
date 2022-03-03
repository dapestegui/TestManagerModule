package com.roche.diagnostics.lis.tmm.domain.laboratoryTest;

public abstract class BiochemistryLaboratoryTest extends AbstractLaboratoryTest {

	LaboratoryTestCategories category = LaboratoryTestCategories.BIOCHEMISTRY;

	@Override
	public LaboratoryTestCategories getTestCategory() {
		return category;
	}
}
