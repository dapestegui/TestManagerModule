package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.UreaLaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.application.HydrolyzeGlucoseService;
import com.roche.diagnostics.lis.tmm.operation.application.OxidizeGenericService;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationExecutor;
import com.roche.diagnostics.lis.tmm.sample.domain.Sample;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.UUID;

public class HydrolyzeGlucoseServiceTest extends TestCase {

	OperationExecutor operationExecutor = new HydrolyzeGlucoseService();

	public void testHydrolyzeGlucose() {
		LaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(98765L));
		test.setOrderId(BigInteger.valueOf(12345L));
		test.setSample(sample);
		LaboratoryTest test2 = operationExecutor.applyOperation(test);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Glucose Hydrolyzed"));

	}
}