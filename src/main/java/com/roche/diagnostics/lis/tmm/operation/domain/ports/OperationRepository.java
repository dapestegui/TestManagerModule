package com.roche.diagnostics.lis.tmm.operation.domain.ports;

import com.roche.diagnostics.lis.tmm.operation.domain.Operation;

import java.util.UUID;

public interface OperationRepository {

	void save(Operation op);

	Operation getOperationById(UUID id);

}
