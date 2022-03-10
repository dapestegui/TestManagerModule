package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.UreaLaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.application.OxidizeGenericService;
import com.roche.diagnostics.lis.tmm.operation.application.OxidizeGlucoseService;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationExecutor;
import com.roche.diagnostics.lis.tmm.sample.domain.Sample;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.UUID;

public class OxidizeGlucoseServiceTest extends TestCase {

	OperationExecutor operationExecutor = new OxidizeGlucoseService();

	public void testOxidizeGlucose() {
		LaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(65646L));
		test.setOrderId(BigInteger.valueOf(223265L));
		test.setSample(sample);
		LaboratoryTest test2 = operationExecutor.applyOperation(test);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Oxidized + Glucose Oxidized"));

	}
}