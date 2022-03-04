package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public class Hydrolyze implements Operation{

	@Override
	public LaboratoryTest execute(LaboratoryTest laboratoryTest) {
		laboratoryTest.getSample().setStatus("Hydrolyzed");
		return laboratoryTest;
	}
}
