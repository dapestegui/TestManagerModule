package com.roche.diagnostics.lis.tmm.operation.domain.ports;

import com.roche.diagnostics.lis.tmm.operation.domain.Operation;

import java.util.UUID;

public interface OperationRetriever {

	Operation getOperationById(UUID id) throws Exception;

}
