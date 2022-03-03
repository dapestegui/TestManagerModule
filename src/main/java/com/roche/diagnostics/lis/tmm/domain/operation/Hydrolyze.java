package com.roche.diagnostics.lis.tmm.domain.operation;

import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public class Hydrolyze implements Operation{

	@Override
	public LaboratoryTest execute(LaboratoryTest laboratoryTest) {
		laboratoryTest.getSample().setStatus("Hydrolyzed");
		return laboratoryTest;
	}
}
