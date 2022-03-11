package com.roche.diagnostics.lis.tmm.operation.infraestructure;

import com.roche.diagnostics.lis.tmm.operation.domain.Operation;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperationRepositoryImpl implements OperationRepository {
	@Override
	public void save(Operation op) {
		System.out.println("Operation with id: " + op.getId() + " saved.");
	}

	@Override
	public Operation getOperationById(UUID id) {
		return null;
	}
}
