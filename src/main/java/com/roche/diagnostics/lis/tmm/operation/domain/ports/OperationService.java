package com.roche.diagnostics.lis.tmm.operation.domain.ports;

import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public interface OperationService {

	LaboratoryTest applyOperation(LaboratoryTest laboratoryTest, OperationNames operationName);

}
