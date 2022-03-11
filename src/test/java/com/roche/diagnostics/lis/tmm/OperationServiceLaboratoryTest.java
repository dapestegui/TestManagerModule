package com.roche.diagnostics.lis.tmm;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.UreaLaboratoryTest;
import com.roche.diagnostics.lis.tmm.operation.domain.Hydrolyze;
import com.roche.diagnostics.lis.tmm.operation.domain.HydrolyzeGlucose;
import com.roche.diagnostics.lis.tmm.operation.domain.Oxidize;
import com.roche.diagnostics.lis.tmm.operation.domain.OxidizeGlucose;
import com.roche.diagnostics.lis.tmm.operation.domain.ports.OperationService;
import com.roche.diagnostics.lis.tmm.sample.domain.Sample;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.GlucoseLaboratoryTest;
import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.UUID;

@SpringBootTest
public class OperationServiceLaboratoryTest {

	@Test
	public void testHydrolyzeGlucose(@Autowired OperationService<GlucoseLaboratoryTest, HydrolyzeGlucose> operationService, @Autowired HydrolyzeGlucose op) {
		GlucoseLaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(98765L));
		test.setOrderId(BigInteger.valueOf(12345L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, op);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Glucose Hydrolyzed"));

	}

	@Test
	public void testOxidizeGlucose(@Autowired OperationService<GlucoseLaboratoryTest, OxidizeGlucose> operationService, @Autowired OxidizeGlucose op) {
		GlucoseLaboratoryTest test = new GlucoseLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(65646L));
		test.setOrderId(BigInteger.valueOf(223265L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, op);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Oxidized + Glucose Oxidized"));

	}

	@Test
	public void testHydrolyzeUrea(@Autowired OperationService<UreaLaboratoryTest, Hydrolyze<UreaLaboratoryTest>> operationService, @Autowired Hydrolyze<UreaLaboratoryTest> op) {
		UreaLaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(95445L));
		test.setOrderId(BigInteger.valueOf(15655L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, op);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Hydrolyzed"));

	}

	@Test
	public void testOxidizeUrea(@Autowired OperationService<UreaLaboratoryTest, Oxidize<UreaLaboratoryTest>> operationService, @Autowired Oxidize<UreaLaboratoryTest> op) {
		UreaLaboratoryTest test = new UreaLaboratoryTest();
		Sample sample = new Sample(BigInteger.valueOf(9566545L));
		test.setOrderId(BigInteger.valueOf(23454L));
		test.setSample(sample);
		LaboratoryTest test2 = operationService.applyOperation(test, op);

		assert(test.getTestId().equals(test2.getTestId()));
		assert(test.getOrderId().equals(test2.getOrderId()));
		assert(test2.getSample().getStatus().equals("Oxidized"));

	}

	@Test
	public void testFailedGetOperationById(@Autowired OperationService<UreaLaboratoryTest, Oxidize<UreaLaboratoryTest>> operationService){
		UUID id = UUID.randomUUID();
		boolean failed = false;
		try {
			operationService.getOperationById(id);
		} catch (Exception e) {
			failed = true;
		}
		assert(failed);

	}
}