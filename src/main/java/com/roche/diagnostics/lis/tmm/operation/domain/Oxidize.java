package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public class Oxidize extends AbstractOperation {

	protected LaboratoryTest executeInternal(LaboratoryTest laboratoryTest) {
		laboratoryTest.getSample().setStatus("Oxidized");
		return laboratoryTest;
	}
}
