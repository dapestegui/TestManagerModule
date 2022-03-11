package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Hydrolyze;
import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperationServiceImpl<T extends LaboratoryTest, J extends Operation<T>> implements OperationService<T, J>{

	@Autowired
	OperationRepository operationRepository;

	@Override
	public T applyOperation(T laboratoryTest, J operation) {

		laboratoryTest = operation.execute(laboratoryTest);

		operationRepository.save(operation);

		return laboratoryTest;
	}

	@Override
	public J getOperationById(UUID id) throws Exception {
		J op = (J) operationRepository.getOperationById(id);
		if(op == null){
			throw new Exception("No operation with id: "+ id + " was found.");
		}
		return op;
	}
}
