package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationFactory;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationService;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;

import java.util.UUID;

public class OperationServiceImpl implements OperationService {

	OperationRepository operationRepository= new OperationRepositoryImpl();

	@Override
	public LaboratoryTest applyOperation(LaboratoryTest laboratoryTest, OperationNames operationName) {

		Operation op = OperationFactory.getOperation(laboratoryTest.getTestName(), operationName);

		laboratoryTest = op.execute(laboratoryTest);

		operationRepository.save(op);

		return laboratoryTest;
	}

	@Override
	public Operation getOperationById(UUID id) throws Exception {
		Operation op = operationRepository.getOperationById(id);
		if(op == null){
			throw new Exception("No operation with id: "+ id + " was found.");
		}
		return op;
	}
}
