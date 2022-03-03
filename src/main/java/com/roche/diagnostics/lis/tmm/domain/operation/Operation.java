package com.roche.diagnostics.lis.tmm.domain.operation;

import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public interface Operation {

	LaboratoryTest execute(LaboratoryTest laboratoryTest);
}
