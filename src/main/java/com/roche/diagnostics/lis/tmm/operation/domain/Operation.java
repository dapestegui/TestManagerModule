package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public interface Operation {

	LaboratoryTest execute(LaboratoryTest laboratoryTest);
}
