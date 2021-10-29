package hu.atig.tello.sdk.core.model.drone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlipTest {

	@Test
	void toStringTest() {
		assertEquals(Flip.BACKWARD.toString(), "b");
		assertEquals(Flip.FORWARD.toString(), "f");
		assertEquals(Flip.LEFT.toString(), "l");
		assertEquals(Flip.RIGHT.toString(), "r");
	}

}
