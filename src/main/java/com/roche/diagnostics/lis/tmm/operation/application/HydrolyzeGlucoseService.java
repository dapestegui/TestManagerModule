package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Hydrolyze;
import com.roche.diagnostics.lis.tmm.operation.domain.HydrolyzeGlucose;
import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationExecutor;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import com.roche.diagnostics.lis.tmm.operation.infraestructure.OperationRepositoryImpl;

public class HydrolyzeGlucoseService implements OperationExecutor {

	OperationRepository operationRepository= new OperationRepositoryImpl();

	@Override
	public LaboratoryTest applyOperation(LaboratoryTest laboratoryTest) {

		Operation op = new HydrolyzeGlucose();

		laboratoryTest = op.execute(laboratoryTest);

		operationRepository.save(op);

		return laboratoryTest;
	}
}
