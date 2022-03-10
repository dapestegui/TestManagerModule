package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;


public class Hydrolyze extends AbstractOperation{

	protected LaboratoryTest executeInternal(LaboratoryTest laboratoryTest) {
		laboratoryTest.getSample().setStatus("Hydrolyzed");
		return laboratoryTest;
	}
}
