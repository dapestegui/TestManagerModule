package com.roche.diagnostics.lis.tmm.application;

import com.roche.diagnostics.lis.tmm.domain.operation.Operation;
import com.roche.diagnostics.lis.tmm.domain.operation.OperationFactory;
import com.roche.diagnostics.lis.tmm.domain.operation.OperationNames;
import com.roche.diagnostics.lis.tmm.domain.operation.ports.OperationService;
import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;

public class OperationServiceImpl implements OperationService {
	@Override
	public LaboratoryTest applyOperation(LaboratoryTest laboratoryTest, OperationNames operationName) {

		Operation op = OperationFactory.getOperation(laboratoryTest.getTestName(), operationName);

		laboratoryTest = op.execute(laboratoryTest);

		return laboratoryTest;
	}
}
