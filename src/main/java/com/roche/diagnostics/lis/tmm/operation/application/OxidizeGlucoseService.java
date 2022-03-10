package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.Oxidize;
import com.roche.diagnostics.lis.tmm.operation.domain.OxidizeGlucose;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationExecutor;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import com.roche.diagnostics.lis.tmm.operation.infraestructure.OperationRepositoryImpl;

public class OxidizeGlucoseService implements OperationExecutor {

	OperationRepository operationRepository= new OperationRepositoryImpl();

	@Override
	public LaboratoryTest applyOperation(LaboratoryTest laboratoryTest) {

		Operation op = new OxidizeGlucose();

		laboratoryTest = op.execute(laboratoryTest);

		operationRepository.save(op);

		return laboratoryTest;
	}
}
