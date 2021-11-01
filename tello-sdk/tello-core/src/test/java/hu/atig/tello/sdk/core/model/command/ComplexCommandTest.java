package hu.atig.tello.sdk.core.model.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hu.atig.tello.sdk.core.model.drone.Flip;

class ComplexCommandTest {

	@Test
	void composeComplexCommandWithSingleIntegerParameter() {
		assertEquals(new ComplexCommand<Integer>(TelloCommandValues.BACKWARD, 20).composeCommand(), "back 20");
		assertEquals(new ComplexCommand<Integer>(TelloCommandValues.BACKWARD, -20).composeCommand(), "back -20");		
	}
	
	@Test
	void composeComplexCommandWithSingleEnumParameter() {
		assertEquals(new ComplexCommand<Flip>(TelloCommandValues.FLIP, Flip.FORWARD).composeCommand(), "flip f");
		assertEquals(new ComplexCommand<Flip>(TelloCommandValues.FLIP, Flip.BACKWARD).composeCommand(), "flip b");
		assertEquals(new ComplexCommand<Flip>(TelloCommandValues.FLIP, Flip.LEFT).composeCommand(), "flip l");
		assertEquals(new ComplexCommand<Flip>(TelloCommandValues.FLIP, Flip.RIGHT).composeCommand(), "flip r");
	}
	
	@Test
	void composeComplexCommandWithMultipleIntegerParameter() {
		assertEquals(new ComplexCommand<Integer>(TelloCommandValues.GO, 100, 100, 100, 200).composeCommand(), "go 100 100 100 200");
		assertEquals(new ComplexCommand<Integer>(TelloCommandValues.GO, -100, -100, -100, 200).composeCommand(), "go -100 -100 -100 200");
		
		assertEquals(new ComplexCommand<Integer>(TelloCommandValues.CURVE, 100, 100, 100, 200, 200, 200, 300).composeCommand(), "curve 100 100 100 200 200 200 300");
		assertEquals(new ComplexCommand<Integer>(TelloCommandValues.CURVE, -100, -100, -100, -200, -200, -200, 300).composeCommand(), "curve -100 -100 -100 -200 -200 -200 300");
	}

}
