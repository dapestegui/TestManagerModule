package com.roche.diagnostics.lis.tmm.domain.laboratoryTest;


import com.roche.diagnostics.lis.tmm.domain.sample.Sample;

import java.math.BigInteger;
import java.util.UUID;

public interface LaboratoryTest {

	UUID getTestId();

	BigInteger getOrderId();

	void setOrderId(BigInteger orderId);

	Sample getSample();

	void setSample(Sample sampleId);

	LaboratoryTestCategories getTestCategory();

	LaboratoryTestNames getTestName();

}
