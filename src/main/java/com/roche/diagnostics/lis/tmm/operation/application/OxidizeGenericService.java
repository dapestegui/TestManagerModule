package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationFactory;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.Oxidize;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationExecutor;
import com.roche.diagnostics.lis.tmm.operation.infraestructure.OperationRepositoryImpl;

import java.util.UUID;

public class OxidizeGenericService implements OperationExecutor {

	OperationRepository operationRepository= new OperationRepositoryImpl();

	@Override
	public LaboratoryTest applyOperation(LaboratoryTest laboratoryTest) {

		Operation op = new Oxidize();

		laboratoryTest = op.execute(laboratoryTest);

		operationRepository.save(op);

		return laboratoryTest;
	}
}
