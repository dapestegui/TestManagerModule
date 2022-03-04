package com.roche.diagnostics.lis.tmm.laboratoryTest.domain;


import com.roche.diagnostics.lis.tmm.sample.domain.Sample;

import java.math.BigInteger;
import java.util.UUID;

public abstract class AbstractLaboratoryTest implements LaboratoryTest {

	BigInteger orderId;
	Sample sample;
	UUID testId = UUID.randomUUID();


	@Override
	public UUID getTestId() {
		return testId;
	}

	@Override
	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	@Override
	public BigInteger getOrderId() {
		return orderId;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}
}
