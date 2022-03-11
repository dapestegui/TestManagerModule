package com.roche.diagnostics.lis.tmm.operation.domain.ports;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Operation;

import java.util.UUID;

public interface OperationService<T extends LaboratoryTest, J extends Operation<T> > {

	 T applyOperation(T laboratoryTest, J operation);

	J getOperationById(UUID id) throws Exception;

}
