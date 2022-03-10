package com.roche.diagnostics.lis.tmm.operation.domain.ports;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;

import java.util.UUID;

public interface OperationService {

	LaboratoryTest applyOperation(LaboratoryTest laboratoryTest, OperationNames operationName);

	Operation getOperationById(UUID id) throws Exception;

}
