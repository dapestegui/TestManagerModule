package com.roche.diagnostics.lis.tmm.operation.application;

import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRetriever;
import com.roche.diagnostics.lis.tmm.operation.infraestructure.OperationRepositoryImpl;

import java.util.UUID;

public class OperationRetrieverImpl implements OperationRetriever {

	OperationRepository operationRepository= new OperationRepositoryImpl();
	@Override
	public Operation getOperationById(UUID id) throws Exception {
		Operation op = operationRepository.getOperationById(id);
		if(op == null){
			throw new Exception("No operation with id: "+ id + " was found.");
		}
		return op;
	}
}
