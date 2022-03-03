package com.roche.diagnostics.lis.tmm.domain.operation.ports;

import com.roche.diagnostics.lis.tmm.domain.operation.OperationNames;
import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public interface OperationService {

	LaboratoryTest applyOperation(LaboratoryTest laboratoryTest, OperationNames operationName);

}
