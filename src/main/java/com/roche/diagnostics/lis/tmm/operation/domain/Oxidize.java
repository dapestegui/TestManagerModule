package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public class Oxidize implements Operation {
	@Override
	public LaboratoryTest execute(LaboratoryTest laboratoryTest) {
		laboratoryTest.getSample().setStatus("Oxidized");
		return laboratoryTest;
	}
}
