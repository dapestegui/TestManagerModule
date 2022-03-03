package com.roche.diagnostics.lis.tmm.domain.operation;

import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public class Oxidize implements Operation {
	@Override
	public LaboratoryTest execute(LaboratoryTest laboratoryTest) {
		laboratoryTest.getSample().setStatus("Oxidized");
		return laboratoryTest;
	}
}
