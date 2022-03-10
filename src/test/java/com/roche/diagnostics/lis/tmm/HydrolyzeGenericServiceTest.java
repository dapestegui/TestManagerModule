package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.UreaLaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.application.HydrolyzeGenericService;
import com.roche.diagnostics.lis.tmm.operation.application.OxidizeGenericService;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationExecutor;
import com.roche.diagnostics.lis.tmm.sample.domain.Sample;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.UUID;

public class HydrolyzeGenericServiceTest extends TestCase {

	OperationExecutor operationExecutor = new HydrolyzeGenericService();

	public void testHydrolyzeUrea() {
		LaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(95445L));
		test.setOrderId(BigInteger.valueOf(15655L));
		test.setSample(sample);
		LaboratoryTest test2 = operationExecutor.applyOperation(test);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Hydrolyzed"));

	}

}