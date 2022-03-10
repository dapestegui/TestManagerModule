package com.roche.diagnostics.lis.tmm.operation.domain.ports;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public interface OperationExecutor {

	LaboratoryTest applyOperation(LaboratoryTest laboratoryTest);

}
