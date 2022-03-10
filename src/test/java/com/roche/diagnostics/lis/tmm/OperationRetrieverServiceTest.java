package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.operation.application.OperationRetrieverImpl;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationRetriever;
import junit.framework.TestCase;

import java.util.UUID;

public class OperationRetrieverServiceTest extends TestCase {

	OperationRetriever operationRetriever = new OperationRetrieverImpl();

	public void testFailedGetOperationById(){
		UUID id = UUID.randomUUID();
		boolean failed = false;
		try {
			operationRetriever.getOperationById(id);
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);

	}
}