package com.roche.diagnostics.lis.tmm.domain.operation;

import com.roche.diagnostics.lis.tmm.domain.laboratoryTest.LaboratoryTestNames;

public class OperationFactory {


	public static Operation getOperation(LaboratoryTestNames testName, OperationNames operationName){
		Operation op = null;

		switch (operationName){
			case OXIDIZE:
				op = getOxidizeOperationFromTest(testName);
				break;
			case HYDROLYZE:
				op = getHydrolyzeOperationFromTest(testName);
				break;
		}

		return op;

	}

	public static Operation getOxidizeOperationFromTest(LaboratoryTestNames testName){
		Operation op = new Oxidize();
		switch (testName){
			case GLUCOSE:
				op = new OxidizeGlucose();
			break;
		}
		return op;
	}

	public static Operation getHydrolyzeOperationFromTest(LaboratoryTestNames testName){
		Operation op = new Hydrolyze();
		switch (testName){
			case GLUCOSE:
				op = new HydrolyzeGlucose();
				break;
		}
		return op;
	}

}
