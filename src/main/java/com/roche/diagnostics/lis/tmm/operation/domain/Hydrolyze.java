package com.roche.diagnostics.lis.tmm.operation.domain;

import com.roche.diagnostics.lis.tmm.laboratoryTest.domain.LaboratoryTest;
import org.springframework.stereotype.Component;

@Component
public class Hydrolyze<T extends LaboratoryTest> extends AbstractOperation<T>{

	protected T executeInternal(T laboratoryTest) {
		laboratoryTest.getSample().setStatus("Hydrolyzed");
		return laboratoryTest;
	}
}
