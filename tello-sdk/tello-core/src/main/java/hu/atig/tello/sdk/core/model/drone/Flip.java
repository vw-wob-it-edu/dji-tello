package hu.atig.tello.sdk.core.model.drone;

public enum Flip {
  LEFT {
	  @Override
	  public String toString() {
		  return "l";
	  }
  },
  RIGHT {
	  @Override
	  public String toString() {
		  return "r";
	  }
  },
  FORWARD {
	  @Override
	  public String toString() {
		  return "f";
	  }
  },
  BACKWARD {
	  @Override
	  public String toString() {
		  return "b";
	  }
  } 

}
