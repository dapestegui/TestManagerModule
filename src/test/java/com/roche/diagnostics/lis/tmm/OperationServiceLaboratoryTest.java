package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.operation.application.OperationServiceImpl;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.UreaLaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.OperationNames;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationService;
import com.roche.diagnostics.lis.tmm.sample.domain.Sample;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.UUID;

public class OperationServiceLaboratoryTest extends TestCase {

	OperationService operationService = new OperationServiceImpl();

	public void testHydrolyzeGlucose() {
		LaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(98765L));
		test.setOrderId(BigInteger.valueOf(12345L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.HYDROLYZE);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Glucose Hydrolyzed"));

	}

	public void testOxidizeGlucose() {
		LaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(65646L));
		test.setOrderId(BigInteger.valueOf(223265L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.OXIDIZE);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Oxidized + Glucose Oxidized"));

	}

	public void testHydrolyzeUrea() {
		LaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(95445L));
		test.setOrderId(BigInteger.valueOf(15655L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.HYDROLYZE);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Hydrolyzed"));

	}

	public void testOxidizeUrea() {
		LaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(9566545L));
		test.setOrderId(BigInteger.valueOf(23454L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.OXIDIZE);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Oxidized"));

	}

	public void testFailedGetOperationById(){
		UUID id = UUID.randomUUID();
		boolean failed = false;
		try {
			operationService.getOperationById(id);
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);

	}
}