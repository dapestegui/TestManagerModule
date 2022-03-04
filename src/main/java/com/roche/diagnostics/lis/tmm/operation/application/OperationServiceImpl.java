package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationFactory;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationService;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

public class OperationServiceImpl implements OperationService {
	@Override
	public LaboratoryTest applyOperation(LaboratoryTest laboratoryTest, OperationNames operationName) {

		Operation op = OperationFactory.getOperation(laboratoryTest.getTestName(), operationName);

		laboratoryTest = op.execute(laboratoryTest);

		return laboratoryTest;
	}
}
