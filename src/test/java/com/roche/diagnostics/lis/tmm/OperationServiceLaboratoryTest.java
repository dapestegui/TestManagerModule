package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.application.OperationServiceImpl;
import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.UreaLaboratoryTest;
import com.roche.diagnostics.lis.tmm.domain.operation.OperationNames;
import com.roche.diagnostics.lis.tmm.domain.operation.ports.OperationService;
import com.roche.diagnostics.lis.tmm.domain.sample.Sample;
import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.GlucoseLaboratoryTest;
import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTest;
import junit.framework.TestCase;

import java.math.BigInteger;

public class OperationServiceLaboratoryTest extends TestCase {

	OperationService operationService = new OperationServiceImpl();

	public void testHydrolyzeGlucose() {
		LaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(98765L));
		test.setOrderId(BigInteger.valueOf(12345l));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.HYDROLYZE);

		assert(test.getTestId() == test2.getTestId());
		assert(test.getOrderId() == test2.getOrderId());
		assert(test2.getSample().getStatus().equals("Glucose Hydrolyzed"));

	}

	public void testOxidizeGlucose() {
		LaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(65646L));
		test.setOrderId(BigInteger.valueOf(223265L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.OXIDIZE);

		assert(test.getTestId() == test2.getTestId());
		assert(test.getOrderId() == test2.getOrderId());
		assert(test2.getSample().getStatus().equals("Oxidized + Glucose Oxidized"));

	}

	public void testHydrolyzeUrea() {
		LaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(95445L));
		test.setOrderId(BigInteger.valueOf(15655l));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.HYDROLYZE);

		assert(test.getTestId() == test2.getTestId());
		assert(test.getOrderId() == test2.getOrderId());
		assert(test2.getSample().getStatus().equals("Hydrolyzed"));

	}

	public void testOxidizeUrea() {
		LaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(9566545L));
		test.setOrderId(BigInteger.valueOf(23454L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, OperationNames.OXIDIZE);

		assert(test.getTestId() == test2.getTestId());
		assert(test.getOrderId() == test2.getOrderId());
		assert(test2.getSample().getStatus().equals("Oxidized"));

	}
}